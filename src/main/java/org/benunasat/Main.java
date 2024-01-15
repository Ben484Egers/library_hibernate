package org.benunasat;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.benunasat.library.config.JPAConfig;
import org.benunasat.library.series.Serie;
import org.benunasat.library.series.SerieDAO;
import org.benunasat.library.users.User;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        SerieDAO dao = new SerieDAO(JPAConfig.getEntityManager());

        dao.getAllSeries();
    }
}