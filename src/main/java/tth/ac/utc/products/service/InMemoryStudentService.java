package tth.ac.utc.products.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import tth.ac.utc.products.model.Student;

public class InMemoryStudentService implements StudentService {
    private final List<Student> students = new ArrayList<>();
    private long nextId = 1;

    public InMemoryStudentService() {
        save(new Student(null, "นัฏฐวัฒน์", 4.0));
        save(new Student(null, "ชิษณุพงศ์", 4.0));
        save(new Student(null, "เทียนชัย", 4.0));
    }

    @Override
    public List<Student> findAll() { return students; }
    @Override
    public Optional<Student> findById(Long id){
        return students.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
    }
    @Override
    public Student save(Student student){
        student.setId(nextId++);
        students.add(student);
        return student;
    }
}
