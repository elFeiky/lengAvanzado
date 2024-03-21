package com.sise.lengavanzdo.controllers;

import com.sise.lengavanzdo.entities.sucursal;
import com.sise.lengavanzdo.payload.request.SucursalRequest;
import com.sise.lengavanzdo.services.SucursalService;
import com.sise.lengavanzdo.shared.BaseResponse;
import com.sise.lengavanzdo.utils.MappedUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sucursales")
public class SucursalController {
    @Autowired
    private SucursalService sucursalService;
    @GetMapping("")
    public ResponseEntity<BaseResponse>listarSucursales(){
        try{
            List<sucursal> sucursales = sucursalService.listarSucursales();
            /*List<SucursalResponse>sucursalResponseList=new ArrayList<>();
            for ( sucursal sucursal :sucursales){
                sucursalResponseList.add(MappedUtil.toSucursalResponse(sucursal));
            }*/
            return new ResponseEntity<BaseResponse>(BaseResponse.success(sucursales), HttpStatus.OK);
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
            //return BaseResponse.success(MappedUtil.toSucursalResponse(sucursal));
            return new ResponseEntity<BaseResponse>(BaseResponse.success(sucursal),HttpStatus.OK);
        }catch (Exception e){
            //return  BaseResponse.error(e.getMessage());
            return  new ResponseEntity<BaseResponse>(BaseResponse.error(e.getMessage()),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("")
    public ResponseEntity<BaseResponse> insertarSucursal(@RequestBody SucursalRequest sucursalRequest){
        try{
            sucursal sucursal =  sucursalService.insertarSucursal(MappedUtil.toSucursalEntity(sucursalRequest));
            //return BaseResponse.success(MappedUtil.toSucursalResponse(sucursal));
            return new ResponseEntity<BaseResponse>(BaseResponse.success(sucursal),HttpStatus.CREATED);
        }catch (Exception e){
            //return BaseResponse.error(e.getMessage());
            return  new ResponseEntity<BaseResponse>(BaseResponse.error(e.getMessage()),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{idSucursal}")
    public ResponseEntity<BaseResponse> ActualizarSucursal(@PathVariable Integer idSucursal, @RequestBody SucursalRequest sucursalRequest){
        try{
            sucursal sucursal = MappedUtil.toSucursalEntity(sucursalRequest);
            sucursal.setIdSucursal(idSucursal);
            sucursal newSucursal = sucursalService.actualizarSucursal(sucursal);
            return new ResponseEntity<BaseResponse>(BaseResponse.success(newSucursal),HttpStatus.OK);
        }catch (Exception e){
            return  new ResponseEntity<BaseResponse>(BaseResponse.error(e.getMessage()),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping("/darbaja/{idSucursal}")
    public ResponseEntity<BaseResponse> darBajaSucursal(@PathVariable Integer idSucursal){
        try{
            sucursalService.darBajaSucursal(idSucursal);
            return new ResponseEntity<BaseResponse>(BaseResponse.success(null),HttpStatus.OK);
        }catch (Exception e){
            return  new ResponseEntity<BaseResponse>(BaseResponse.error(e.getMessage()),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
