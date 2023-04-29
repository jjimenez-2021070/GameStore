
package com.In5bmGrupo6.models.dao;

/**
 *
 * @author Luis Carlos Pérez
 * @date 11/09/2022
 * @time 17:14:49
 * 
 *Código técnico: IN5BM
 *
 */

import com.In5bmGrupo6.db.ConexionPU;
import com.In5bmGrupo6.models.domain.Desarrolladoras;
import com.In5bmGrupo6.models.idao.IDesarrolladorasDAO;
import java.util.List;

public class DesarrolladoraDaoJPA implements IDesarrolladorasDAO {

    private ConexionPU con = ConexionPU.getInstance();
    
    @Override
    public List<Desarrolladoras> getAll() {
        return con.getEntityManager().createNamedQuery("Desarrolladora.findAll").getResultList();
    }

    @Override
    public int add(Desarrolladoras desarrolladora) {
        int rows = 0;
        try {
            con.getEntityManager().getTransaction().begin();
            con.getEntityManager().persist(desarrolladora); 
            con.getEntityManager().getTransaction().commit(); 
            rows = 1; 
        } catch (Exception e) {
            e.printStackTrace(System.out);
            con.getEntityManager().getTransaction().rollback(); 
        }
        return rows;
    }

    @Override
    public int update(Desarrolladoras desarrolladora) {
        int rows = 0;
        try {
            con.getEntityManager().getTransaction().begin();
            con.getEntityManager().merge(desarrolladora); 
            con.getEntityManager().getTransaction().commit(); 
            rows = 1; 
        } catch (Exception e) {
            e.printStackTrace(System.out);
            con.getEntityManager().getTransaction().rollback(); 
        }
        return rows;
    }

    @Override
    public int delete(Desarrolladoras desarrolladora) {
        System.out.println(desarrolladora);
        int rows = 0;
        try {
            con.getEntityManager().getTransaction().begin();
            con.getEntityManager().remove(desarrolladora); 
            con.getEntityManager().getTransaction().commit(); 
            rows = 1; 
        } catch (Exception e) {
            e.printStackTrace(System.out);
            con.getEntityManager().getTransaction().rollback(); 
        }
        return rows;
    }
    
    public Desarrolladoras get(Desarrolladoras desarrolladora) {
        return (Desarrolladoras) con.getEntityManager().createNamedQuery("Desarrolladora.find").setParameter("id", desarrolladora.getId()).getSingleResult();
    }
    
}
