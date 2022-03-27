package com.booking.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document("Bookings")
public class Booking {

    private UUID id;
    private Users bookedBy;
    private Users team1;
    private Users team2;

    public Users getBookedBy() {
        return bookedBy;
    }

    public void setBookedBy(Users bookedBy) {
        this.bookedBy = bookedBy;
    }

    public Users getTeam1() {
        return team1;
    }

    public void setTeam1(Users team1) {
        this.team1 = team1;
    }

    public Users getTeam2() {
        return team2;
    }

    public void setTeam2(Users team2) {
        this.team2 = team2;
    }
}
