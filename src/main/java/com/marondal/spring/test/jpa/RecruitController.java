package com.marondal.spring.test.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.marondal.spring.test.jpa.domain.Recruit;
import com.marondal.spring.test.jpa.repository.RecruitRepository;

@RequestMapping("/jpa/recruit/select")
@RestController  // @Controller +  @ResponseBody
public class RecruitController {
	
	@Autowired
	private RecruitRepository recruitRepository;
	
//	id가 8인 공고를 조회하고 아래와 같이 출력하세요.
	@GetMapping("/1")
	public Recruit recruit() {
		
		 Recruit recruit = recruitRepository.findById(8).orElse(null);
		 
		return recruit;
		
	}
	
//	Request Parameter로 전달 받은 company id로 해당하는 회사의 공고를 조회하세요.
	@GetMapping("/2")
	public List<Recruit> recruitByCompanyId(@RequestParam("companyId") int companyId) {
		
		 return recruitRepository.findByCompanyId(companyId);
	}
	
//	웹 back-end 개발자 이고 정규직인 공고를 조회하고 아래와 같이 출력하세요.
	@GetMapping("/3")
	public List<Recruit> recruitByPositionType() {
		return recruitRepository.findByPositionAndType("웹 back-end 개발자", "정규직");
	}
	
//	정규직이거나 연봉이 9000 이상인 공고를 조회하고 아래와 같이 출력하세요.
	@GetMapping("/4")
	public List<Recruit> recruitBySalary() {
		return recruitRepository.findByTypeOrSalaryGreaterThanEqual("정규직", 9000);
	}

}
