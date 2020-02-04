package edu.mum.cs.cs544.service.faculty;

import edu.mum.cs.cs544.model.Faculty;

import java.util.List;

public interface IFacultyService {

    public List<Faculty> findAll();

    public Faculty findById(Integer id);

    public Faculty save(Faculty faculty);

    public Faculty update(Faculty faculty);

    public boolean delete(Faculty faculty);

    public boolean delete(Integer id);
}
