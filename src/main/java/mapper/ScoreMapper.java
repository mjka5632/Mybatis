package mapper;

import entity.Score;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface ScoreMapper {
    void addScore(Score s);

    Score getScoreById(String id);

    void updateScore(Score student);

    void deleteScoreById(String id);

    String question1(String name);

    Integer question2(String name);

    List<Map<String,String>> question3(String name);

    Integer question4(String cla);
}
