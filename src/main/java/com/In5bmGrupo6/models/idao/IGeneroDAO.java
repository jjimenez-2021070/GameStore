package com.In5bmGrupo6.models.idao;

import com.In5bmGrupo6.models.domain.Generos;
import java.util.List;

/**
 *
 * @author Roberto Saldaña
 * @date 30-08-2022
 * @time 08:55:00 AM
 * Código Técnico; IN5BM
 */

public interface IGeneroDAO {
    
    //Listar todos los registros
    public List<Generos> getAll(); 
    
    //Insertar registro
    public int add(Generos estudiante);
    
    //Actualizar un registro
    public int update(Generos estudiante);
    
    //Eliminar registro
    public int delete(Generos estudiante);
}