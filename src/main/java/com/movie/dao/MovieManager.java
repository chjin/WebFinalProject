package com.movie.dao;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import oracle.net.aso.p;

public class MovieManager {
	public static void main(String[] args){
		MovieManager movieManger=new MovieManager();
		movieManger.movieAllData();
	}
	
	public List<MovieDTO> movieAllData(){
		List<MovieDTO> list=new ArrayList<>();
		
		try{
			Document document= Jsoup.connect("http://www.cgv.co.kr/movies").get();
			
			Elements titleElement=document.select("div.box-contents strong.title");
			Elements imageElement=document.select("div.box-image a span.thumb-image img");
			Elements gradeElement=document.select("div.box-image a span.thumb-image span");
			Elements rankElement=document.select("div.box-image string.rank");
			
			
			Elements percentElement=document.select("div.box-contents div.score strong.percent span");
			Elements likeElement=document.select("div.box-contents span.like span.like span.count strong i");
			Elements starElement=document.select("div.box-contents span.percent");
			Elements dayElement=document.select("div.box-contents span.txt-info strong");
			
			for(int i=0;i<titleElement.size();i++){
				Element tElement=titleElement.get(i);
				Element pElement=percentElement.get(i);
				Element dElement=dayElement.get(i);
				Element lElement=likeElement.get(i);
				Element sElement=starElement.get(i);
				Element iElement=imageElement.get(i);
				String img=iElement.attr("src");
				
				Element rElement=rankElement.get(i);
				Element gElement=gradeElement.get(i);
				
				
				MovieDTO movieDTO=new MovieDTO();
				movieDTO.setNo(i+1);
				movieDTO.setTitle(tElement.text());
				movieDTO.setReserve(Double.parseDouble(pElement.text().substring(0, pElement.text().lastIndexOf('%'))));
				movieDTO.setImage(img);
				movieDTO.setLike(Integer.parseInt(lElement.text().replace(",", "")));
				movieDTO.setRegdate(dElement.text().substring(0, dElement.text().indexOf("°³ºÀ")));
				movieDTO.setStar(Integer.parseInt(sElement.text().substring(0, sElement.text().lastIndexOf('%'))));
				movieDTO.setRank(Integer.parseInt(rElement.text().substring(3)));
				movieDTO.setGrade(gElement.text());
				
				list.add(movieDTO);
				
			}
			
			
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
				
		return list;
	}
	
	public MovieDTO movieDetail(int no){
		MovieDTO movieDTO=new MovieDTO();
		List<MovieDTO> list=movieAllData();
		movieDTO=list.get(no-1);
		return movieDTO;
	}
	
	public List<String> movieRank(){
		List<String> list=
				new ArrayList<>();
		
		try{
			
			Document document=Jsoup.connect("http://movie.naver.com/movie/sdb/rank/rmovie.nhn").get();
			Elements elements=document.select("td.title div.tit3");
			for(int i=0;i<10;i++){
				Element element=elements.get(i);
				list.add(element.text());
			}
			
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		
		return list;
	}
	
	public List<String> movieReserve(){
		List<String> list=
				new ArrayList<>();
		
		try{
			Document document=Jsoup.connect("http://movie.naver.com/movie/sdb/rank/rreserve.nhn").get();
			Elements elements=document.select("td.title div.tit4");
			for(int i=0;i<10;i++){
				Element element=elements.get(i);
				list.add(element.text());
			}
			
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		
		return list;
	}
	
	public List<String> movieBoxoffice(){
		List<String> list=
				new ArrayList<>();
		
		try{
			Document document=Jsoup.connect("http://movie.naver.com/movie/sdb/rank/rboxoffice.nhn").get();
			Elements elements=document.select("td.title div.tit1");
			for(int i=0;i<10;i++){
				Element element=elements.get(i);
			}
			
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		
		return list;
	}
}














































