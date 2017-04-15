package sysu.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sysu.persistence.models.User;
import sysu.persistence.repositories.UserRepository;

/**
 * Created by shower on 17-4-15.
 */
@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public ResponseEntity<Long> signin(@RequestBody User user) {
        User u = userRepository.findByName(user.getName());
        if (u != null && u.getPassword().equals(user.getPassword()))
            return new ResponseEntity<Long>(u.getId(), HttpStatus.OK);
        else return new ResponseEntity<Long>(-1L, HttpStatus.OK);
    }

    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public ResponseEntity<Long> signup(@RequestBody User user) {
        User u = userRepository.save(user);
        if (u != null) return new ResponseEntity<Long>(u.getId(), HttpStatus.OK);
        else return new ResponseEntity<Long>(-1L, HttpStatus.OK);
    }
}
