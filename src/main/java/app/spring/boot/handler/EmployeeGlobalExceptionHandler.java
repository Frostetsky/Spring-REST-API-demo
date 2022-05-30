package app.spring.boot.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.NoSuchElementException;

/**
 * Аннотация ControllerAdvice сообщает что данный классс является глобальным обработчиком
 * исключений во всех контроллерах
 */

@ControllerAdvice
public class EmployeeGlobalExceptionHandler {


    /**
     * Аннотация ExceptionHandler позволяет перехватывать исключения разного рода
     * и преобразовывать их коды HTTP.
     * @param noSuchElementException
     * @return
     */
    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> deleteExceptionHandler(NoSuchElementException noSuchElementException) {
        return new ResponseEntity<>(noSuchElementException.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
