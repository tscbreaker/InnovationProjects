package tsc.javaeeproject.Dao;

import java.util.List;
import java.util.Map;

public interface StuProjectDao {
    void save(int p_id, String stu_id);

    void saveHeaderStu(int p_id, String id);

    List<Map<String, Object>> finStuProject(Object id);

    boolean confirmProject(String id, String p_id);

    List<Map<String, Object>> finSubmitStuProject(Object id);

    List<Map<String, Object>> finMidStuProject(Object id);

    List<Map<String, Object>> finResStuProject(Object id);

    List<Map<String, Object>> finOverStuProject(Object id);
}
