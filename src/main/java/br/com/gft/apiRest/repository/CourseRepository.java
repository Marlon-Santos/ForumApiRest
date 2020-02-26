package br.com.gft.apiRest.repository;

import br.com.gft.apiRest.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course,Long> {
    public Course findByName(String name);
}
