package com.In5bmGrupo6.models.idao;

import com.In5bmGrupo6.models.domain.Distribuidoras;
import java.util.List;

/**
 *
 * @author sergio
 * @date 30-08-2022
 * @time 08:55:00 AM
 * Código Técnico; IN5BM
 */

public interface IDistribuidorasDAO {
    
    //Listar todos los registros
    public List<Distribuidoras> getAll(); 
    
    //Insertar registro
    public int add(Distribuidoras empleado);
    
    //Actualizar un registro
    public int update(Distribuidoras empleado);
    
    //Eliminar registro
    public int delete(Distribuidoras empleado);
}