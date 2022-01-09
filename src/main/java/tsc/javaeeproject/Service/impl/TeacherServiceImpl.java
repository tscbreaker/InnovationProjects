package tsc.javaeeproject.Service.impl;

import tsc.javaeeproject.Dao.TeacherDao;
import tsc.javaeeproject.Dao.impl.TeacherDaoImpl;
import tsc.javaeeproject.Domain.Teacher;
import tsc.javaeeproject.Service.TeacherService;

import java.util.List;
import java.util.Map;

public class TeacherServiceImpl implements TeacherService {
    private TeacherDao teacherDao = new TeacherDaoImpl();
    @Override
    public boolean login(Teacher teacher) {
        Teacher tea = teacherDao.findByTeaidAndPassword(teacher);
        if (tea !=null)
            return true;
        else
            return false;
    }

    @Override
    public boolean regist(Teacher teacher) {
        Teacher tea = teacherDao.findTeacherByID(String.valueOf(teacher.getTea_id()));
        if (tea != null) {
            return false;
        }
        teacherDao.save(teacher);
        return true;
    }

    @Override
    public boolean update(Teacher teacher) {
        return teacherDao.update(teacher);
    }

    @Override
    public List<Map<String, Object>> findTeacherByAcademy(String string) {
        return teacherDao.findTeacherByAcademy(string);
    }

    @Override
    public boolean deleteTeacherByID(String id) {
        return teacherDao.deleteByID(id);
    }

    @Override
    public Teacher findTeacherByID(String id) {
        return teacherDao.findTeacherByID(id);
    }

    @Override
    public List<Map<String, Object>> findAllTeacher() {
        return teacherDao.getTeacher();
    }
}
