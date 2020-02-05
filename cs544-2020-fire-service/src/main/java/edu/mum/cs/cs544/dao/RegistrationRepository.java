package edu.mum.cs.cs544.dao;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import edu.mum.cs.cs544.model.Registration;

@Repository
public interface RegistrationRepository extends JpaRepository<Registration, Integer>{

//	@Query("select distinct p from Registration p join fetch p.student join fetch p.courseOffering")
//	List<Registration> findAllRegistration(Sort sort);

}
