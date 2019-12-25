package com.inputabc.ftpd.util;
import java.io.BufferedReader;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

import java.util.ArrayList;
import java.util.List;


import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.SystemUtils;

/**
 * @date 2018/1/3
 * @author 高伟益
 * @version 1.3.1
 */


public class PFileUtils {
	private PFileUtils(){}
	/**
	 * ��ȡ�ļ����ƶ��ַ���������
	 * @param file
	 * @param srcString
	 * @return
	 */
	public final static int getStringCount(File file,String srcString){
		int n = 0;
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file));
			String line = null;
			while((line = br.readLine())!=null){
				int countMatches = StringUtils.countMatches(line,srcString);
				System.out.println(line);
				n+=countMatches;
			}
			br.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}finally{
			if(br!=null)
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		return n;
	}
	
	/**
	 * �༶
	 * @param srcDir
	 * @param descDir
	 */
	public final static void copyDirectoryToDirectory(File srcDir,File descDir){
		descDir = new File(descDir,srcDir.getName());
		descDir.mkdirs();
		File[] files = srcDir.listFiles();
		FileInputStream bis = null;
		PrintStream ps = null;
		for(File file:files){
			if(file.isDirectory()){
			 new File(descDir,file.getName()).mkdirs();
			 copyDirectoryToDirectory(file,new File(descDir,file.getName()));
			}else{
				try {
					bis = new FileInputStream(file);
					ps = new PrintStream(new FileOutputStream(new File(descDir,file.getName())));
					byte[] buffer = new byte[1024*1024];
					int len = 0;
					while((len = bis.read(buffer))!=-1){
						ps.write(buffer,0,len);
						ps.flush();
					}
					bis.close();
					ps.close();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	/**
	 * ��ȡWindows�û�Ŀ¼
	 * @return
	 */
	public final static String getTargetPathOfWin8(){
	       return SystemUtils.USER_HOME+"\\";
	}
	/**
	 * ��ȡWindowsϵͳ���̷���ĸ
	 * @return
	 */
	public final static String getDriveLetter(){
		String userHome = SystemUtils.USER_HOME;
		String dl = userHome.substring(0,userHome.indexOf(":"));
		return dl;
	}
	
    /**
     * ת���ļ���СΪ��ʶ����ļ���С
     * @param size
     * @return
     */
    public final static List<Object> parseFileSize(long size){
    	Long parsedSize = 0L;
    	String sizeType = "";
    	if(size>=1024&&size<1024*1024){
    		parsedSize = (long) (size/1024.0f);
    		sizeType = "KB";
    		
    	}
    	else if(size>=1024*1024&&size<1024*1024*1024){
    		parsedSize = (long)(size/1024*1024.0f);
    		sizeType = "MB";
    	}
    	else if(size>=1024*1024*1024&&size<1024*1024*1024*1024){
    		parsedSize = (long)(size/1024*1024*1024.0f);
    		sizeType = "GB";
    	}
    	List<Object> value = new ArrayList<Object>();
		value.add(parsedSize);
		value.add(sizeType);
		return value;
    }
   
}

