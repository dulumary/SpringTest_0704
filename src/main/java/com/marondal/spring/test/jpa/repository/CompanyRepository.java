package com.marondal.spring.test.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.marondal.spring.test.jpa.domain.Company;
import com.marondal.spring.test.jpa.domain.Recruit;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {

}
