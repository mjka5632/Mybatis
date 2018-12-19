package entity;

public class Score {
    private String stid;
    private String coid;
    private String score;


    public String getStid() {
        return stid;
    }

    public void setStid(String stid) {
        this.stid = stid;
    }

    public String getCoid() {
        return coid;
    }

    public void setCoid(String coid) {
        this.coid = coid;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Score{" +
                "stid='" + stid + '\'' +
                ", coid='" + coid + '\'' +
                ", score='" + score + '\'' +
                '}';
    }
}
