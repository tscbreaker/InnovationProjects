package tsc.javaeeproject.Dao;

import tsc.javaeeproject.Domain.Project;

import java.util.List;
import java.util.Map;

public interface ProjectDao {
    Project findProjectByID(String p_id);

    Integer save(Project project);

    void saveSubmitReportName(String saveFilename, String p_id);

    void saveMidReportName(String saveFilename, String p_id);

    void saveResReportName(String saveFilename, String p_id);

    List<Map<String, Object>> acadSubmitProject(String p_type);

    List<Map<String, Object>> acadMidProject(String p_type);

    List<Map<String, Object>> acadResProject(String p_type);

    void changePeriod(String p_id, String value);

    void setBeginTime(String p_id);
}
