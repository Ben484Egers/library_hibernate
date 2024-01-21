package org.benunasat.library.series;

import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.Optional;

interface SerieDAO {

    List<Serie> getAllSeries();

    Serie create(Serie newSerie);

    Serie update(Serie updatedSerie);

    boolean deleteSerie (Long id);

    Optional<Serie> findSerieById(Long id);

    Optional<Serie> findSerieName (String name);
}
