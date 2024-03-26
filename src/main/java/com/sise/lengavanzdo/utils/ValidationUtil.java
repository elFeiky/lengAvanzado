package com.sise.lengavanzdo.utils;
import java.util.List;

import org.springframework.validation.FieldError;
public class ValidationUtil {
    public static String getOneMessageFromErrors(List<FieldError> errors){
        String message ="";
        for(FieldError error : errors){
            if(!message.isEmpty()){
                message+=",";
            }
            message += "El campo "+error.getField() + "," + error.getDefaultMessage();
        }
        return message+".";
    }
}
