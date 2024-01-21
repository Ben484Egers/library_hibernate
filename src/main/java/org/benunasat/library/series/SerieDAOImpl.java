package org.benunasat.library.series;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import org.benunasat.library.authors.Author;

import java.util.List;
import java.util.Optional;

public class SerieDAOImpl implements SerieDAO{

    private final EntityManager entityManager;
    private EntityTransaction transaction = null;

    public SerieDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public List<Serie> getAllSeries() {
        System.out.println("Getting all series.....");
        try  {
            return entityManager
                    .createQuery("select s from Serie s", Serie.class)
                    .getResultList();
        } catch (Exception e) {
            System.out.println("Error retrieving series: " + e.getMessage());
            return null;
        }

    }
    @Override
    public Serie create(Serie newSerie) {
//        System.out.println("Creating new serie.....");
//    EntityTransaction transaction = null;
//
//        try {
//        transaction = entityManager.getTransaction();
//        transaction.begin();

//            Query nativeQuery = entityManager.createNativeQuery(
//                    "INSERT INTO Author (id, firstName, lastName, imagePath, email) " +
//                            "VALUES (?, ?, ?, ?, ?)");
//
//            nativeQuery.setParameter(1, newAuthor.getId());
//            nativeQuery.setParameter(2, newAuthor.getFirstName());
//            nativeQuery.setParameter(3, newAuthor.getLastName());
//            nativeQuery.setParameter(4, newAuthor.getImagePath());
//            nativeQuery.setParameter(5, newAuthor.getEmail());
//
//            nativeQuery.executeUpdate();
//
//
//            transaction.commit();

//    } catch (Exception e) {
//        if (transaction != null && transaction.isActive()) {
//            transaction.rollback();
//        }
//        System.out.println("Something went wrong. Could not create Author");
//        return null;
//    }
        return null;
    }


    @Override
    public Serie update(Serie updatedSerie) {
        System.out.println("Updating user.....");

        return null;
    }

    @Override
    public boolean deleteSerie (Long id) {
        System.out.println("Deleting serie with id: " + id);
        return true;
    }

    @Override
    public Optional<Serie> findSerieById(Long id) {
        System.out.println("Finding serie by id.....");
        return Optional.of(null);
    }

    @Override
    public Optional<Serie> findSerieName (String name) {
        System.out.println("Finding serie by name: "+ name);

        return Optional.empty();
    }
}
