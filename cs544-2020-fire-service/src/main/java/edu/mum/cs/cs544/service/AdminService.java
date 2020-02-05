package edu.mum.cs.cs544.service;

import edu.mum.cs.cs544.model.Admin;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public interface AdminService {

    List<Admin> getAll(Sort sort);

    Optional<Admin> getById(int id);

    Admin create(Admin loc);

    Admin update(Admin loc);

    void remove(int id);
}
