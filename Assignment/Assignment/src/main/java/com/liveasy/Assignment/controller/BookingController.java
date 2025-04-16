package com.liveasy.Assignment.controller;

import com.liveasy.Assignment.models.Booking;
import com.liveasy.Assignment.models.BookingStatus;
import com.liveasy.Assignment.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping
    public Booking createBooking(@RequestBody Booking booking) {
        return bookingService.createBooking(booking);
    }

    @GetMapping
    public List<Booking> getAllBookings() {
        return bookingService.getAllBookings();
    }

    @GetMapping("/{id}")
    public Optional<Booking> getBookingById(@PathVariable UUID id) {
        return bookingService.getBookingById(id);
    }

    @GetMapping(params = "transporterId")
    public List<Booking> getBookingsByTransporterId(@RequestParam String transporterId) {
        return bookingService.getBookingsByTransporterId(transporterId);
    }

    @GetMapping(params = "loadId")
    public List<Booking> getBookingsByLoadId(@RequestParam UUID loadId) {
        return bookingService.getBookingsByLoadId(loadId);
    }

    @PutMapping("/{id}")
    public Booking updateBooking(@PathVariable UUID id, @RequestBody Booking booking) {
        return bookingService.updateBooking(id, booking);
    }

    @DeleteMapping("/{id}")
    public void deleteBooking(@PathVariable UUID id) {
        bookingService.deleteBooking(id);
    }
    @PutMapping("/accept/{id}")
    public Booking acceptBooking(@PathVariable UUID id) {
        return bookingService.acceptBooking(id);
    }
}
