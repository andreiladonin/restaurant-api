package ru.aladonin.restaurantapi.category;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
public class CategoryException {
    private final String message;
    private final Throwable throwable;
    private final HttpStatus httpStatus;

}
