package com.sise.lengavanzdo.services;
import com.sise.lengavanzdo.entities.mesa;

import java.util.List;

public interface MesaService {
    List<mesa> listarMesa();
    mesa listarMesaPorId(Integer id);
    mesa insertarMesa(mesa mesa);
    mesa actualizarMesa(mesa mesa);
    void darBajaMesa(Integer id);

}

