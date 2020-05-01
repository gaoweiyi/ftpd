package com.inputabc.ftpd.util;

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
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;

import com.inputabc.ftpd.entity.FNode;
/**
 * FNode工具类
 * @author gaoweiyi
 *
 */
public class FNodeUtils {
	private FNodeUtils(){}
	/**
	 * 将File对象封装为FNode对象
	 * @param basePath
	 * @param file
	 * @return
	 */
	public static FNode pack(String basePath,File file,String dateFormat){
		FNode fnode = new FNode();
		fnode.setName(file.getName());
		fnode.setModified(new SimpleDateFormat(dateFormat).format(new Date(file.lastModified())));
		if(file.toString().replace("\\", "/").split(basePath).length==0){//如果搜索出的文件是basePath本身
			fnode.setMainPath(file.toString());
		}else{
			fnode.setMainPath(file.toString().replace("\\", "/").split(basePath)[1].replace("\\", "/"));
		}
		if(file.isDirectory()){
			fnode.setType(1);
			fnode.setSize(0L);
			fnode.setImageName("folder");
		}else{
			fnode.setType(0);
			fnode.setEx(FilenameUtils.getExtension(file.getName()));
			fnode.setSize(file.length());
			fnode.setDisplaySize(FileUtils.byteCountToDisplaySize(file.length()));
			fnode.setImageName(getImageName(fnode.getEx()));
		}
		fnode.setId(UUID.randomUUID().toString().replace("-", ""));
		return fnode;
	}
	/**
	 * 根据文件扩展名获取对应的小图标文件名（小图标文件名的主文件名，不包括后缀名）
	 * @param ex
	 * @return
	 */
	public static String getImageName(String ex) {
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
	/**
	 * 常规排序（默认）
	 * @param list
	 * @return
	 */
	public static List<FNode> sort(List<FNode> fnodes,HttpSession session){
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
	/**
	 * 按名称排序
	 * @param fnodes
	 * @param session
	 * @return
	 */
	public static List<FNode> sortByName(List<FNode> fnodes,HttpSession session){
		List<FNode> dirFNodes = new ArrayList<FNode>();
		List<FNode> fileFNodes = new ArrayList<FNode>();
		final Boolean sortByNameFlag = (Boolean) session.getAttribute("sortByNameFlag");
		Collections.sort(fnodes, new Comparator<FNode>() {

			@Override
			public int compare(FNode fnode1, FNode fnode2) {
				String pinyin1 = PinYinUtils.hanziToPinyin(fnode1.getName(),"");
				String pinyin2 = PinYinUtils.hanziToPinyin(fnode2.getName(),"");
				if(sortByNameFlag){//正序
					return StringUtils.compareIgnoreCase(pinyin1, pinyin2);
				}else{//倒序
					return -(StringUtils.compareIgnoreCase(pinyin1, pinyin2));
				}
			}	
			
		});
		return assign(fnodes, dirFNodes, fileFNodes, "sortByNameFlag", sortByNameFlag, session);	
	}
	/**
	 * 按修改日期排序
	 * @param fnodes
	 * @param session
	 * @return
	 */
	public static List<FNode> sortByModified(List<FNode> fnodes,HttpSession session){
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
	/**
	 * 按文件类型排序
	 * @param fnodes
	 * @param session
	 * @return
	 */
	public static List<FNode> sortByType(List<FNode> fnodes,HttpSession session){
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
	/**
	 * 按文件大小排序
	 * @param fnodes
	 * @param session
	 * @return
	 */
	public static List<FNode> sortBySize(List<FNode> fnodes,HttpSession session){
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
	private static List<FNode> assign(List<FNode> fnodes,List<FNode> dirFNodes,List<FNode> fileFNodes,String sortNamed,Boolean sortNamedObj,HttpSession session){
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

}
