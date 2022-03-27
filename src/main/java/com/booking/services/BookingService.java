package com.booking.services;


import com.booking.entity.Booking;
import com.booking.repository.BookingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BookingService {
    private final BookingRepository bookingRepository;

    BookingService(BookingRepository bookingRepository){
        this.bookingRepository = bookingRepository;
    }

    public Booking saveBooking(Booking booking) throws RuntimeException{
        try{
            Booking savedBooking = bookingRepository.save(booking);
            return savedBooking;
        } catch(Exception e){
            throw new RuntimeException("Unable to create user");
        }
    }
}
