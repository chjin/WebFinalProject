package com.sist.movie;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.movie.dao.MovieDTO;
import com.movie.dao.MovieManager;
import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;

@Controller("mc")
public class MainController {
	@RequestMapping("main.do")
	public String main_page(HttpServletRequest req){
		MovieManager movieManager=new MovieManager();
		
		List<MovieDTO> list=movieManager.movieAllData();
		List<String> rankList=movieManager.movieRank();
		List<String> boxList=movieManager.movieBoxoffice();
		List<String> rList=movieManager.movieReserve();
		
		req.setAttribute("list", list);
		req.setAttribute("rankList", rankList);
		req.setAttribute("rList", rList);
		req.setAttribute("boxList", boxList);
		req.setAttribute("jsp", "default.jsp");
		
		return "user/main.jsp";
	}
}















































