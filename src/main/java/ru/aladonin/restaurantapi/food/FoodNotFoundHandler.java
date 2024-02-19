package ru.aladonin.restaurantapi.food;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.aladonin.restaurantapi.utils.ApiException;


@ControllerAdvice
public class FoodNotFoundHandler {

    @ExceptionHandler(value = {FoodNotFoundException.class})
    public ResponseEntity<Object> handleFoodNotFoundException(FoodNotFoundException exception) {
        ApiException e = new ApiException(exception.getMessage(), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(e, HttpStatus.NOT_FOUND);
    }
}
