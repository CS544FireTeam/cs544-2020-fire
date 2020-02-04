package edu.mum.cs.cs544.service.admin;

import edu.mum.cs.cs544.model.Admin;

import java.util.List;

public interface IAdminService {

    public List<Admin> findAll();

    public Admin findById(Integer id);

    public Admin save(Admin admin);

    public Admin update(Admin admin);

    public boolean delete(Admin admin);

    public boolean delete(Integer id);
}
