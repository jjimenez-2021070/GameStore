package com.In5bmGrupo6.models.idao;

import java.util.List;
import com.In5bmGrupo6.models.domain.Suscripciones;

/**
 *
 * @author Luis Carlos Pérez
 */
public interface ISuscripcionDAO {
    
    public List<Suscripciones> getAll();
    
    public int add(Suscripciones suscripcion);
    
    public int update(Suscripciones suscripcion);
    
    public int delete(Suscripciones suscripcion);
    
}