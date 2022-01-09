package tsc.javaeeproject.Service.impl;

import tsc.javaeeproject.Dao.AcademyadDao;
import tsc.javaeeproject.Dao.impl.AcademyadDaoImpl;
import tsc.javaeeproject.Domain.Academyad;
import tsc.javaeeproject.Service.AcademyadService;

import java.util.List;
import java.util.Map;

public class AcademyadServiceImpl implements AcademyadService {
    private AcademyadDao academyadDao = new AcademyadDaoImpl();
    @Override
    public boolean login(Academyad academyad) {
        Academyad acade = academyadDao.findByAcaidAndPassword(academyad);
        if (acade !=null)
            return true;
        else
            return false;
    }

    @Override
    public Academyad findAcademyadById(String id) {
        return academyadDao.findAcademyadByID(id);
    }

    @Override
    public List<Map<String, Object>> findAllAcademyad() {
        return academyadDao.getAcademyad();
    }

    @Override
    public boolean deleteAcademyadByID(String id) {
        return academyadDao.deleteByID(id);
    }

    @Override
    public boolean update(Academyad academyad) {
        return academyadDao.update(academyad);
    }

    @Override
    public boolean regist(Academyad academyad) {
        Academyad aca = academyadDao.findAcademyadByID(String.valueOf(academyad.getAca_id()));
        if (aca != null) {
            return false;
        }
        academyadDao.save(academyad);
        return true;
    }
}
