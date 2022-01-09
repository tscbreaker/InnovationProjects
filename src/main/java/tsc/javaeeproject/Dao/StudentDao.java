package tsc.javaeeproject.Dao;

import tsc.javaeeproject.Domain.Student;

import java.util.List;
import java.util.Map;

public interface StudentDao {
    Student findStudentByID(String id);
    Student findByStuidAndPassword(Student student);
    void save(Student student);
    boolean update(Student student);
    List<Map<String, Object>> getStudent();
    List<Map<String, Object>> findStudentByAcademy(String string);
    boolean deleteByID(String id);
}
