package tsc.javaeeproject.Service.impl;

import tsc.javaeeproject.Dao.ExProjectDao;
import tsc.javaeeproject.Dao.ProjectDao;
import tsc.javaeeproject.Dao.StuProjectDao;
import tsc.javaeeproject.Dao.TeaProjectDao;
import tsc.javaeeproject.Dao.impl.ExProjectDaoImpl;
import tsc.javaeeproject.Dao.impl.ProjectDapImpl;
import tsc.javaeeproject.Dao.impl.StuProjectDaoImpl;
import tsc.javaeeproject.Dao.impl.TeaProjectDaoImpl;
import tsc.javaeeproject.Domain.ExProject;
import tsc.javaeeproject.Domain.Project;
import tsc.javaeeproject.Service.ProjectService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProjectServiceImpl implements ProjectService {
    ProjectDao projectDao = new ProjectDapImpl();
    TeaProjectDao teaProjectDao = new TeaProjectDaoImpl();
    StuProjectDao stuProjectDao = new StuProjectDaoImpl();
    ExProjectDao exProjectDao = new ExProjectDaoImpl();

    @Override
    public Project findProjectByID(String p_id) {
        return projectDao.findProjectByID(p_id);
    }

    @Override
    public Integer regist(Project project) {
        Integer integer = null;
        try {
            integer = projectDao.save(project);
        } catch (Exception e) {
            return null;
        }
        return integer;
    }

    @Override
    public void saveTea(int p_id, String tea_id) {
        if (tea_id != null && tea_id.length() != 0) {
            teaProjectDao.save(p_id, tea_id);
        }
    }

    @Override
    public void saveStu(int p_id, String stu_id) {
        if (stu_id != null && stu_id.length() != 0) {
            stuProjectDao.save(p_id, stu_id);
        }
    }

    @Override
    public void saveHeadTea(int p_id, String tea_id) {
        teaProjectDao.saveHeaderTea(p_id, tea_id);
    }

    @Override
    public void saveHeadStu(int p_id, String id) {
        stuProjectDao.saveHeaderStu(p_id, id);
    }

    @Override
    public void saveExProject(Integer integer) {
        exProjectDao.saveExProject(integer);
    }

    @Override
    public List<Map<String, Object>> findStuProject(Object id) {
        return stuProjectDao.finStuProject(id);
    }

    @Override
    public List<Map<String, Object>> findSubmitStuProject(Object id) {
        return stuProjectDao.finSubmitStuProject(id);
    }

    @Override
    public void saveReportName(String saveFilename, String p_id, String operate) {
        if (operate.equals("submit"))
            projectDao.saveSubmitReportName(saveFilename, p_id);
        else if (operate.equals("mid"))
            projectDao.saveMidReportName(saveFilename, p_id);
        else if (operate.equals("res"))
            projectDao.saveResReportName(saveFilename, p_id);
    }

    @Override
    public List<Map<String, Object>> findMidStuProject(Object id) {
        return stuProjectDao.finMidStuProject(id);
    }

    @Override
    public List<Map<String, Object>> findResStuProject(Object id) {
        return stuProjectDao.finResStuProject(id);
    }

    @Override
    public List<Map<String, Object>> findOverStuProject(Object id) {
        return stuProjectDao.finOverStuProject(id);
    }

    @Override
    public List<Map<String, Object>> findSubmitTeaProject(Object id) {
        return teaProjectDao.findSubmitTeaProject(id);
    }

    @Override
    public List<Map<String, Object>> findMidTeaProject(Object id) {
        return teaProjectDao.findMidTeaProject(id);
    }

    @Override
    public List<Map<String, Object>> findResTeaProject(Object id) {
        return teaProjectDao.findResTeaProject(id);
    }

    @Override
    public boolean setSuggestion(Object p_id, Object operate, Object id, String suggestion) {
        try {
            if (operate.equals("submit")) {
                teaProjectDao.confirmSubmit(p_id,id,suggestion);
            } else if (operate.equals("mid")) {
                teaProjectDao.confirmMid(p_id,id,suggestion);
            } else if (operate.equals("res")) {
                teaProjectDao.confirmRes(p_id,id,suggestion);
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public List<Map<String, Object>> findNationSubmitProject(Object id) {
        return exProjectDao.findNationSubmitProject(id);
    }

    @Override
    public List<Map<String, Object>> findNationMidProject(Object id) {
        return exProjectDao.findNationMidProject(id);
    }

    @Override
    public List<Map<String, Object>> findNationResProject(Object id) {
        return exProjectDao.findNationResProject(id);
    }

    @Override
    public boolean Score(Object id, String p_id, String operate, String score, String suggestion) {
        try {
            if (operate.equals("未立项")) {
                exProjectDao.setSubmitScore(id,p_id,score,suggestion);
            } else if (operate.equals("已立项")) {
                exProjectDao.setMidScore(id,p_id,score,suggestion);
            } else if (operate.equals("中期")) {
                exProjectDao.setResScore(id,p_id,score,suggestion);
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public List<Map<String, Object>> findProvinceSubmitProject(Object id) {
        return exProjectDao.findProvinceSubmitProject(id);
    }

    @Override
    public List<Map<String, Object>> findProvinceMidProject(Object id) {
        return exProjectDao.findProvinceMidProject(id);
    }

    @Override
    public List<Map<String, Object>> findProvinceResProject(Object id) {
        return exProjectDao.findProvinceResProject(id);
    }

    @Override
    public List<Map<String, Object>> findSchoolSubmitProject(Object id) {
        return exProjectDao.findSchoolSubmitProject(id);
    }

    @Override
    public List<Map<String, Object>> findSchoolMidProject(Object id) {
        return exProjectDao.findSchoolMidProject(id);
    }

    @Override
    public List<Map<String, Object>> findSchoolResProject(Object id) {
        return exProjectDao.findSchoolResProject(id);
    }

    @Override
    public List<Map<String, Object>> findAcademySubmitProject(Object id) {
        return exProjectDao.findAcademySubmitProject(id);
    }

    @Override
    public List<Map<String, Object>> findAcademyMidProject(Object id) {
        return exProjectDao.findAcademyMidProject(id);
    }

    @Override
    public List<Map<String, Object>> findAcademyResProject(Object id) {
        return exProjectDao.findAcademyResProject(id);
    }

    @Override
    public List<Map<String, Object>> acadProject(String id,String p_type) {
        List<Map<String, Object>> temp = new ArrayList<Map<String,Object>>();
        List<Map<String, Object>> submit = projectDao.acadSubmitProject(p_type);
        List<Map<String, Object>> mid = projectDao.acadMidProject(p_type);
        List<Map<String, Object>> res = projectDao.acadResProject(p_type);
        for (Map<String, Object> re : res) {
            submit.add(re);
        }
        for (Map<String, Object> mi : mid) {
            submit.add(mi);
        }
        for (Map<String, Object> map : submit) {
            Object p_id = map.get("p_id");
            String p_period = (String) map.get("p_period");
            String type = "";
            if(map.get("p_type").equals("nation") && map.get("subjecttype").equals("engineer"))
                type = "1";
            else if(map.get("p_type").equals("nation") && map.get("subjecttype").equals("literature"))
                type = "2";
            else if(map.get("p_type").equals("province") && map.get("subjecttype").equals("engineer"))
                type = "3";
            else if(map.get("p_type").equals("province") && map.get("subjecttype").equals("literature"))
                type = "4";
            else if(map.get("p_type").equals("school") && map.get("subjecttype").equals("engineer"))
                type = "5";
            else if(map.get("p_type").equals("school") && map.get("subjecttype").equals("literature"))
                type = "6";
            else if(map.get("p_type").equals("academy") && map.get("subjecttype").equals("engineer"))
                type = "7";
            else if(map.get("p_type").equals("academy") && map.get("subjecttype").equals("literature"))
                type = "8";
            boolean flag = exProjectDao.isScore(p_id,p_period,type);
            if (flag)
                map.put("is_verify","true");
            else
                map.put("is_verify","false");
            temp.add(map);
        }
        return temp;
    }

    @Override
    public List<Map<String, Object>> findExProject(String s, String p_id, String p_period) {
        ExProject project = exProjectDao.findExProject(s,p_id);
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String,Object> map = new HashMap<String,Object>();
        if(p_period.equals("未立项")){
            map.put("score",project.submit_score);
            map.put("suggestion",project.submit_suggestion);
            list.add(map);
        }else if(p_period.equals("已立项")){
            map.put("score",project.mid_score);
            map.put("suggestion",project.mid_suggestion);
            list.add(map);
        }else if(p_period.equals("中期")){
            map.put("score",project.res_score);
            map.put("suggestion",project.res_suggestion);
            list.add(map);
        }
        return list;
    }

    @Override
    public boolean changePeriod(String p_id, String p_period1) {
        try {
            System.out.println(p_period1);
            if (p_period1.equals("未立项"))
                projectDao.changePeriod(p_id,"已立项");
            else if (p_period1.equals("已立项"))
                projectDao.changePeriod(p_id,"中期");
            else if (p_period1.equals("中期"))
                projectDao.changePeriod(p_id,"结题");
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public void setBeginTime(String p_id) {
        projectDao.setBeginTime(p_id);
    }
}
