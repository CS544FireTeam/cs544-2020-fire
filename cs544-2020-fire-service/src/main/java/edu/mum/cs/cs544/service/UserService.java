package edu.mum.cs.cs544.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.cs.cs544.dao.AdminRepository;
import edu.mum.cs.cs544.model.Admin;

@Service
@Transactional
public class UserService {
	
	@Autowired
    private AdminRepository adminRepository;
	
	public List<Admin> findAll(){
		return adminRepository.findAll();
	}
	
	
	

}
