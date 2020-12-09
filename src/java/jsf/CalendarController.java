/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import jpa.entidades.Tutorias;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.LazyScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;

/**
 *
 * @author Gus
 */
@Named
@SessionScoped
public class CalendarController implements Serializable {

    @EJB
    private jpa.sessions.TutoriasFacade tutoriasFacade;

    private ScheduleModel lazyEventModel;
    private ScheduleEvent event = new DefaultScheduleEvent();

    @PostConstruct
    public void init() {
        lazyEventModel = new LazyScheduleModel() {
            @Override
            public void loadEvents(Date start, Date end) {
                List<Tutorias> tutorias = tutoriasFacade.findAll();
                tutorias.stream().map(tutoria -> {
                    Date startDate = new Date(
                            tutoria.getFecha().getYear(),
                            tutoria.getFecha().getMonth(),
                            tutoria.getFecha().getDate(),
                            tutoria.getHorainicio().getHours(),
                            tutoria.getHorainicio().getMinutes()
                    );

                    Date endDate = new Date(
                            tutoria.getFecha().getYear(),
                            tutoria.getFecha().getMonth(),
                            tutoria.getFecha().getDate(),
                            tutoria.getHorafin().getHours(),
                            tutoria.getHorafin().getMinutes()
                    );

                    DefaultScheduleEvent defaultScheduleEvent = new DefaultScheduleEvent();

                    defaultScheduleEvent.setTitle(tutoria.getAsignatura().getNombreAsignatura());
                    defaultScheduleEvent.setStartDate(startDate);
                    defaultScheduleEvent.setEndDate(endDate);
                    defaultScheduleEvent.setData(tutoria);

                    return defaultScheduleEvent;

                    /*return DefaultScheduleEvent.builder()
                            .title(tutoria.getAsignatura().getNombreAsignatura())
                            .startDate(startDate)
                            .endDate(endDate)
                            .data(tutoria)
                            .build();*/
                }).forEach(ev -> addEvent(ev));
            }

        };

    }

    public ScheduleModel getLazyEventModel() {
        return lazyEventModel;
    }

    public void setLazyEventModel(ScheduleModel lazyEventModel) {
        this.lazyEventModel = lazyEventModel;
    }
}
