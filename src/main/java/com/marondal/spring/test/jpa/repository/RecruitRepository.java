package com.marondal.spring.test.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.marondal.spring.test.jpa.domain.Recruit;

@Repository
public interface RecruitRepository extends JpaRepository<Recruit, Integer> {
	public List<Recruit> findByCompanyId(int companyId);
	
	// WHERE `position` = #{position} AND `type` = #{type}
	public List<Recruit> findByPositionAndType(String position, String type);
	
	// WHERE `type` = #{type} OR `salary` >= #{salary}
	public List<Recruit> findByTypeOrSalaryGreaterThanEqual(String type, int salary);
}
