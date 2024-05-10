package ua.bielskyi.tracker.exception.controler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ua.bielskyi.tracker.exception.ApiExceptionResponse;
import ua.bielskyi.tracker.exception.InternalException;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler({InternalException.class, RuntimeException.class})
    public ResponseEntity<ApiExceptionResponse> handleException(Exception ex) {

        ApiExceptionResponse errorResponse = ApiExceptionResponse.builder()
                .message(ex.getMessage())
                .code(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .build();

        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
