package tsc.javaeeproject.Service.impl;

import tsc.javaeeproject.Dao.SchooladDao;
import tsc.javaeeproject.Dao.impl.SchooladDaoImpl;
import tsc.javaeeproject.Domain.Schoolad;
import tsc.javaeeproject.Service.SchooladService;

public class SchooladServiceImpl implements SchooladService {
    SchooladDao schooladDao = new SchooladDaoImpl();
    @Override
    public boolean login(Schoolad schoolad) {
        Schoolad sch = schooladDao.findBySchidAndPassword(schoolad);
        if (sch !=null)
            return true;
        else
            return false;
    }
}
