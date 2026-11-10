package tth.ac.utc.products.service;

import java.util.Optional;
import java.util.List;
import tth.ac.utc.products.model.Student;

public interface StudentService {
    List<Student> findAll();
    Optional<Student> findById(Long id);

    Student save(Student student);
}
