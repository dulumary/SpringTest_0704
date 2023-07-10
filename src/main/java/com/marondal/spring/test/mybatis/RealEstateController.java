package com.marondal.spring.test.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.marondal.spring.test.mybatis.domain.RealEstate;
import com.marondal.spring.test.mybatis.service.RealEstateService;

@Controller
@RequestMapping("/mybatis/test01")
public class RealEstateController {
	
	@Autowired
	private RealEstateService realEstateService;
	
	// id를 전달 받고, 해당 매물 정보를 json으로 response에 담는다. 
	@RequestMapping("/1")
	@ResponseBody
	public RealEstate realEstate(@RequestParam("id") int id) {
		
		RealEstate realEstate = realEstateService.getRealEstate(id);
		
		return realEstate;
	}
	
	
	// 월세를 전달 받고, 해당 월세보다 낮은 월세 매물 json으로 response에 담는다. 
	@RequestMapping("/2")
	@ResponseBody
	public List<RealEstate> realEstateByRentPrice(@RequestParam("rent") int rentPrice) {
		
		List<RealEstate> realEstateList = realEstateService.getRealEstateByRentPrice(rentPrice);
		
		return realEstateList;
		
	}
	
	// 면적과 가격을 전달 받고, 면적이 더 넓으면서 싼 매물 json response에 담는다.
	@RequestMapping("/3")
	@ResponseBody
	public List<RealEstate> realEstateByAreaPrice(
			@RequestParam("area") int area
			, @RequestParam("price") int price) {
		
		List<RealEstate> realEstateList = realEstateService.getRealEstateByAreaPrice(area, price);
		
		return realEstateList;
	}
	
	
	
	
	

}
