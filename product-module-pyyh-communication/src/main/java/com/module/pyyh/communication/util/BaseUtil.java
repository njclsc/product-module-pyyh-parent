package com.module.pyyh.communication.util;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.lang.reflect.InvocationTargetException;

import com.alibaba.fastjson.JSONObject;

public class BaseUtil {

	/*
	 * 
	 * */
	@SuppressWarnings("unchecked")
	public static <T> T instanceLoader(Class<T> clazz, Class<?>[] parameterTypes, Object[] parameters, String classFullPath) throws Exception{
		T obj = null;
		obj = (T)Class.forName(classFullPath).getConstructor(parameterTypes).newInstance(parameters);
		return obj;
	}
	/*	flag = 1:byte[] to object; 
	*	flag = 2:string to object
	*/
	public static <T> T dataToJson(int flag, Object data, Class<T> clazz){
		T obj = null;
		if(flag == 1){
			byte[] bits = (byte[])data;
			StringBuffer sb = new StringBuffer();
			for(byte b : bits){
				sb.append((char)b);
			}
			obj = JSONObject.toJavaObject(JSONObject.parseObject(sb.toString()), clazz);
		}
		return obj;
	}
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

	public static byte[] loadFile(String fullPathFileName) throws Exception{
		File f = new File(fullPathFileName);
		FileInputStream fis = new FileInputStream(f);
		byte[] data = new byte[fis.available()];
		fis.read(data);
		fis.close();
		return data;
	}
}
