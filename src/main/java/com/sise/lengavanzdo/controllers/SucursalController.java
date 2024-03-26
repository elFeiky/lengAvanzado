package com.sise.lengavanzdo.controllers;

import com.sise.lengavanzdo.adapters.SucursalAdapter;
import com.sise.lengavanzdo.entities.sucursal;
import com.sise.lengavanzdo.payload.request.SucursalRequestInsert;
import com.sise.lengavanzdo.payload.request.SucursalRequestUpdate;
import com.sise.lengavanzdo.services.SucursalService;
import com.sise.lengavanzdo.shared.BaseResponse;
import com.sise.lengavanzdo.utils.ValidationUtil;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sucursales")
public class SucursalController {
    @Autowired
    private SucursalService sucursalService;

    private SucursalAdapter sucursalAdapter;
    @GetMapping("")
    public ResponseEntity<BaseResponse>listarSucursales(){
        try{
            List<sucursal> sucursales = sucursalService.listarSucursales();
            return new ResponseEntity<BaseResponse>(BaseResponse.success(sucursales), HttpStatus.OK);
            /*List<SucursalResponse>sucursalResponseList=new ArrayList<>();
            for ( sucursal sucursal :sucursales){
                sucursalResponseList.add(MappedUtil.toSucursalResponse(sucursal));
            }*/
            //return BaseResponse.success(sucursalResponseList);
        }catch (Exception e){
            return new ResponseEntity<BaseResponse>(BaseResponse.success(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
            //return BaseResponse.error(e.getMessage());
        }
    }

    @GetMapping("/{idSucursal}")
    public ResponseEntity<BaseResponse> listarSucursalPorId(@PathVariable Integer idSucursal){
        try {
            sucursal sucursal= sucursalService.listarSucursalPorId(idSucursal);
            if(sucursal==null){
                return  new ResponseEntity<BaseResponse>(BaseResponse.error("No encontrado"),HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<BaseResponse>(BaseResponse.success(sucursal),HttpStatus.OK);
            //return BaseResponse.success(MappedUtil.toSucursalResponse(sucursal));
        }catch (Exception e){
            //return  BaseResponse.error(e.getMessage());
            return  new ResponseEntity<BaseResponse>(BaseResponse.error(e.getMessage()),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("")
    public ResponseEntity<BaseResponse> insertarSucursal(@Valid @RequestBody SucursalRequestInsert sucursalRequestInsert,Errors errors){
        try {
            if(errors.hasErrors()){
                return new ResponseEntity<BaseResponse>(
                        BaseResponse.error(ValidationUtil.getOneMessageFromErrors(errors.getFieldErrors())),HttpStatus.BAD_REQUEST
                );
            }
            sucursal sucursal = sucursalService.insertarSucursal(sucursalAdapter.insertToEntity(sucursalRequestInsert));
            return new ResponseEntity<BaseResponse>(BaseResponse.success(sucursal), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<BaseResponse>(BaseResponse.error(e.getMessage()),HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }

    @PutMapping("/{idSucursal}")
    public ResponseEntity<BaseResponse> actualizarSucursal(
            @PathVariable Integer idSucursal,
            @RequestBody SucursalRequestUpdate sucursalRequestUpdate
    ){
        try {
            sucursal sucursal = sucursalAdapter.updateToEntity(sucursalRequestUpdate);
            sucursal.setIdSucursal(idSucursal);
            sucursal newSucursal = sucursalService.actualizarSucursal(sucursal);
            return new ResponseEntity<BaseResponse>(BaseResponse.success(newSucursal), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<BaseResponse>(BaseResponse.error(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }

    @PatchMapping("/darbaja/{idSucursal}")
    public ResponseEntity<BaseResponse> darBajaSucursal(@PathVariable Integer idSucursal){
        try {
            sucursalService.darBajaSucursal(idSucursal);
            return new ResponseEntity<BaseResponse>(BaseResponse.success(null), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<BaseResponse>(BaseResponse.error(e.getMessage()),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
