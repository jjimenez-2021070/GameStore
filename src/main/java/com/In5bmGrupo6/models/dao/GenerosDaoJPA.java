package com.In5bmGrupo6.models.dao;

/**
 *
 * @author TulioJimènez
 */
import com.In5bmGrupo6.db.ConexionPU;
import com.In5bmGrupo6.models.domain.Generos;
import com.In5bmGrupo6.models.idao.IGeneroDAO;
import java.util.List;

public class GenerosDaoJPA implements IGeneroDAO {

    private ConexionPU con = ConexionPU.getInstance();

    @Override
    public List<Generos> getAll() {
        return con.getEntityManager().createNamedQuery("Generos.findAll").getResultList();
    }

    @Override
    public int add(Generos generos) {
        int rows = 0;
        try {
            con.getEntityManager().getTransaction().begin();
            con.getEntityManager().persist(generos);
            con.getEntityManager().getTransaction().commit();
            rows = 1;
        } catch (Exception e) {
            System.err.println("Se´produjo un error al intentar insertar el siguiente registro" + generos.toString());
            e.printStackTrace(System.out);
            con.getEntityManager().getTransaction().rollback();
        }
        return rows;
    }

    @Override
    public int update(Generos generos) {
        int rows = 0;

        try {
            con.getEntityManager().getTransaction().begin();
            con.getEntityManager().merge(generos);
            con.getEntityManager().getTransaction().commit();
            rows = 1;
        } catch (Exception e) {
            e.printStackTrace(System.out);
            con.getEntityManager().getTransaction().rollback();
        }
        return rows;
    }

    @Override
    public int delete(Generos generos) {
        System.out.println(generos);
        int rows = 0;
        try {
            con.getEntityManager().getTransaction().begin();
            con.getEntityManager().remove(generos);
            con.getEntityManager().getTransaction().commit();
            rows = 1;
        } catch (Exception e) {
            e.printStackTrace(System.out);
            con.getEntityManager().getTransaction().rollback();
        }
        return rows;
    }

    public Generos get(Generos generos) {
        return (Generos) con.getEntityManager().createNamedQuery("Generos.find").setParameter("id", generos.getId_genero()).getSingleResult();
    }

}
