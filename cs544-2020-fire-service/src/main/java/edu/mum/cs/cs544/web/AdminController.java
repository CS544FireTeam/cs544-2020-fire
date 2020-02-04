package edu.mum.cs.cs544.web;

import edu.mum.cs.cs544.model.Admin;
import edu.mum.cs.cs544.service.admin.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdminController {

    @Autowired
    private IAdminService adminService;

    @GetMapping(value = "/admins")
    public List<Admin> getAllAdmin(){
        return this.adminService.findAll();
    }

    @GetMapping(value = "/admins/{id}")
    public Admin getAdmin(@PathVariable Integer id){
        return this.adminService.findById(id);
    }

    @PostMapping(value = "/admins")
    public Admin saveAdmin(Admin admin){
        return this.adminService.save(admin);
    }

    @PutMapping(value = "/admins/{id}")
    public Admin updateAdmin(Admin admin){
        return this.adminService.save(admin);
    }

    @DeleteMapping(value = "/admins/{id}")
    public boolean deleteAdmin(@PathVariable Integer id){
        return this.adminService.delete(id);
    }
}
