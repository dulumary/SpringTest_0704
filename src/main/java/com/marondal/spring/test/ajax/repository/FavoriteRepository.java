package com.marondal.spring.test.ajax.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.marondal.spring.test.ajax.domain.Favorite;

@Repository
public interface FavoriteRepository {
	
	public List<Favorite> selectFavoriteList();
	
	public int insertFavorite(
			@Param("name") String name
			, @Param("url") String url);
	
	
	// 전달된 url과 일치하는 행의 개수를 리턴 
	public int selectCountUrl(@Param("url") String url);

}
