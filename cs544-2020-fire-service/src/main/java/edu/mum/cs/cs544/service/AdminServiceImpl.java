package edu.mum.cs.cs544.service;

import edu.mum.cs.cs544.dao.AdminRepository;
import edu.mum.cs.cs544.model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminRepository adminRepository;

    @Override
    public List<Admin> getAll(Sort sort) {
        if (sort == null) {
            sort = Sort.by(Direction.ASC, "username");
        }
        return adminRepository.findAll(sort);
    }

    @Override
    public Optional<Admin> getById(int id) {
        return adminRepository.findById(id);
    }

    @Override
    public Admin create(Admin loc) {
        return adminRepository.save(loc);

    }

    @Override
    public Admin update(Admin loc) {
        return adminRepository.save(loc);
    }

    @Override
    public void remove(int id) {
        adminRepository.deleteById(id);
	}
}
