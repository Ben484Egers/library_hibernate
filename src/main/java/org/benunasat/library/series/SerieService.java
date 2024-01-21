package org.benunasat.library.series;


import org.benunasat.library.config.JPAConfig;

import java.util.List;
import java.util.Optional;

public class SerieService {

    private final SerieDAOImpl serieDAO;

    public SerieService() {
        this.serieDAO = new SerieDAOImpl(JPAConfig.getEntityManager());
    }


    public List<Serie> getAllAuthors() {
        return serieDAO.getAllSeries();
    }

    public Serie getSerieByName(String name) {

        Optional<Serie> optionalSerie = serieDAO.findSerieName(name);

        if (optionalSerie.isEmpty()) {
            throw new IllegalArgumentException("NO SERIE FOUND WITH NAME");
        }

        return optionalSerie.get();
    }
    public Serie getSerieById(Long id) {

        Optional<Serie> optionalSerie = serieDAO.findSerieById(id);

        if (optionalSerie.isEmpty()) {
            throw new IllegalArgumentException("NO SERIE FOUND WITH NAME");
        }

        return optionalSerie.get();
    }


    public Serie updateSerieDetails(Serie serie) {

        Serie updatedSerie =  serieDAO.update(serie);

        return updatedSerie;
    }


    public void deleteSerie(Long id) {
        serieDAO.deleteSerie(id);
    }

}
