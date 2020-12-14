package net.javaguides.springboot.springsecurity.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import net.javaguides.springboot.springsecurity.model.Student;


@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {
    
    List<Student> findByName(String name);
    
    List<Student> findAll();
    
}
