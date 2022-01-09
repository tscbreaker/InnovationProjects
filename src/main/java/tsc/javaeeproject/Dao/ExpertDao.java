package tsc.javaeeproject.Dao;

import tsc.javaeeproject.Domain.Expert;

public interface ExpertDao {
    Expert findByExidAndPassword(Expert expert);

    Expert findExpertByID(String id);
}
