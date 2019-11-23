package Application.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.POST, value = "/insertuser")
    public ResponseEntity<?> insert(@RequestBody Device d) {
        return userService.insertUser(d);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/checkuser")
    public ResponseEntity<?> check(@RequestBody Device d) {
        return userService.checkUser(d);
    }
}
