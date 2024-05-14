package com.example.lenaapi.controllers.advices;

import com.example.lenaapi.exceptions.user.NoSuchUserException;
import com.example.lenaapi.exceptions.user.SuchUserAlreadyExistsException;
import com.example.lenaapi.exceptions.user.UserIsBlockedException;
import com.example.lenaapi.models.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandlerControllerAdvice {

    @ExceptionHandler(SuchUserAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody ErrorResponse onSuchUserAlreadyExists(SuchUserAlreadyExistsException e) {
        return new ErrorResponse(e.getMessage());
    }

    @ExceptionHandler(UserIsBlockedException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody ErrorResponse onUserIsBlocked(UserIsBlockedException e) {
        return new ErrorResponse(e.getMessage());
    }

    @ExceptionHandler(NoSuchUserException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody ErrorResponse onNoSuchUser(NoSuchUserException e) {
        return new ErrorResponse(e.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody ErrorResponse onMethodArgumentNoValidException(MethodArgumentNotValidException e) {
        return new ErrorResponse(e.getBindingResult().getFieldErrors().get(0).getDefaultMessage());
    }
}
