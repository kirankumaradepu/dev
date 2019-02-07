package coder.flightreservations.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private String customerName;
    private String seatNo;
    private Integer ticketType;
    private String confirmationNo;

    public Reservation() {
    }

    public Reservation(String customerName, String seatNo, Integer ticketType, String confirmationNo) {
        this.customerName = customerName;
        this.seatNo = seatNo;
        this.ticketType = ticketType;
        this.confirmationNo = confirmationNo;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(String seatNo) {
        this.seatNo = seatNo;
    }

    public Integer getTicketType() {
        return ticketType;
    }

    public void setTicketType(Integer ticketType) {
        this.ticketType = ticketType;
    }

    public String getConfirmationNo() {
        return confirmationNo;
    }

    public void setConfirmationNo(String confirmationNo) {
        this.confirmationNo = confirmationNo;
    }

    public long getId() {
        return id;
    }
}
