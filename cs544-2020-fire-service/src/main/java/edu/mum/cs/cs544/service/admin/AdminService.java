package edu.mum.cs.cs544.service.admin;

import edu.mum.cs.cs544.dao.AdminRepository;
import edu.mum.cs.cs544.model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AdminService implements IAdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public List<Admin> findAll() {
        return this.adminRepository.findAll();
    }

    @Override
    public Admin findById(Integer id) {
        Optional<Admin> admin = this.adminRepository.findById(id);
        if(admin.isPresent()) return admin.get();
        else return null;
    }

    @Override
    public Admin save(Admin admin) {
        return this.adminRepository.save(admin);
    }

    @Override
    public Admin update(Admin admin) {
        return this.adminRepository.save(admin);
    }

    @Override
    public boolean delete(Admin admin) {
        this.adminRepository.delete(admin);
        return true;
    }

    @Override
    public boolean delete(Integer id) {
        this.adminRepository.deleteById(id);
        return true;
    }

}
