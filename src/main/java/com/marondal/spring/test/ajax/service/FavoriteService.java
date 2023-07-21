package com.marondal.spring.test.ajax.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marondal.spring.test.ajax.domain.Favorite;
import com.marondal.spring.test.ajax.repository.FavoriteRepository;

@Service
public class FavoriteService {
	
	@Autowired
	private FavoriteRepository favoriteRepository;
	
	 public List<Favorite> getFavoriteList() {
		 
		 List<Favorite> favoriteList = favoriteRepository.selectFavoriteList();
		 
		 return favoriteList;
	 }
	 
	 public int addFavorite(String name, String url) {
		 int count = favoriteRepository.insertFavorite(name, url);
		 
		 return count;
	 }
	 
	 // url전달 받고 중복 여부 리턴하는 메소드 
	 public boolean isDuplicateUrl(String url) {
		 int count = favoriteRepository.selectCountUrl(url);
		 
//		 if(count == 0) {
//			 return false;
//		 } else {
//			 return true;
//		 }
		 
		 return count != 0;
		 
	 } 

}
