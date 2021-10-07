package app.assignment.app;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AllExceptionHandler {

    @ExceptionHandler(Error.class)
    public ResponseEntity<Response> handleError(){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Response("01","Bad Request"));
    }
    @ExceptionHandler(NumberFormatException.class)
    public ResponseEntity<Response> handleNumberF(){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Response("00", "Incorrect number input"));
    }
}
