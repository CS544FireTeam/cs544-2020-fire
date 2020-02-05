package edu.mum.cs.cs544.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Location {
    @Id
    @GeneratedValue
    private Integer id;
    
    @Column(length = 255, unique = true) @NotBlank
    private String description;

    public Location() {
    }

    public Location(String description) {
		this.description = description;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
