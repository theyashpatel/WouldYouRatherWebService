package Application.Vote;

public class VoteQuery {
    public static final String TOTAL_COUNT = "select totalvote, avote from Votetwo where qid = ? and voidind = 'n'";
    public static final String ADD_VOTE_A = "update Votetwo set totalvote = totalvote + 1, avote = avote + 1 where qid = ?";
    public static final String ADD_VOTE_B = "update Votetwo set totalvote = totalvote + 1 where qid = ?";
}
