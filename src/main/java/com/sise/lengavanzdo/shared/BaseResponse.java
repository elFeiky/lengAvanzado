package com.sise.lengavanzdo.shared;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BaseResponse {
    private String message;
    private boolean error;
    private Object java;
    private BaseResponse(String message,boolean error,Object java){
        this.message=message;
        this.error=error;
        this.java=java;
    }

    public static BaseResponse success(Object data){
        return new BaseResponse("ok",false,data);
    }

    public static BaseResponse error(String message){
        return new BaseResponse(message,true,null);
    }
    public static BaseResponse errorNotFound(){
        return new BaseResponse("Recurso no encontrado",true,null);
    }

}
