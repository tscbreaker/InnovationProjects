package tsc.javaeeproject.Service.impl;

import tsc.javaeeproject.Dao.StudentDao;
import tsc.javaeeproject.Dao.impl.StudnetDaoImpl;
import tsc.javaeeproject.Domain.Student;
import tsc.javaeeproject.Service.StudentService;

import java.util.List;
import java.util.Map;

public class StudentServiceImpl implements StudentService {
    private StudentDao studentDao = new StudnetDaoImpl();
    @Override
    public boolean regist(Student student) {
        Student stu = studentDao.findStudentByID(String.valueOf(student.getStu_id()));
        if (stu != null) {
            return false;
        }
        studentDao.save(student);
        return true;
    }

    @Override
    public boolean login(Student student) {
        Student stu = studentDao.findByStuidAndPassword(student);
        if (stu !=null)
            return true;
        else
            return false;
    }

    @Override
    public boolean update(Student student) {
        return studentDao.update(student);
    }

    @Override
    public List<Map<String, Object>> findStudentByAcademy(String string) {
        return studentDao.findStudentByAcademy(string);
    }

    @Override
    public boolean deleteStudentByID(String id) {
        return studentDao.deleteByID(id);
    }

    @Override
    public Student findStudentByID(String id) {
        return studentDao.findStudentByID(id);
    }

    @Override
    public List<Map<String, Object>> findAllStudent() {
        return studentDao.getStudent();
    }
}
