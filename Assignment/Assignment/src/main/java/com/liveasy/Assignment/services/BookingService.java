package com.liveasy.Assignment.services;

import com.liveasy.Assignment.models.Booking;
import com.liveasy.Assignment.models.BookingStatus;
import com.liveasy.Assignment.models.Load;
import com.liveasy.Assignment.models.LoadStatus;
import com.liveasy.Assignment.repository.BookingRepository;
import com.liveasy.Assignment.repository.LoadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private LoadRepository loadRepository;

public Booking createBooking(Booking booking) {
    UUID loadId = booking.getLoad().getId();
    Load fullLoad = loadRepository.findById(loadId)
            .orElseThrow(() -> new IllegalArgumentException("Invalid Load ID"));

    if (fullLoad.getStatus() == LoadStatus.CANCELLED) {
        throw new IllegalStateException("Booking cannot be created for a cancelled load.");
    }

    booking.setLoad(fullLoad);  // Set full Load object
    booking.setRequestedAt(LocalDateTime.now());
    booking.setStatus(BookingStatus.PENDING);

    Booking savedBooking = bookingRepository.save(booking);

    fullLoad.setStatus(LoadStatus.BOOKED);
    loadRepository.save(fullLoad);

    return savedBooking;
}

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public Optional<Booking> getBookingById(UUID id) {
        return bookingRepository.findById(id);
    }

    public List<Booking> getBookingsByTransporterId(String transporterId) {
        return bookingRepository.findByTransporterId(transporterId);
    }

    public List<Booking> getBookingsByLoadId(UUID loadId) {
        return bookingRepository.findByLoadId(loadId);
    }

    public Booking updateBooking(UUID id, Booking updatedBooking) {
        return bookingRepository.findById(id).map(booking -> {
            booking.setProposedRate(updatedBooking.getProposedRate());
            booking.setComment(updatedBooking.getComment());
            booking.setStatus(updatedBooking.getStatus());
            return bookingRepository.save(booking);
        }).orElse(null);
    }

    public void deleteBooking(UUID id) {
        Optional<Booking> bookingOpt = bookingRepository.findById(id);
        bookingOpt.ifPresent(booking -> {
            bookingRepository.deleteById(id);
            loadRepository.findById(booking.getLoad().getId()).ifPresent(load -> {
                load.setStatus(LoadStatus.CANCELLED);
                loadRepository.save(load);
            });
        });
    }
    public Booking acceptBooking(UUID bookingId) {
        return bookingRepository.findById(bookingId).map(booking -> {
            booking.setStatus(BookingStatus.ACCEPTED);
            return bookingRepository.save(booking);
        }).orElse(null);
    }
}
