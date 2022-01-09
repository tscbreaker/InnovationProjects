package tsc.javaeeproject.Service.impl;

import tsc.javaeeproject.Dao.*;
import tsc.javaeeproject.Dao.impl.*;
import tsc.javaeeproject.Service.IdentifyService;

public class IdentifyServiceImpl implements IdentifyService {
    StudentDao studentDao = new StudnetDaoImpl();
    TeacherDao teacherDao = new TeacherDaoImpl();
    AcademyadDao academyadDao = new AcademyadDaoImpl();
    SchooladDao schooladDao = new SchooladDaoImpl();
    ExpertDao expertDao = new ExpertDaoImpl();

    @Override
    public int identify(String id) {
        if (studentDao.findStudentByID(id) != null) return 1;
        else if (teacherDao.findTeacherByID(id) !=null) return 2;
        else if (academyadDao.findAcademyadByID(id) != null) return 3;
        else if (schooladDao.findSchooladByID(id) != null) return 4;
        else if (expertDao.findExpertByID(id) != null) return 5;
        else return 0;
    }
}
