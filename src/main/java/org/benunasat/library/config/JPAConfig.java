package org.benunasat.library.config;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAConfig {

    private static EntityManagerFactory factory;
    private static final EntityManager entityManager = buildEntityManager();
    private static final String PERSISTENCE_UNIT_NAME = "library_persistence";

    private static EntityManager buildEntityManager() {
        try {
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
            return factory.createEntityManager();

        } catch (Throwable ex) {
            //Handling the exception in case it fails.
            System.err.println("Initial EntityManagerFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static EntityManager getEntityManager() {
        return entityManager;
    }


    public static void shutdown() {
        if (factory != null) {
            factory.close();
        }
    }
}
