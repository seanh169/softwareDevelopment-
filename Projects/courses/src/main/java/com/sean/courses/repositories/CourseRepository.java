package com.sean.courses.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sean.courses.models.Course;

@Repository
public interface CourseRepository extends CrudRepository<Course, Long> {
	@Query(value="SELECT * FROM course BY DATE ASC", nativeQuery = true)
	List<Course> findAllCourseNamesWithId();
}
