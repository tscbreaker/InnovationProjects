package tsc.javaeeproject.Dao;

import tsc.javaeeproject.Domain.Teacher;

import java.util.List;
import java.util.Map;

public interface TeacherDao {
    Teacher findByTeaidAndPassword(Teacher teacher);

    Teacher findTeacherByID(String valueOf);

    void save(Teacher teacher);

    boolean update(Teacher teacher);

    List<Map<String, Object>> findTeacherByAcademy(String string);

    boolean deleteByID(String id);

    List<Map<String, Object>> getTeacher();
}
