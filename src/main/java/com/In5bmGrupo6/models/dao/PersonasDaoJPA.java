package com.In5bmGrupo6.models.dao;

/**
 *
 * @author Jorge Luis Pérez Canto
 * @date 7/09/2022
 * @time 08:43:46
 *
 */
import com.In5bmGrupo6.db.ConexionPU;
import com.In5bmGrupo6.models.domain.Personas;
import com.In5bmGrupo6.models.idao.IPersonaDAO;
import java.util.List;

public class PersonasDaoJPA implements IPersonaDAO {

    private ConexionPU con = ConexionPU.getInstance();

    @Override
    public List<Personas> getAll() {
        return con.getEntityManager().createNamedQuery("Persona.findAll").getResultList();
    }

    @Override
    public int add(Personas persona) {
        int rows = 0;
        try {
            con.getEntityManager().getTransaction().begin();
            con.getEntityManager().persist(persona);
            con.getEntityManager().getTransaction().commit();
            rows = 1;
        } catch (Exception e) {
            System.err.println("Se produjo un error al intentar insertar el siguiente registro" + persona.toString());
            e.printStackTrace(System.out);
            con.getEntityManager().getTransaction().rollback();
        }
        return rows;
    }

    @Override
    public int update(Personas persona) {
        int rows = 0;

        try {
            con.getEntityManager().getTransaction().begin();
            con.getEntityManager().merge(persona);
            con.getEntityManager().getTransaction().commit();
            rows = 1;
        } catch (Exception e) {
            e.printStackTrace(System.out);
            con.getEntityManager().getTransaction().rollback();
        }
        return rows;
    }

    public Personas get(Personas persona) {
        return (Personas) con.getEntityManager().createNamedQuery("Persona.find").setParameter("id", persona.getId_persona()).getSingleResult();
    }

    @Override
    public int delete(Personas persona) {
        System.out.println(persona);
        int rows = 0;
        try {
            con.getEntityManager().getTransaction().begin();
            con.getEntityManager().remove(persona);
            con.getEntityManager().getTransaction().commit();
            rows = 1;
        } catch (Exception e) {
            e.printStackTrace(System.out);
            con.getEntityManager().getTransaction().rollback();
        }
        return rows;
    }
}
