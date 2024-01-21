package org.benunasat;

import org.benunasat.library.config.JPAConfig;
import org.benunasat.library.series.SerieDAOImpl;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        SerieDAOImpl dao = new SerieDAOImpl(JPAConfig.getEntityManager());

        dao.getAllSeries();
    }
}