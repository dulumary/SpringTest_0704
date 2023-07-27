package com.marondal.spring.test.jpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marondal.spring.test.jpa.domain.Company;
import com.marondal.spring.test.jpa.repository.CompanyRepository;

@Service
public class CompanyService {
	
	@Autowired
	private CompanyRepository companyRepository;
	
	public Company addCompany(String name, String business, String scale, int headcount) {
		
		Company company = Company.builder()
				.name(name)
				.business(business)
				.scale(scale)
				.headcount(headcount)
				.build();
		
		company = companyRepository.save(company);
		
		return company;
		
	}
	
	public Company updateCompany(int id, String scale, int headcount) {
		// id를 기준으로 데이터 조회 
		// 조회된 객체에 수정사항 적용
		// 저장
		Company company = companyRepository.findById(id).orElse(null);
		
		if(company != null) {
			company = company.toBuilder()
			.scale(scale)
			.headcount(headcount)
			.build();
			
			company = companyRepository.save(company);
		}
		
		return company;
		
	}
	
	
	public void deleteCompany(int id) {
		
		 companyRepository.findById(id).ifPresent(company -> companyRepository.delete(company));
	}

}
