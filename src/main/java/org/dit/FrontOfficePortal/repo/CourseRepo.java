package org.dit.FrontOfficePortal.repo;

import org.dit.FrontOfficePortal.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepo extends JpaRepository<Course,Integer> {
}
