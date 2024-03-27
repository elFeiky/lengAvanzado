package com.sise.lengavanzdo.controllers;

import com.sise.lengavanzdo.adapters.UsuarioAdapter;
import com.sise.lengavanzdo.entities.ususario;
import com.sise.lengavanzdo.payload.request.UsuarioRequestInsert;
import com.sise.lengavanzdo.payload.request.UsuarioRequestUpdate;
import com.sise.lengavanzdo.payload.request.UsuarioRequestUpdateClave;
import com.sise.lengavanzdo.services.UsuarioService;
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
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    private UsuarioAdapter usuarioAdapter;

    public UsuarioController(){
        usuarioAdapter = new UsuarioAdapter();
    }

    @GetMapping("")
    public ResponseEntity<BaseResponse> listarUsuarios() {
        try {
            List<ususario> usuarios = usuarioService.listarUsuarios();
            return new ResponseEntity<BaseResponse>(BaseResponse.success(usuarios), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<BaseResponse>(BaseResponse.error(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{idUsuario}")
    public ResponseEntity<BaseResponse> listarUsuarioPorId(@PathVariable Integer idUsuario){
        try {
            ususario usuario = usuarioService.listarUsuarioPorId(idUsuario);
            if(usuario==null){
                return new ResponseEntity<BaseResponse>(BaseResponse.errorNotFound(), HttpStatus.NOT_FOUND
                );
            }
            return new ResponseEntity<BaseResponse>(BaseResponse.success(usuario), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<BaseResponse>(BaseResponse.error(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("")
    public ResponseEntity<BaseResponse> insertarUsuario(@Valid @RequestBody UsuarioRequestInsert usuarioRequestInsert, Errors errors){
        try {
            if(errors.hasErrors()){
                return new ResponseEntity<BaseResponse>(BaseResponse.error(ValidationUtil.getOneMessageFromErrors(errors.getFieldErrors())), HttpStatus.BAD_REQUEST);
            }
            ususario usuario = usuarioService.insertarUsuario(usuarioAdapter.insertToEntity(usuarioRequestInsert));
            return new ResponseEntity<BaseResponse>(BaseResponse.success(usuario), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<BaseResponse>(BaseResponse.error(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{idUsuario}")
    public ResponseEntity<BaseResponse> actualizarUsuario(@PathVariable Integer idUsuario, @Valid @RequestBody UsuarioRequestUpdate usuarioRequestUpdate){
        try {
            ususario usuario = usuarioAdapter.updateToEntity(usuarioRequestUpdate);
            usuario.setIdUsuario(idUsuario);
            ususario newUsuario = usuarioService.actualizarUsuario(usuario);
            return new ResponseEntity<BaseResponse>(BaseResponse.success(newUsuario), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<BaseResponse>(BaseResponse.error(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }
    @PatchMapping("/cambiarClave/{idUsuario}")
    public ResponseEntity<BaseResponse> cambiarClaveUsuario(@PathVariable Integer idUsuario, @Valid @RequestBody UsuarioRequestUpdateClave usuarioRequestUpdateClave, Errors errors){
        try {
            if(errors.hasErrors()){
                return new ResponseEntity<BaseResponse>(
                        BaseResponse.error(ValidationUtil.getOneMessageFromErrors(errors.getFieldErrors())),
                        HttpStatus.BAD_REQUEST
                );
            }
            ususario usuario = usuarioAdapter.updateClaveToEntity(usuarioRequestUpdateClave);
            usuario.setIdUsuario(idUsuario);
            usuarioService.cambiarClaveUsuario(usuario);
            return new ResponseEntity<BaseResponse>(BaseResponse.success(null), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<BaseResponse>(BaseResponse.error(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PatchMapping("/darbaja/{idUsuario}")
    public ResponseEntity<BaseResponse> darBajaUsuario(@PathVariable Integer idUsuario){
        try {
            usuarioService.darBajaUsuario(idUsuario);
            return new ResponseEntity<BaseResponse>(BaseResponse.success(null), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<BaseResponse>(BaseResponse.error(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
