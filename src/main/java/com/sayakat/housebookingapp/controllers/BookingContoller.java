package com.sayakat.housebookingapp.controllers;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sayakat.housebookingapp.model.Booking;
import com.sayakat.housebookingapp.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/booking")
public class BookingContoller {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @GetMapping("/{id}")
    public ResponseEntity<Booking> findOne(@PathVariable Long id) {
        Booking booking = bookingRepository.findById(id).get();
        return new ResponseEntity<>(booking, HttpStatus.OK);
    }

    @GetMapping(value = "/")
    public Page<Booking> getAll(Pageable pageable) {
        return bookingRepository.findAll(pageable);
    }

    //    @ApiOperation(value = "create house")
    @PostMapping(value = "/")
    public ResponseEntity<Booking> create(@RequestBody Booking booking) {
        Booking savedBooking = bookingRepository.save(booking);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedBooking);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Booking> update(@RequestBody Booking booking, @PathVariable Long id) throws JsonMappingException {

        Booking savedBooking = bookingRepository.findById(id).get();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        savedBooking = objectMapper.updateValue(savedBooking, booking);
        bookingRepository.save(savedBooking);
        return ResponseEntity.ok(savedBooking);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        bookingRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
