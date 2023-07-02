package com.jb.bookandauthor.advice;

import com.jb.bookandauthor.exceptions.LibraryCustomException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AdviceBookController {
@ExceptionHandler(value = {LibraryCustomException.class})
@ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrDetail handleException(Exception e){
        return new ErrDetail(e.getMessage());
    }


}
