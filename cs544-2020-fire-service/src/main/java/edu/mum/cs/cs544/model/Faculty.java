package edu.mum.cs.cs544.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Faculty extends User {
    @Id
    @GeneratedValue
    private int id;

    public Faculty() {
    }
}
