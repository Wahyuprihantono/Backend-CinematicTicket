package com.bioskop.scheduler;

import com.bioskop.model.Films;
import com.bioskop.service.FilmsService;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.List;

public class FilmJob extends QuartzJobBean {

    @Autowired
    private FilmsService filmsService;

    private static final Logger LOG = LoggerFactory.getLogger(FilmJob.class);

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        List<Films> filmsList = filmsService.getAllFilms();
        LOG.info("Film ID      Film Code    Film Name    On Show");
        for (Films films : filmsList) {
            if (films.getIsShow()) {
                LOG.info("{}      {}    {}    {}", films.getFilmId(), films.getFilmCode(), films.getFilmName(), films.getIsShow());
            }
        }
    }
}