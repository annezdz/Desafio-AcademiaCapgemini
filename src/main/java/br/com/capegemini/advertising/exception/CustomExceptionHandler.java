package br.com.capegemini.advertising.exception;

import br.com.capegemini.advertising.exception.dto.IllegalArgumentExceptionOutputDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IllegalArgumentException.class)
    public IllegalArgumentExceptionOutputDto handleIllegalArgumentErrors(IllegalArgumentException exception) {
        List<String> globalErrors = new ArrayList<>();
        globalErrors.add(exception.getMessage());

        return buildIllegalArgumentError(globalErrors);
    }

    private IllegalArgumentExceptionOutputDto buildIllegalArgumentError(List<String> globalErrors) {
        IllegalArgumentExceptionOutputDto notFoundErrors = new IllegalArgumentExceptionOutputDto();

        globalErrors.forEach(notFoundErrors::addError);
        return notFoundErrors;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(EndDateException.class)
    public IllegalArgumentExceptionOutputDto handleDateArgumentErrors(EndDateException exception) {
        List<String> globalErrors = new ArrayList<>();
        globalErrors.add(exception.getMessage());

        return buildIllegalArgumentError(globalErrors);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(AdNotFoundException.class)
    public IllegalArgumentExceptionOutputDto handleAdNotFoundError(AdNotFoundException exception) {
        List<String> globalErrors = new ArrayList<>();
        globalErrors.add(exception.getMessage());

        return buildIllegalArgumentError(globalErrors);
    }
}
