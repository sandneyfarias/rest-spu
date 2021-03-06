package br.com.sfc.restspu.exception.handler;

import br.com.sfc.restspu.exception.ExcpetionResponse;
import br.com.sfc.restspu.exception.InvalidJwtAuthenticationException;
import br.com.sfc.restspu.exception.UnsuportedMathOperationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ExcpetionResponse> handleAllExcpetions(Exception ex, WebRequest request) {
        ExcpetionResponse excpetionResponse =
                new ExcpetionResponse(new Date(),
                    ex.getMessage(),
                    request.getDescription(false));

        return new ResponseEntity<>(excpetionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UnsuportedMathOperationException.class)
    public final ResponseEntity<ExcpetionResponse> handleBadRequestExcpetions(Exception ex, WebRequest request) {
        ExcpetionResponse excpetionResponse =
                new ExcpetionResponse(new Date(),
                        ex.getMessage(),
                        request.getDescription(false));

        return new ResponseEntity<>(excpetionResponse, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(InvalidJwtAuthenticationException.class)
    public final ResponseEntity<ExcpetionResponse> invalidJwtAuthenticationException(Exception ex, WebRequest request) {
        ExcpetionResponse excpetionResponse =
                new ExcpetionResponse(new Date(),
                        ex.getMessage(),
                        request.getDescription(false));

        return new ResponseEntity<>(excpetionResponse, HttpStatus.BAD_REQUEST);
    }

}
