package com.In5bmGrupo6.models.idao;

import com.In5bmGrupo6.models.domain.Clientes;
import java.util.List;

/**
 *
 * @author sergio
 * @date 30-08-2022
 * @time 08:55:00 AM
 * Código Técnico; IN5BM
 */

public interface IClientesDAO {
    
    //Listar todos los registros
    public List<Clientes> getAll(); 
    
    //Insertar registro
    public int add(Clientes cliente);
    
    //Actualizar un registro
    public int update(Clientes cliente); 
    
    //Eliminar registro
    public int delete(Clientes cliente);
}