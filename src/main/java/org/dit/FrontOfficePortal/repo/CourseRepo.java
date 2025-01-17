package org.dit.FrontOfficePortal.repo;

import org.dit.FrontOfficePortal.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CourseRepo extends JpaRepository<Course,Integer> {

    @Query("SELECT c.courseName from Course c ")
    List<String> findByCourseName();

}
