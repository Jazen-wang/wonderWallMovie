package sysu.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Created by Shower on 2017/5/10 0010.
 */
@ControllerAdvice
public class GlobalDefaultExceptionHandler {
    @ExceptionHandler({Exception.class})
    public ResponseEntity error(Exception e) {
        e.printStackTrace();
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }
}
