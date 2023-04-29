package com.In5bmGrupo6.models.dao;

/**
 *
 * @author Sergio Cruz Velasquez 
 * @date Sep 12, 2022
 * @time 4:11:24 PM
 *
 */

import com.In5bmGrupo6.db.ConexionPU;
import com.In5bmGrupo6.models.domain.Distribuidoras;
import com.In5bmGrupo6.models.idao.IDistribuidorasDAO;
import java.util.List;

public class DistribuidorasDaoJPA implements IDistribuidorasDAO{

    private ConexionPU con = ConexionPU.getInstance();
    
    @Override
    public List<Distribuidoras> getAll() {
        return con.getEntityManager().createNamedQuery("Distribuidora.findAll").getResultList();
    }

    @Override
    public int add(Distribuidoras distribuidora) {
        int rows = 0;
        try {
            con.getEntityManager().getTransaction().begin();
            con.getEntityManager().persist(distribuidora);
            con.getEntityManager().getTransaction().commit();
            rows = 1;
        } catch (Exception e) {
            System.err.println("Se produjo un error al intentar insertar el siguiente registro" + distribuidora.toString());
            e.printStackTrace(System.out);
            con.getEntityManager().getTransaction().rollback();
        }
        return rows;
    }

    @Override
    public int update(Distribuidoras distribuidora) {
        int rows = 0;

        try {
            con.getEntityManager().getTransaction().begin();
            con.getEntityManager().merge(distribuidora);
            con.getEntityManager().getTransaction().commit();
            rows = 1;
        } catch (Exception e) {
            e.printStackTrace(System.out);
            con.getEntityManager().getTransaction().rollback();
        }
        return rows;
    }

    @Override
    public int delete(Distribuidoras distribuidora) { 
        System.out.println(distribuidora);
        int rows = 0;
        try {
            con.getEntityManager().getTransaction().begin();
            con.getEntityManager().remove(distribuidora); 
            con.getEntityManager().getTransaction().commit(); 
            rows = 1; 
        } catch (Exception e) {
            e.printStackTrace(System.out);
            con.getEntityManager().getTransaction().rollback(); 
        }
        return rows;
    }
    
    public Distribuidoras get(Distribuidoras distribuidora) {
        return (Distribuidoras) con.getEntityManager().createNamedQuery("Distribuidora.find").setParameter("id", distribuidora.getId()).getSingleResult();
    }
    
}
