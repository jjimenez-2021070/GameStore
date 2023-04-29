package com.In5bmGrupo6.db;


/**
 *
 * @author Jorge Luis Pérez Canto
 * @date 7/09/2022
 * @time 08:28:11
 * 
 */

import javax.persistence.Persistence;
import javax.persistence.EntityManager;

public class ConexionPU {
    
    private static final String PERSISTENCE_UNIT_NAME = "games_store_pu";
    private EntityManager entityManager;
    private static ConexionPU instance;
    
    private ConexionPU() {
        try {
            entityManager = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME).createEntityManager();
            System.out.println("Conexion establecida a través de una unidad de persistencia.");
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }
    
    public static ConexionPU getInstance() {
        if (instance == null) {
            instance = new ConexionPU();
        }
        return instance;
    }
    
    public EntityManager getEntityManager() {
        return entityManager;
    }
}
