package sysu.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sysu.eneties.OrderDTO;
import sysu.eneties.OrderForm;
import sysu.eneties.UserForm;
import sysu.exceptions.LoginError;
import sysu.exceptions.NotLogin;
import sysu.exceptions.UsernameExists;
import sysu.persistence.models.User;
import sysu.persistence.models.UserOrder;
import sysu.services.UserService;

import javax.servlet.http.HttpSession;
import java.util.Optional;

/**
 * Created by Shower on 2017/6/3 0003.
 */
@Controller
@RequestMapping("/api")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void login(@RequestBody UserForm form, HttpSession session) throws LoginError {
        Optional<User> user = userService.getUserByNameAndPassword(form.getUsername(), form.getPassword());
        if (user.isPresent()) {
            session.setAttribute("userId", user.get().getId());
        }
        else throw new LoginError();
    }

    @PostMapping("/logout")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void logout(HttpSession session) {
        session.removeAttribute("userId");
    }

    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public void signup(@RequestBody UserForm form) throws UsernameExists {
        boolean isPresent = userService.isUsernamePresent(form.getUsername());
        if (!isPresent) {
            userService.addUser(new User(form.getUsername(), form.getPassword()));
        } else {
            throw new UsernameExists();
        }
    }

    @GetMapping("/user")
    public ResponseEntity<?> userInfo(HttpSession session) throws NotLogin {
        Object userId = session.getAttribute("userId");
        if (userId == null) throw new NotLogin();
        Optional<User> u = userService.getUserById((long) userId);
        return new ResponseEntity<Object>(u.get(), HttpStatus.OK);
    }

    @PostMapping("/movies/{movie_id}/cinema/{cinema_id}/hall")
    public ResponseEntity<?> generateOrder(@RequestBody OrderForm orderForm,
                                           HttpSession session) throws NotLogin {
        Object userId = session.getAttribute("userId");
        if (userId == null) throw new NotLogin();
        UserOrder order = userService.generateOrder((long) userId, orderForm);
        OrderDTO orderDTO = new OrderDTO(order.getUser(),
                order.getOrderDate(),
                order.getTicketPrice(),
                order.getTicketCount(),
                order.getSeats());
        return new ResponseEntity<>(orderDTO, HttpStatus.CREATED);
    }
}
