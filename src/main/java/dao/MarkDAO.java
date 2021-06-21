package dao;

import entity.Car;
import entity.Mark;

import java.util.List;

public interface MarkDAO {

    void add(Mark mark);

    List<Mark> getAll();
}
