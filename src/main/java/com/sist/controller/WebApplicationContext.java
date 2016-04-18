package com.sist.controller;

import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class WebApplicationContext {
	List<String> list=new ArrayList<String>();
	
	//»ý¼ºÀÚ
	public WebApplicationContext(String path){
		try{
			SAXParserFactory spf=
					SAXParserFactory.newInstance();
			SAXParser sp=
					spf.newSAXParser();
			
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	}
	
}








































