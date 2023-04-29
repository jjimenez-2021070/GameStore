package com.In5bmGrupo6.models.idao;

import java.util.List;
import com.In5bmGrupo6.models.domain.Desarrolladoras;

/**
 *
 * @author Luis Carlos Pérez
 */

public interface IDesarrolladorasDAO {
    
    public List<Desarrolladoras> getAll();
    
    public int add(Desarrolladoras desarrolladora);
    
    public int update(Desarrolladoras desarrolladora);
    
    public int delete(Desarrolladoras desarrolladora);
}