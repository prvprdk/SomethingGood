package com.example.somethinggood.utils;

import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Component
public class ErrorUtil {

    public static Map <String,String> getErrors(BindingResult bindingResult){
        Collector<FieldError, ?, Map<String,String>> collectors = Collectors.toMap(
                fieldError -> fieldError.getField() + "Error",
                FieldError::getDefaultMessage
        );
        return bindingResult.getFieldErrors().stream().collect(collectors);
    }
}
