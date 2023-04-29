
package com.In5bmGrupo6.models.dao;

/**
 *
 * @author Luis Carlos Pérez
 * @date 11/09/2022
 * @time 16:29:12
 * 
 *Código técnico: IN5BM
 *
 */

import com.In5bmGrupo6.db.ConexionPU;
import com.In5bmGrupo6.models.domain.Suscripciones;
import com.In5bmGrupo6.models.idao.ISuscripcionDAO;
import java.util.List;

public class SuscripcionDaoJPA implements ISuscripcionDAO {

    private ConexionPU con = ConexionPU.getInstance();
    
    @Override
    public List<Suscripciones> getAll() {
        return con.getEntityManager().createNamedQuery("Suscripcion.findAll").getResultList();
    }

    @Override
    public int add(Suscripciones suscripcion) {
        int rows = 0;
        try {
            con.getEntityManager().getTransaction().begin();
            con.getEntityManager().persist(suscripcion);
            con.getEntityManager().getTransaction().commit();
            rows = 1;
        } catch (Exception e) {
            e.printStackTrace(System.out);
            System.out.println("Se produjo un error al intentar insertar el siguiente registro : " + suscripcion.toString());
            con.getEntityManager().getTransaction().rollback();
        }
        return rows;
    }

    @Override
    public int update(Suscripciones suscripcion) {
        int rows = 0;
        try {
            con.getEntityManager().getTransaction().begin();
            con.getEntityManager().merge(suscripcion);
            con.getEntityManager().getTransaction().commit();
            rows = 1;
        } catch (Exception e) {
            e.printStackTrace(System.out);
            con.getEntityManager().getTransaction().rollback();
        }
        return rows;
    }

    @Override
    public int delete(Suscripciones suscripcion) {
        System.out.println(suscripcion);
        int rows = 0;
        try {
            con.getEntityManager().getTransaction().begin();
            con.getEntityManager().remove(suscripcion); 
            con.getEntityManager().getTransaction().commit(); 
            rows = 1; 
        } catch (Exception e) {
            e.printStackTrace(System.out);
            con.getEntityManager().getTransaction().rollback(); 
        }
        return rows;
    }
    
    public Suscripciones get(Suscripciones suscripcion) {
        return (Suscripciones) con.getEntityManager().createNamedQuery("Suscripcion.find").setParameter("id", suscripcion.getIdSuscripcion()).getSingleResult();
    }
    
}
