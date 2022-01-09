package tsc.javaeeproject.Service;

import tsc.javaeeproject.Domain.Project;

import java.util.List;
import java.util.Map;

public interface ProjectService {
    Project findProjectByID(String p_id);

    Integer regist(Project project);

    void saveTea(int p_id, String tea_id);

    void saveStu(int p_id, String stu_id);

    void saveHeadTea(int p_id, String tea_id);

    void saveHeadStu(int p_id, String id);

    void saveExProject(Integer integer);

    List<Map<String, Object>> findStuProject(Object id);

    List<Map<String, Object>> findSubmitStuProject(Object id);

    void saveReportName(String saveFilename, String p_id, String operate);

    List<Map<String, Object>> findMidStuProject(Object id);

    List<Map<String, Object>> findResStuProject(Object id);

    List<Map<String, Object>> findOverStuProject(Object id);

    List<Map<String, Object>> findSubmitTeaProject(Object id);

    List<Map<String, Object>> findMidTeaProject(Object id);

    List<Map<String, Object>> findResTeaProject(Object id);

    boolean setSuggestion(Object p_id, Object operate, Object id, String suggestion);

    List<Map<String, Object>> findNationSubmitProject(Object id);

    List<Map<String, Object>> findNationMidProject(Object id);

    List<Map<String, Object>> findNationResProject(Object id);

    boolean Score(Object id, String p_id, String operate, String score, String suggestion);

    List<Map<String, Object>> findProvinceSubmitProject(Object id);

    List<Map<String, Object>> findProvinceMidProject(Object id);

    List<Map<String, Object>> findProvinceResProject(Object id);

    List<Map<String, Object>> findSchoolSubmitProject(Object id);

    List<Map<String, Object>> findSchoolMidProject(Object id);

    List<Map<String, Object>> findSchoolResProject(Object id);

    List<Map<String, Object>> findAcademySubmitProject(Object id);

    List<Map<String, Object>> findAcademyMidProject(Object id);

    List<Map<String, Object>> findAcademyResProject(Object id);

    List<Map<String, Object>> acadProject(String id,String p_type);

    List<Map<String, Object>> findExProject(String s, String p_id, String p_period);

    boolean changePeriod(String p_id, String p_period1);

    void setBeginTime(String p_id);
}
