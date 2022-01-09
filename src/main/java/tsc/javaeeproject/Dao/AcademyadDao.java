package tsc.javaeeproject.Dao;

import tsc.javaeeproject.Domain.Academyad;

import java.util.List;
import java.util.Map;

public interface AcademyadDao {
    Academyad findByAcaidAndPassword(Academyad academyad);

    Academyad findAcademyadByID(String id);

    List<Map<String,Object>> getAcademyad();

    boolean deleteByID(String id);

    boolean update(Academyad academyad);

    void save(Academyad academyad);
}
