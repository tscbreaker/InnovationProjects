package tsc.javaeeproject.Service;

import tsc.javaeeproject.Domain.Academyad;

import java.util.List;
import java.util.Map;

public interface AcademyadService {
    boolean login(Academyad academyad);

    Academyad findAcademyadById(String id);

    List<Map<String,Object>> findAllAcademyad();

    boolean deleteAcademyadByID(String id);

    boolean update(Academyad academyad);

    boolean regist(Academyad academyad);
}
