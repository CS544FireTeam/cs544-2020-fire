package edu.mum.cs.cs544.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Course {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(length = 200, unique = true)
    @NotBlank
    private String code;

    @Column(length = 255)
    @NotBlank
    private String name;
    @Column(length = 200)
    @NotBlank
    private String abbr;
    @Column(length = 255)
    private String description;

    public Course() {
    }

    public Course(String code, String name, String abbr, String description) {
        this.code = code;
        this.name = name;
        this.abbr = abbr;
        this.description = description;
    }

    public String getAbbr() {
        return abbr;
    }

    public void setAbbr(String abbr) {
        this.abbr = abbr;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
