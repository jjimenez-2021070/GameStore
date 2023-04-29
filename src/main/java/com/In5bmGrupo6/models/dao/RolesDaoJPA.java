
package com.In5bmGrupo6.models.dao;

/**
 *
 * @author TulioJimènez
 */

import com.In5bmGrupo6.db.ConexionPU;
import com.In5bmGrupo6.models.domain.Roles;
import com.In5bmGrupo6.models.idao.IRolesDAO;
import java.util.List;

public class RolesDaoJPA implements IRolesDAO {

    private ConexionPU con = ConexionPU.getInstance();
    
    @Override
    public List<Roles> getAll() {
        return con.getEntityManager().createNamedQuery("Roles.findAll").getResultList();
    }

    @Override
    public int add(Roles roles) {
        int rows = 0;
        try {
            con.getEntityManager().getTransaction().begin();
            con.getEntityManager().persist(roles);
            con.getEntityManager().getTransaction().commit();
            rows = 1;
        } catch (Exception e) {
            System.err.println("Se produjo un error al intentar insertar el siguiente registro" + roles.toString());
            e.printStackTrace(System.out);
            con.getEntityManager().getTransaction().rollback();
        }
        return rows;
    }

    @Override
    public int update(Roles roles) {
        int rows = 0;
        
        try {
            con.getEntityManager().getTransaction().begin();
            con.getEntityManager().merge(roles);
            con.getEntityManager().getTransaction().commit();
            rows = 1;
        } catch (Exception e) {
            e.printStackTrace(System.out);
            con.getEntityManager().getTransaction().rollback();
        }
        return rows;
    }

    @Override
    public int delete(Roles roles) {
        System.out.println(roles);
        int rows = 0;
        try {
            con.getEntityManager().getTransaction().begin();
            con.getEntityManager().remove(roles); 
            con.getEntityManager().getTransaction().commit(); 
            rows = 1; 
        } catch (Exception e) {
            e.printStackTrace(System.out);
            con.getEntityManager().getTransaction().rollback(); 
        }
        return rows;
    }
    
    public Roles get(Roles roles) {
        return (Roles) con.getEntityManager().createNamedQuery("Roles.find").setParameter("id", roles.getId_rol()).getSingleResult();
    }
    
}
