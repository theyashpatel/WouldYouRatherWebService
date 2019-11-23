package Application.Vote;

public class Vote {

    private Integer uid;
    private Integer qid;
    private String voteValue;

    public Vote() { }

    public Vote(Integer uid, Integer qid, String voteValue) {
        this.uid = uid;
        this.qid = qid;
        this.voteValue = voteValue;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getQid() {
        return qid;
    }

    public void setQid(Integer qid) {
        this.qid = qid;
    }

    public String getVoteValue() {
        return voteValue;
    }

    public void setVoteValue(String voteValue) {
        this.voteValue = voteValue;
    }
}
