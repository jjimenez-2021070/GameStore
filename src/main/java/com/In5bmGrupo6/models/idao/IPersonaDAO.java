package com.In5bmGrupo6.models.idao;

import com.In5bmGrupo6.models.domain.Personas;
import java.util.List;

/**
 *
 * @author Roberto Saldaña
 * @date 30-08-2022
 * @time 08:55:00 AM
 * Código Técnico; IN5BM
 */

public interface IPersonaDAO {
    
    //Listar todos los registros
    public List<Personas> getAll(); 
    
    //Insertar registro
    public int add(Personas persona);
    
    //Actualizar un registro
    public int update(Personas persona);
    
    //Eliminar registro
    public int delete(Personas persona);
}