package com.realdolmen.rair.domain.jsf;

import com.realdolmen.rair.data.dao.FlightDao;
import com.realdolmen.rair.data.dao.UserDao;
import com.realdolmen.rair.domain.controllers.FlightController;
import com.realdolmen.rair.domain.entities.Airport;
import com.realdolmen.rair.domain.entities.Flight;
import com.realdolmen.rair.domain.entities.FlightClass;
import com.realdolmen.rair.domain.entities.user.Partner;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.criteria.CriteriaQuery;
import javax.validation.constraints.*;


@Named(value = "search")
@SessionScoped
public class SearchBean implements Serializable {

    //region CONSTANTS -

    //endregion

    //region Private Member Variables +

    //  partner

    private Airport fromLocation;
    private Airport toLocation;

    @Future(message = "- Please select atleast 1 day later than now.")
    @Temporal(value = TemporalType.DATE)
    @NotNull(message = "- Please select a date of departure.")
    private Date dateOfDeparture;

    @Future(message = "- The selected date of arrival has to be in the future.")
    @Temporal(value = TemporalType.DATE)
    private Date dateOfArrival;

    @NotNull(message = "- The field 'Tickets for Adults' is required.")
    @Min(value = 1, message = "- Atleast 1 Adult ticket is required.")
    @Max(value = 6, message = "- Maximum of 6 tickets for adults allowed, for more please contact our desk.")
    private Integer ticketsAdults;

    @Max(value = 6, message = "- Maximum of 6 tickets for kids allowed, for more please contact our desk.")
    private Integer ticketsKids;

    private List<Flight> lstFlights;
    private FlightClass flightClass;

    @NotNull(message = "- Please select a flightclass.")
    private FlightClass selectedFlightClass;

    private List<Partner> lstPartners;

    @NotNull(message = "- Please select a company you would like to fly with.")
    private Partner selectedPartner;

    @Inject
    private FlightDao flightDao;

    @Inject
    private UserDao userDao;

    //endregion

    //region Private Properties +

    @PostConstruct
    private void getPartners() {
        Partner p = new Partner();
        p.setCompanyName("Bruce Wayne Co");
        userDao.insert(p);
        Partner p2 = new Partner();
        p2.setCompanyName("Fresh Prince of Bel-Air");
        userDao.insert(p2);
        this.lstPartners = userDao.findAll(Partner.class);
    }

    //endregion

    //region Private Methods -

    //endregion

    //region Constructors -

    //endregion

    //region Public Properties +

    public Integer getTicketsAdults() {
        return ticketsAdults;
    }

    public void setTicketsAdults(Integer ticketsAdults) {
        this.ticketsAdults = ticketsAdults;
    }

    public Integer getTicketsKids() {
        return ticketsKids;
    }

    public void setTicketsKids(Integer ticketsKids) {
        this.ticketsKids = ticketsKids;
    }

    public Date getDateOfDeparture() {
        return dateOfDeparture;
    }

    public void setDateOfDeparture(Date dateOfDeparture) {
        this.dateOfDeparture = dateOfDeparture;
    }

    public Date getDateOfArrival() {
        return dateOfArrival;
    }

    public void setDateOfArrival(Date dateOfArrival) {
        this.dateOfArrival = dateOfArrival;
    }

    public Airport getFromLocation() {
        return fromLocation;
    }

    public void setFromLocation(Airport fromLocation) {
        this.fromLocation = fromLocation;
    }

    public Airport getToLocation() {
        return toLocation;
    }

    public void setToLocation(Airport toLocation) {
        this.toLocation = toLocation;
    }

    public List<Flight> getLstFlights() {
        return lstFlights;
    }

    public void setLstFlights(List<Flight> lstFlights) {
        this.lstFlights = lstFlights;
    }

    public FlightClass[] getFlightEnum() {
        return this.flightClass.values();
    }

    public FlightClass getSelectedFlightClass() {
        return selectedFlightClass;
    }

    public void setSelectedFlightClass(FlightClass selectedFlightClass) {
        this.selectedFlightClass = selectedFlightClass;
    }

    public Partner getSelectedPartner() {
        return selectedPartner;
    }

    public void setSelectedPartner(Partner selectedPartner) {
        this.selectedPartner = selectedPartner;
    }

    public List<Partner> getLstPartners() {
        return lstPartners;
    }

    //endregion

    //region Public Methods +

    public void search() {
        //TODO: formvalidatie
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Fatal!", "System Error"));
    }

    //endregion

}