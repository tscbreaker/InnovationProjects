package tsc.javaeeproject.Dao;

import tsc.javaeeproject.Domain.Schoolad;

public interface SchooladDao {
    Schoolad findBySchidAndPassword(Schoolad schoolad);

    Schoolad findSchooladByID(String id);
}
