package com.marondal.spring.test.jsp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.marondal.spring.test.jsp.domain.Seller;
import com.marondal.spring.test.jsp.service.SellerService;

@RequestMapping("/jsp/seller")
@Controller
public class SellerController {
	
	@Autowired
	private SellerService sellerService;
	
	@PostMapping("/add")
	@ResponseBody
	public String createSeller(
			@RequestParam("nickname") String nickname
			, @RequestParam("profileUrl") String profileUrl
			, @RequestParam("temperature") double temperature) {
		
		int count = sellerService.addSeller(nickname, profileUrl, temperature);
		
		return "삽입 성공 : " + count;
		
	}
	
	@GetMapping("/input")
	public String sellerInput() {
		
		return "jsp/sellerInput";
		
	}
	
	@GetMapping("/lastseller")
	public String lastSeller(Model model) {
		
		Seller seller = sellerService.getLastSeller();
		
		model.addAttribute("seller", seller);
		
		return "jsp/sellerInfo";
	}
	

	@GetMapping("/info")
	public String seller(
			@RequestParam(value="id", required=false) Integer id
			, Model model) {
		
		Seller seller = null;
		
		if(id == null) {  // 파라미터가 없는 경우 
			seller = sellerService.getLastSeller();
			
		} else {  // id 파라미터가 전달된 경우
			seller = sellerService.getSeller(id);
			
		}
		
		model.addAttribute("seller", seller);
		
		return "jsp/sellerInfo";
	}

}
