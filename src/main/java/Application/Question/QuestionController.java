package Application.Question;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static Application.Question.QuestionQuery.SELECT_RANDOM;

@RestController
public class QuestionController {

    @Autowired
    private QuestionDataService questionService;

    @RequestMapping("/random")
    public Question getRandomQuestion() {
        return questionService.getRandomQuestion(SELECT_RANDOM, null);
    }

    @RequestMapping("/brandom")
    public Question getBackRandomQuestion() {
        return questionService.getRandomQuestionBackRandom();
    }

    @RequestMapping("/updatequestioncount")
    public void updateCount() {
        questionService.selectMaxId();
    }

    @RequestMapping("/question/{qid}")
    public ResponseEntity<?> getQuestion(@PathVariable Integer qid) {
        return questionService.getQuestion(qid);
    }
}
