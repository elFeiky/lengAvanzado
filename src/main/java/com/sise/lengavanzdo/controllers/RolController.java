package com.sise.lengavanzdo.controllers;

import com.sise.lengavanzdo.adapters.RolAdapter;
import com.sise.lengavanzdo.entities.rol;
import com.sise.lengavanzdo.payload.request.RolRequestInsert;
import com.sise.lengavanzdo.payload.request.RolRequestUpdate;
import com.sise.lengavanzdo.services.RolService;
import com.sise.lengavanzdo.shared.BaseResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
public class RolController {
    @Autowired
    private RolService rolService;

    private RolAdapter rolAdapter;

    public RolController(){
        rolAdapter = new RolAdapter();
    }

    @GetMapping("")
    public ResponseEntity<BaseResponse> listarRoles() {
        try {
            List<rol> roles = rolService.listarRoles();
            return new ResponseEntity<BaseResponse>(BaseResponse.success(roles), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<BaseResponse>(BaseResponse.error(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/{idRol}")
    public ResponseEntity<BaseResponse> listarRolPorId(@PathVariable Integer idRol){
        try {
            rol rol = rolService.listarRolPorId(idRol);

            if(rol==null){
                return new ResponseEntity<BaseResponse>(BaseResponse.errorNotFound(), HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<BaseResponse>(BaseResponse.success(rol), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<BaseResponse>(BaseResponse.error(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("")
    public ResponseEntity<BaseResponse> insertarRol(@Valid @RequestBody RolRequestInsert rolRequestInsert, Errors errors){
        try {
            if(errors.hasErrors()) {
                return new ResponseEntity<BaseResponse>(BaseResponse.success(errors.getAllErrors()), HttpStatus.BAD_REQUEST);
            }
            rol rol = rolService.insertarRol(rolAdapter.insertToEntity(rolRequestInsert));
            return new ResponseEntity<BaseResponse>(BaseResponse.success(rol), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<BaseResponse>(BaseResponse.error(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }
    @PutMapping("/{idRol}")
    public ResponseEntity<BaseResponse> actualizarRol(@PathVariable Integer idRol, @RequestBody RolRequestUpdate rolRequestUpdate){
        try {
            rol rol = rolAdapter.updateToEntity(rolRequestUpdate);
            rol.setIdRol(idRol);
            rol newRol = rolService.actualizarRol(rol);

            return new ResponseEntity<BaseResponse>(BaseResponse.success(newRol), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<BaseResponse>(BaseResponse.error(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping("/darbaja/{idRol}")
    public ResponseEntity<BaseResponse> darBajaRol(@PathVariable Integer idRol){
        try {
            rolService.darBajaRol(idRol);
            return new ResponseEntity<BaseResponse>(BaseResponse.success(null), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<BaseResponse>(BaseResponse.error(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
