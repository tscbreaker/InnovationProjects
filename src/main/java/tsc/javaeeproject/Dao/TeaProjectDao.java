package tsc.javaeeproject.Dao;

import java.util.List;
import java.util.Map;

public interface TeaProjectDao {
    void save(int p_id, String tea_id);

    void saveHeaderTea(int p_id, String tea_id);

    List<Map<String, Object>> findSubmitTeaProject(Object id);

    List<Map<String, Object>> findMidTeaProject(Object id);

    List<Map<String, Object>> findResTeaProject(Object id);

    void confirmSubmit(Object p_id, Object id, String suggestion);

    void confirmMid(Object p_id, Object id, String suggestion);

    void confirmRes(Object p_id, Object id, String suggestion);
}
