package tsc.javaeeproject.Dao;

import tsc.javaeeproject.Domain.ExProject;

import java.util.List;
import java.util.Map;

public interface ExProjectDao {
    List<Map<String, Object>> findNationSubmitProject(Object id);

    List<Map<String, Object>> findNationMidProject(Object id);

    List<Map<String, Object>> findNationResProject(Object id);

    void saveExProject(Integer integer);

    void setSubmitScore(Object id, String p_id, String score, String suggestion);

    void setMidScore(Object id, String p_id, String score, String suggestion);

    void setResScore(Object id, String p_id, String score, String suggestion);

    List<Map<String, Object>> findProvinceSubmitProject(Object id);

    List<Map<String, Object>> findProvinceMidProject(Object id);

    List<Map<String, Object>> findProvinceResProject(Object id);

    List<Map<String, Object>> findSchoolSubmitProject(Object id);

    List<Map<String, Object>> findSchoolMidProject(Object id);

    List<Map<String, Object>> findSchoolResProject(Object id);

    List<Map<String, Object>> findAcademySubmitProject(Object id);

    List<Map<String, Object>> findAcademyMidProject(Object id);

    List<Map<String, Object>> findAcademyResProject(Object id);

    boolean isScore(Object p_id, String p_period, String type);

    ExProject findExProject(String s, String p_id);
}
