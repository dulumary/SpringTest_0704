package com.marondal.spring.test.ajax;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.marondal.spring.test.ajax.domain.Favorite;
import com.marondal.spring.test.ajax.service.FavoriteService;

@RequestMapping("/ajax/favorite")
@Controller
public class FavoriteController {
	
	@Autowired
	private FavoriteService favoriteService;
	
	@GetMapping("/list")
	public String favoriteList(Model model) {
		
		List<Favorite> favoriteList = favoriteService.getFavoriteList();
		
		
		model.addAttribute("favoriteList", favoriteList);
		
		return "ajax/favorite/list";
		
	}
	
	@GetMapping("/input")
	public String favoriteInput() {
		return "ajax/favorite/input";
	}
	
	@PostMapping("/add")
	@ResponseBody
	public Map<String, String> createFavorite(@RequestParam("name") String name, @RequestParam("url") String url) {
		
		int count = favoriteService.addFavorite(name, url);
		
		// 실행결과 성공여부 
		// 성공 : {"result":"success"}
		// 실패 : {"result":"fail"}
		
		Map<String, String> resultMap = new HashMap<>();
		
		if(count == 1) {
			// 성공
			resultMap.put("result", "success");
		} else {
			// 실패
			resultMap.put("result", "fail");
		}
		return resultMap;
	}
	
	// url을 전달 받고, 중복 여부를 전달하는 API
	@PostMapping("/url_confirm")
	@ResponseBody
	public Map<String, Boolean> isDuplicateUrl(@RequestParam("url") String url) {
		
		// 중복됨 : {"isDuplicate":true}
		// 중복되지 않음 : {"isDuplicate":false}
		
		Map<String, Boolean> resultMap = new HashMap<>();
		
//		if(favoriteService.isDuplicateUrl(url)) {
//			// 중복됨
//			resultMap.put("isDuplicate", true);
//		} else {
//			// 중복 안됨
//			resultMap.put("isDuplicate", false);
//		}
		
		resultMap.put("isDuplicate", favoriteService.isDuplicateUrl(url));
		
		return resultMap;
		
	}
	
	
	// 삭제 API
	@GetMapping("/delete")
	@ResponseBody
	public Map<String, String> deleteFavorite(@RequestParam("id") int id) {
		int count = favoriteService.deleteFavorite(id);
		
		// 성공 : {"result":"success"}
		// 실패 : {"result":"fail"}
		Map<String, String> resultMap = new HashMap<>();
		
		if(count == 1) {
			// 성공
			resultMap.put("result", "success");
		} else {
			// 실패
			resultMap.put("result", "fail");
		}
		
		return resultMap;
	}
	
	
	
	
	

}
