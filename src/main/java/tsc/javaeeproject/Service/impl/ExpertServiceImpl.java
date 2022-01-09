package tsc.javaeeproject.Service.impl;

import tsc.javaeeproject.Dao.ExpertDao;
import tsc.javaeeproject.Dao.impl.ExpertDaoImpl;
import tsc.javaeeproject.Domain.Expert;
import tsc.javaeeproject.Service.ExpertService;

public class ExpertServiceImpl implements ExpertService {
    ExpertDao expertDao = new ExpertDaoImpl();
    @Override
    public boolean login(Expert expert) {
        Expert ex = expertDao.findByExidAndPassword(expert);
        if (ex !=null)
            return true;
        else
            return false;
    }
}
