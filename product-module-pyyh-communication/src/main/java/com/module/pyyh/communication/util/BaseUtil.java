package com.module.pyyh.communication.util;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;

public class BaseUtil {

	//文件选择加载
	public static File[] listFile(String path, String subFileName) throws Exception{
		File f = new File(path);
		File[] fs = f.listFiles(new FileFilter(){
			@Override
			public boolean accept(File pathname) {
				// TODO Auto-generated method stub
				if(pathname.isDirectory()){
					return false;
				}else{
					return pathname.getName().contains(subFileName);
				}
			}});
		return fs;
	}
	//文件读取
	public static byte[] loadFile(String fullPathFileName) throws Exception{
		File f = new File(fullPathFileName);
		FileInputStream fis = new FileInputStream(f);
		byte[] data = new byte[fis.available()];
		fis.read(data);
		fis.close();
		return data;
	}
}
