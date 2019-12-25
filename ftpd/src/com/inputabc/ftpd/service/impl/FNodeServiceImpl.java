package com.inputabc.ftpd.service.impl;

import java.io.File;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.inputabc.ftpd.constant.C;
import com.inputabc.ftpd.entity.FNode;
import com.inputabc.ftpd.service.FNodeService;
import com.inputabc.ftpd.util.PinYinUtils;
@Service
public class FNodeServiceImpl implements FNodeService {
	private final static ForkJoinPool forkJoinPool = new ForkJoinPool();
	@Override
	public List<FNode> listFiles(String basePath, String mainPath,Integer sortMethod,HttpSession session) {
		List<FNode> fnodes = new ArrayList<FNode>();
		
		File[] listFiles = new File(basePath.replace("\\", "/"),mainPath.replace("\\","/")).listFiles();
		try {
			for (File file : listFiles) {
				FNode fnode = new FNode();
				fnode.setName(file.getName());
				fnode.setModified(new SimpleDateFormat("yyyy/MM/dd HH:mm").format(new Date(file.lastModified())));
				fnode.setMainPath(file.toString().replace("\\", "/").split(basePath)[1].replace("\\", "/"));
				if(file.isDirectory()){
					fnode.setType(1);
					Boolean showDirSize = Boolean.valueOf(C.configs.get("showDirSize").toString().toLowerCase());
					if(showDirSize){
						Long size = forkJoinPool.invoke(new FileSizeFinder(file));
						fnode.setSize(size);
						fnode.setDisplaySize(FileUtils.byteCountToDisplaySize(size));
					}
					fnode.setSize(0L);
					fnode.setImageName("folder");
				}else{
					fnode.setType(0);
					fnode.setEx(FilenameUtils.getExtension(file.getName()));
					fnode.setSize(file.length());
					fnode.setDisplaySize(FileUtils.byteCountToDisplaySize(file.length()));
					fnode.setImageName(getImageName(fnode.getEx()));
				}
				fnodes.add(fnode);
			}
		} catch (NullPointerException e) {
		}
		if(sortMethod==1){
			//按名称排序
			fnodes = sortByName(fnodes,session);
		}else if(sortMethod==2){
			//按修改日期排序
			fnodes = sortByModified(fnodes,session);
		}else if(sortMethod==3){
			//按类型排序
			fnodes = sortByType(fnodes,session);
		}else if(sortMethod==4){
			//按大小排序
			fnodes = sortBySize(fnodes,session);
		}else{
			fnodes = sort(fnodes,session);
		}
		
		return fnodes;
	}
	@Override
	public String getImageName(String ex) {
		if("ttf".equalsIgnoreCase(ex)||"ttc".equalsIgnoreCase(ex)){
			return "a";
		}
		if("bin".equalsIgnoreCase(ex)){
			return "binary";
		}
		if("c".equalsIgnoreCase(ex)){
			return "c";
		}
		if("img".equalsIgnoreCase(ex)||"ima".equalsIgnoreCase(ex)){
			return "diskimg";
		}
		if("dvi".equalsIgnoreCase(ex)){
			return "dvi";
		}
		if("png".equalsIgnoreCase(ex)||"gif".equalsIgnoreCase(ex)||"jpg".equalsIgnoreCase(ex)||
				"jpeg".equalsIgnoreCase(ex)||"bmp".equalsIgnoreCase(ex)){
			return "image2";
		}
		if("lnk".equalsIgnoreCase(ex)){
			return "link";
		}
		if("mp4".equalsIgnoreCase(ex)||"mpeg".equalsIgnoreCase(ex)||"mpg".equalsIgnoreCase(ex)||
				"avi".equalsIgnoreCase(ex)||"ts".equalsIgnoreCase(ex)||"m2ts".equalsIgnoreCase(ex)||
				"mkv".equalsIgnoreCase(ex)||"mov".equalsIgnoreCase(ex)||"3gp".equalsIgnoreCase(ex)||
				"rm".equalsIgnoreCase(ex)||"rmvb".equalsIgnoreCase(ex)||"wmv".equalsIgnoreCase(ex)||
				"vob".equalsIgnoreCase(ex)){
			return "movie";
		}
		if("pdf".equalsIgnoreCase(ex)){
			return "pdf";
		}
		if("js".equalsIgnoreCase(ex)){
			return "script";
		}
		if("mp3".equalsIgnoreCase(ex)||"mp2".equalsIgnoreCase(ex)||"wma".equalsIgnoreCase(ex)||
				"wv".equalsIgnoreCase(ex)||"aac".equalsIgnoreCase(ex)||"m4a".equalsIgnoreCase(ex)||
				"tts".equalsIgnoreCase(ex)||"flac".equalsIgnoreCase(ex)||"ape".equalsIgnoreCase(ex)||
				"aiff".equalsIgnoreCase(ex)||"ogg".equalsIgnoreCase(ex)){
			return "sound2";
		}
		if("tar".equalsIgnoreCase(ex)||"zip".equalsIgnoreCase(ex)||"rar".equalsIgnoreCase(ex)||"7z".equalsIgnoreCase(ex)||
				"tgz".equalsIgnoreCase(ex)||"iso".equalsIgnoreCase(ex)){
			return "folder.sec";
		}
		if("txt".equalsIgnoreCase(ex)){
			return "text";
		}
		if("html".equalsIgnoreCase(ex)||"htm".equalsIgnoreCase(ex)){
			return "world2";
		}
		else{
			return "generic";
		}
	}
	
	@Override
	public List<FNode> sort(List<FNode> fnodes,HttpSession session){
		if(fnodes==null||fnodes.size()==0){
			return fnodes;
		}
		List<FNode> sortedFNodes = new ArrayList<FNode>();
		List<FNode> dirFNodes = new ArrayList<FNode>();
		List<FNode> fileFNodes = new ArrayList<FNode>();
		for(FNode fnode:fnodes){
			if(fnode.getType()==1){
				dirFNodes.add(fnode);
			}
		}
		for(FNode fnode:fnodes){
			if(fnode.getType()==0){
				fileFNodes.add(fnode);
			}
		}
		List<FNode> sortByExNodes = new ArrayList<FNode>();
		Set<String> exs = new HashSet<String>();
		for(FNode fnode:fileFNodes){
			exs.add(fnode.getEx());
		}
		for (String ex : exs) {
			for(FNode fnode:fileFNodes){
				if(ex.equals(fnode.getEx())){
					sortByExNodes.add(fnode);
				}
			}
		}
		for(FNode fnode:fileFNodes){
			if(StringUtils.isBlank(fnode.getEx())){
				sortByExNodes.add(fnode);
			}
		}
		sortedFNodes.addAll(dirFNodes);	
		sortedFNodes.addAll(sortByExNodes);
		return sortedFNodes;
	}
	
	@Override
	public List<FNode> sortByName(List<FNode> fnodes,HttpSession session){
		List<FNode> dirFNodes = new ArrayList<FNode>();
		List<FNode> fileFNodes = new ArrayList<FNode>();
		final Boolean sortByNameFlag = (Boolean) session.getAttribute("sortByNameFlag");
		Collections.sort(fnodes, new Comparator<FNode>() {

			@Override
			public int compare(FNode fnode1, FNode fnode2) {
				String pinyin1 = PinYinUtils.hanziToPinyin(fnode1.getName(),"");
				String pinyin2 = PinYinUtils.hanziToPinyin(fnode2.getName(),"");
				if(sortByNameFlag){
					return StringUtils.compareIgnoreCase(pinyin1, pinyin2);
				}else{
					return -(StringUtils.compareIgnoreCase(pinyin1, pinyin2));
				}
			}	
			
		});
		return assign(fnodes, dirFNodes, fileFNodes, "sortByNameFlag", sortByNameFlag, session);	
	}
	@Override
	public List<FNode> sortByModified(List<FNode> fnodes,HttpSession session){
		List<FNode> dirFNodes = new ArrayList<FNode>();
		List<FNode> fileFNodes = new ArrayList<FNode>();
		final Boolean sortByModifiedFlag = (Boolean) session.getAttribute("sortByModifiedFlag");
		Collections.sort(fnodes, new Comparator<FNode>() {

			@Override
			public int compare(FNode fnode1, FNode fnode2) {
				long time1 = 0;
				long time2 = 0;
				try {
					time1 = new SimpleDateFormat("yyyy/MM/dd HH:mm").parse(fnode1.getModified()).getTime();
					time2 = new SimpleDateFormat("yyyy/MM/dd HH:mm").parse(fnode2.getModified()).getTime();
				} catch (ParseException e) {
					e.printStackTrace();
				}
				if(sortByModifiedFlag){
					return (int)(time1/50000)-(int)(time2/50000);
				}else{
					return -((int)(time1/50000)-(int)(time2/50000));
				}
				
			}
			
		});
		return assign(fnodes, dirFNodes, fileFNodes, "sortByModifiedFlag", sortByModifiedFlag, session);	
	}
	@Override
	public List<FNode> sortByType(List<FNode> fnodes,HttpSession session){
		if(fnodes==null||fnodes.size()==0){
			return fnodes;
		}
		List<FNode> sortedFNodes = new ArrayList<FNode>();
		List<FNode> dirFNodes = new ArrayList<FNode>();
		List<FNode> fileFNodes = new ArrayList<FNode>();
		for(FNode fnode:fnodes){
			if(fnode.getType()==1){
				dirFNodes.add(fnode);
			}
		}
		for(FNode fnode:fnodes){
			if(fnode.getType()==0){
				fileFNodes.add(fnode);
			}
		}
		List<FNode> sortByExNodes = new ArrayList<FNode>();
		Set<String> exs = new HashSet<String>();
		for(FNode fnode:fileFNodes){
			exs.add(fnode.getEx());
		}
		for (String ex : exs) {
			for(FNode fnode:fileFNodes){
				if(ex.equals(fnode.getEx())){
					sortByExNodes.add(fnode);
				}
			}
		}
		for(FNode fnode:fileFNodes){
			if(StringUtils.isBlank(fnode.getEx())){
				sortByExNodes.add(fnode);
			}
		}
		Boolean sortByTypeFlag = (Boolean) session.getAttribute("sortByTypeFlag");
		if(sortByTypeFlag){
			session.setAttribute("sortByTypeFlag", false);
			sortedFNodes.addAll(dirFNodes);	
			sortedFNodes.addAll(sortByExNodes);
				
		}else{
			session.setAttribute("sortByTypeFlag", true);
			sortedFNodes.addAll(sortByExNodes);
			sortedFNodes.addAll(dirFNodes);		
		}
		return sortedFNodes;
	}
	
	@Override
	public List<FNode> sortBySize(List<FNode> fnodes,HttpSession session){
		List<FNode> dirFNodes = new ArrayList<FNode>();
		List<FNode> fileFNodes = new ArrayList<FNode>();
		final Boolean sortBySizeFlag = (Boolean) session.getAttribute("sortBySizeFlag");
		Collections.sort(fnodes, new Comparator<FNode>() {

			@Override
			public int compare(FNode fnode1, FNode fnode2) {
				if(sortBySizeFlag){
					return new BigDecimal(fnode1.getSize()).compareTo(new BigDecimal(fnode2.getSize()));
				}else{
					return -(new BigDecimal(fnode1.getSize()).compareTo(new BigDecimal(fnode2.getSize())));
				}
			}
		
		});
		return assign(fnodes, dirFNodes, fileFNodes, "sortBySizeFlag", sortBySizeFlag, session);	
	}
	/**
	 * 分配
	 * @param fnodes
	 * @param dirFNodes
	 * @param fileFNodes
	 * @param sortNamed
	 * @param sortNamedObj
	 * @param session
	 * @return
	 */
	private List<FNode> assign(List<FNode> fnodes,List<FNode> dirFNodes,List<FNode> fileFNodes,String sortNamed,Boolean sortNamedObj,HttpSession session){
		List<FNode> sortedFNodes = new ArrayList<FNode>();
		for(FNode fnode:fnodes){
			if(fnode.getType()==1){
				dirFNodes.add(fnode);
			}
		}
		for(FNode fnode:fnodes){
			if(fnode.getType()==0){
				fileFNodes.add(fnode);
			}
		}
		if(sortNamedObj){
			session.setAttribute(sortNamed, false);
			sortedFNodes.addAll(dirFNodes);
			sortedFNodes.addAll(fileFNodes);
		}else{
			session.setAttribute(sortNamed, true);
			sortedFNodes.addAll(fileFNodes);
			sortedFNodes.addAll(dirFNodes);
		}
		return sortedFNodes;
	}
	private static class FileSizeFinder extends RecursiveTask<Long> {
	    /**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		final File file;
	    public FileSizeFinder(final File theFile) {
	        file = theFile;
	    }
	    @Override
	    public Long compute() {
	        long size = 0;
	        if (file.isFile()) {
	            size = file.length();
	        } else {
	            final File[] children = file.listFiles();
	            if (children != null) {
	                List<ForkJoinTask<Long>> tasks = new ArrayList<ForkJoinTask<Long>>();
	                for (final File child : children) {
	                    if (child.isFile()) {
	                        size += child.length();
	                    } else {
	                        tasks.add(new FileSizeFinder(child));
	                    }
	                }
	                for (final ForkJoinTask<Long> task : invokeAll(tasks)) {
	                    size += task.join();
	                }
	            }
	        }
	        return size;
	    }
	}

}
