package sysu.exceptions;

import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import sysu.eneties.Message;

/**
 * Created by Shower on 2017/5/10 0010.
 */
@ControllerAdvice
@ResponseBody
public class GlobalDefaultExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(Exception.class)
    public Message generalError(Exception e) {
        System.out.println(e.getMessage());
        return new Message(e.getMessage());
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(NotLogin.class)
    public Message notLoginHandler(NotLogin e) {
        return new Message(e.getMessage());
    }

    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(UsernameExists.class)
    public Message usernameExistsHandler(UsernameExists e) {
        return new Message(e.getMessage());
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(UserNotFound.class)
    public Message userNotFoundHandler(UserNotFound e) {
        return new Message(e.getMessage());
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(LoginError.class)
    public Message loginErrorHandler(LoginError e) {
        return new Message(e.getMessage());
    }
}
