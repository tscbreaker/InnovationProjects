package tsc.javaeeproject.Service;

import tsc.javaeeproject.Domain.Teacher;

import java.util.List;
import java.util.Map;

public interface TeacherService {
    boolean login(Teacher teacher);

    boolean regist(Teacher teacher);

    boolean update(Teacher teacher);

    List<Map<String, Object>> findTeacherByAcademy(String aca);

    boolean deleteTeacherByID(String id);

    Teacher findTeacherByID(String id);

    List<Map<String, Object>> findAllTeacher();
}
