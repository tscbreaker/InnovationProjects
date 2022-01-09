package tsc.javaeeproject.Service;

import tsc.javaeeproject.Domain.Student;

import java.util.List;
import java.util.Map;

public interface StudentService {
    boolean regist(Student student);

    boolean login(Student student);

    boolean update(Student student);

    List<Map<String, Object>> findStudentByAcademy(String string);

    boolean deleteStudentByID(String id);

    Student findStudentByID(String id);

    List<Map<String, Object>> findAllStudent();
}
