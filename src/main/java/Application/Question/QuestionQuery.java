package Application.Question;

public class QuestionQuery {

    public static final String SELECT_RANDOM = "select * from Question where voidind = 'n' order by rand() limit 1";
    public static final String SELECT_RANDOM_BACK = "select * from Question where id = ?";
    public static final String SELECT_MAX_QUESTION = "select max(id) as qid from Question";

}
