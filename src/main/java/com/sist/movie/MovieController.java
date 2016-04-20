package com.sist.movie;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.movie.dao.MovieDTO;
import com.movie.dao.MovieManager;
import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;

@Controller("movie")
public class MovieController {
	@RequestMapping("movie.do")
	public String movie_main(HttpServletRequest req){
		
		MovieManager movieManager=new MovieManager();
		List<MovieDTO> list=movieManager.movieAllData();
		req.setAttribute("list", list);
		req.setAttribute("jsp", "movie/movie_main.jsp");
		return "user/main.jsp";
	}
}































