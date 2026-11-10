package tth.ac.utc.products.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tth.ac.utc.products.model.Student;
import tth.ac.utc.products.service.InMemoryStudentService;
import tth.ac.utc.products.service.StudentService;

@RestController
public class StudentController {
    private final StudentService studentService = new InMemoryStudentService();

    @GetMapping("/students")
    public List<Student> list(){
        return studentService.findAll();
    }

    @GetMapping("/student")
    public Student one(@RequestParam Long id){
        return studentService.findById(id).orElse(null);
    }
}
