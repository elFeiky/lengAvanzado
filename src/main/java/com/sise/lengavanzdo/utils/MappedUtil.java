package com.sise.lengavanzdo.utils;

import com.sise.lengavanzdo.entities.sucursal;
import com.sise.lengavanzdo.payload.request.SucursalRequest;

public class MappedUtil {

    public static sucursal toSucursalEntity(SucursalRequest sucursalRequest){
        sucursal sucursal = new sucursal();
        sucursal.setNombre(sucursalRequest.getNombre());
        sucursal.setDireccion(sucursalRequest.getDireccion());
        sucursal.setTelefono(sucursalRequest.getTelefono());
        sucursal.setDescripcion(sucursalRequest.getDescripcion());
        sucursal.setImagienUrl(sucursalRequest.getImagenUrl());
        return sucursal;
    }
    /*public static SucursalResponse toSucursalResponse(sucursal sucursal){
        SucursalResponse response = new SucursalResponse();
        response.setIdSucursal(sucursal.getIdSucursal());
        response.setNombre(sucursal.getNombre());
        response.setDireccion(sucursal.getDireccion());
        response.setTelefono(sucursal.getTelefono());
        response.setDescripcion(sucursal.getDescripcion());
        response.setImagenUrl(sucursal.getImagienUrl());
        return  response;
    }*/
}
