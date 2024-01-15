package org.benunasat.library.series;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.Optional;

public class SerieDAO {

    private final EntityManager entityManager;
    private EntityTransaction transaction = null;

    public SerieDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Serie> getAllSeries() {
        System.out.println("Getting all series.....");
        String query = "select s from Serie s";
        TypedQuery<Serie> typedQuery = entityManager.createQuery(query, Serie.class);
        System.out.println(typedQuery.getResultList());
        return typedQuery.getResultList();
    }
    public Serie create(Serie newSerie) {
        System.out.println("Creating new serie.....");
        return null;
    }
    public Serie update(Serie updatedSerie) {
        System.out.println("Updating user.....");

        return null;
    }

    public boolean deleteSerie (Long id) {
        System.out.println("Deleting serie with id: " + id);
        return true;
    }

    public Optional<Serie> findSerieById(Long id) {
        System.out.println("Finding serie by id.....");
        return Optional.of(null);
    }

    public Optional<Serie> findSerieName (String name) {
        System.out.println("Finding serie by name: "+ name);

        return Optional.empty();
    }
}
