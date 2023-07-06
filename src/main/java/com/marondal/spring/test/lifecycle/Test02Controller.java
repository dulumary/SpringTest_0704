package com.marondal.spring.test.lifecycle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lifecycle/test02")
public class Test02Controller {
	
	
	@RequestMapping("/1")
	public List<Map<String, Object>> movieList() {
		
		List<Map<String, Object>> movieList = new ArrayList<>();
		
		Map<String, Object> movie = new HashMap<>();
		movie.put("title", "기생충");
		movie.put("director", "봉준호");
		movie.put("time", 131);
		movie.put("rate", 15);
		
		movieList.add(movie);
		
		movie = new HashMap<>();
		movie.put("title", "인생은 아름다워");
		movie.put("director", "로베르토 베니니");
		movie.put("time", 116);
		movie.put("rate", 0);
		movieList.add(movie);
		
		movie = new HashMap<>();
		movie.put("title", "인생은 아름다워");
		movie.put("director", "로베르토 베니니");
		movie.put("time", 116);
		movie.put("rate", 0);
		movieList.add(movie);
		
		
		return movieList;
		
	}
	
	
	@RequestMapping("/2")
	public List<Post> postList() {
		
		List<Post> postList = new ArrayList<>();
		Post post = new Post("안녕하세요 가입인사 드립니다", "hagulu", "안녕하세요 가입했어요. 앞으로 잘 부탁 드립니다.");
		postList.add(post);
		
		post = new Post("헐 대박", "bada", "오늘 화요일이었어, 금요일인줄");
		postList.add(post);
		
		post = new Post("오늘 데이트 한 이야기 해드릴게요", "dulumary", ".....");
		postList.add(post);
		
		return postList;
		
	}
	
	@RequestMapping("/3")
	public ResponseEntity<Post> postError() {
		
		Post post = new Post("안녕하세요 가입인사 드립니다", "hagulu", "안녕하세요 가입했어요. 앞으로 잘 부탁 드립니다.");
		ResponseEntity<Post> entity = new ResponseEntity<>(post, HttpStatus.INTERNAL_SERVER_ERROR);
		
		
		return entity;
		
	}
	

}
