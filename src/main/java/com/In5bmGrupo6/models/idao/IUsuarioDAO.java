package com.In5bmGrupo6.models.idao;

import com.In5bmGrupo6.models.domain.Usuarios;
import java.util.List;

/**
 *
 * @author Roberto Saldaña
 * @date 30-08-2022
 * @time 08:55:00 AM
 * Código Técnico; IN5BM
 */

public interface IUsuarioDAO {
    
    //Listar todos los registros
    public List<Usuarios> getAll(); 
    
    //Insertar registro
    public int add(Usuarios estudiante);
    
    //Actualizar un registro
    public int update(Usuarios estudiante);
    
    //Eliminar registro
    public int delete(Usuarios estudiante);
}