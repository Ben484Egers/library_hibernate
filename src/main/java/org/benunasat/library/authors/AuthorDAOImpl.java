package org.benunasat.library.authors;


import jakarta.persistence.*;
import org.benunasat.library.series.Serie;
import org.hibernate.Session;

import java.util.List;
import java.util.Optional;

public class AuthorDAOImpl implements AuthorDAO{

    private final EntityManager entityManager;

    public AuthorDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Author> getAllAuthors() {
        System.out.println("Getting all authors.....");
        try  {
            return entityManager
                    .createQuery("SELECT a FROM Author a", Author.class)
                    .getResultList();
        } catch (Exception e) {
            System.out.println("Error retrieving authors: " + e.getMessage());
            return null;
        }
    }

    @Override
    public Author create(Author newAuthor) {

        System.out.println("Creating new user.....");
        EntityTransaction transaction = null;

        try {
            transaction = entityManager.getTransaction();
            transaction.begin();

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
            return newAuthor;

        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            System.out.println("Something went wrong. Could not create Author");
            return null;
        }

    }

    @Override
    public Author update(Author updatedAuthor) {
        System.out.println("Updating user.....");
        EntityTransaction transaction = null;

        try {
            transaction = entityManager.getTransaction();
            transaction.begin();

            Query query = entityManager.createQuery(
                    "UPDATE Author SET firstName = :firstName, lastName = :lastName, " +
                            "imagePath = :imagePath, email = :email WHERE id = :authorId");

            query.setParameter("firstName", updatedAuthor.getFirstName());
            query.setParameter("lastName", updatedAuthor.getLastName());
            query.setParameter("imagePath", updatedAuthor.getImagePath());
            query.setParameter("email", updatedAuthor.getEmail());
            query.setParameter("authorId", updatedAuthor.getId());

            query.executeUpdate();

            transaction.commit();
            return updatedAuthor;

        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            System.out.println("Something went wrong. Could not create Author");
            return null;
        }


    }

    @Override
    public boolean deleteAuthor (Long id) {
        System.out.println("Deleting author with id: " + id);
        EntityTransaction transaction = null;

        try {
            transaction = entityManager.getTransaction();
            transaction.begin();

            Query query = entityManager.createQuery("DELETE FROM Author WHERE id = :authorId");
            query.setParameter("authorId", id);

            query.executeUpdate();

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            return false;
        }

        return true;
    }

    @Override
    public Optional<Author> findAuthorById(Long id) {
        System.out.println("Finding author by id.....");

        try {
            return entityManager
                    .createQuery("SELECT a FROM Author a WHERE a.id = :id", Author.class)
                    .setParameter("id", id)
                    .getResultList()
                    .stream()
                    .findFirst();
        } catch (Exception e) {
            System.out.println("Something went wrong. Could not find Author with id: "+ id);
            return Optional.empty();
        }

    }

    @Override
    public Optional<Author> findAuthorByEmail (String email) {
        System.out.println("Finding author by email: "+ email);

            try {
                return entityManager
                        .createQuery("SELECT a FROM Author a WHERE a.email = :email", Author.class)
                        .setParameter("email", email)
                        .getResultList()
                        .stream()
                        .findFirst();
            } catch (Exception e) {
                System.out.println("Something went wrong. Could not find Author with email: "+email);
                return Optional.empty();
            }

    }

}
