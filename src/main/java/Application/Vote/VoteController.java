package Application.Vote;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class VoteController {

    @Autowired
    private VoteService voteService;

    @RequestMapping(method = RequestMethod.POST, value = "/addvote")
    public ResponseEntity<?> addVote(@RequestBody Vote v) {
            return voteService.addVote(v);
    }

    @RequestMapping("/vote/{qid}")
    public ResponseEntity<?> totalCount(@PathVariable Integer qid) {
        return voteService.getTotalCount(qid);
    }

}
