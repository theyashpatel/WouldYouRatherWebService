package Application.Report;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReportController {

    @Autowired
    private ReportService reportService;

    @RequestMapping("/report/{qid}")
    public ResponseEntity<?> report(@PathVariable Integer qid) {
        return reportService.reportQuestion(qid);
    }

}
