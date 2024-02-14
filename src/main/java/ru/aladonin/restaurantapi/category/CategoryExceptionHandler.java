package ru.aladonin.restaurantapi.category;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


// Handler Exception
@ControllerAdvice
public class CategoryExceptionHandler {

    @ExceptionHandler(value = {CategoryNotFoundException.class})
    public ResponseEntity<Object>  handleCategoryNotFoundException
            (CategoryNotFoundException categoryNotFoundException) {
        CategoryException categoryException = new CategoryException(
                categoryNotFoundException.getMessage(),
                categoryNotFoundException.getCause(),
                HttpStatus.NOT_FOUND
        );

        return new ResponseEntity<>(categoryException, HttpStatus.NOT_FOUND);
    }
}
