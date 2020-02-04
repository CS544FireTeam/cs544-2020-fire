package edu.mum.cs.cs544.service.courseOffering;

import edu.mum.cs.cs544.dao.CourseOfferingRepository;
import edu.mum.cs.cs544.model.CourseOffering;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CourseOfferingService implements ICourseOfferingService {

    @Autowired
    private CourseOfferingRepository courseOfferingRepository;

    @Override
    public List<CourseOffering> findAll() {
        return this.courseOfferingRepository.findAll();
    }

    @Override
    public CourseOffering findById(Integer id) {
        Optional<CourseOffering> courseOffering = this.courseOfferingRepository.findById(id);
        if(courseOffering.isPresent()) return courseOffering.get();
        else return null;
    }

    @Override
    public CourseOffering save(CourseOffering courseOffering) {
        return this.courseOfferingRepository.save(courseOffering);
    }

    @Override
    public CourseOffering update(CourseOffering courseOffering) {
        return this.courseOfferingRepository.save(courseOffering);
    }

    @Override
    public boolean delete(CourseOffering courseOffering) {
        this.courseOfferingRepository.delete(courseOffering);
        return true;
    }

    @Override
    public boolean delete(Integer id) {
        this.courseOfferingRepository.deleteById(id);
        return true;
    }

}
