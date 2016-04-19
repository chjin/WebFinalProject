package com.sist.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/*
 * package.className
 */

public class FileConfig {
	public static List<String> getFileName(String pack){
		List<String> list=new ArrayList<String>();
		
		try{
			String path="C:\\Users\\cjw\\Documents\\GitStudy\\spring-tool-suite-3.7.3.RELEASE-e4.5.2-win32-x86_64_\\workspace\\WebFinalProject\\src\\main\\java\\";
			
			path=path+pack.replace('.', '\\');
			// \\com\\sist\\board
			
			File dir=new File(path);
			File[] files=dir.listFiles();
			for(File file:files){
				if(file.getName().equals("."))
					continue;
				if(file.isFile()){
					String name=file.getName();
					System.out.println(name);
					
					String ext=name.substring(name.lastIndexOf('.')+1);
					if(ext.equals("java")){
						//com.sist.board.BoardController
						String ff=pack +"."+ name.substring(0, name.lastIndexOf('.'));
						System.out.println(ff);
						list.add(ff);
					}
				}
			}
			
		}catch(Exception ex){;
			System.out.println(ex.getMessage());
		}
		
		
		return list;
	}
}








































































