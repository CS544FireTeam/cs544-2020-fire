package edu.mum.cs.cs544.model;

import javax.persistence.Entity;

@Entity
public class Faculty extends User {

    public Faculty() {
        super();
    }

    public Faculty(String username, String password, String fname, String lname) {
        this.username = username;
        this.password = password;
        this.firstName = fname;
        this.lastName = lname;
        this.role = UserRole.FACULTY;
    }
}
