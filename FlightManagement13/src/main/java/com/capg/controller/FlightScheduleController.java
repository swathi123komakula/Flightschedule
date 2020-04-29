package com.capg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.entity.FlightSchedule;
import com.capg.exceptions.IdNotFoundException;
import com.capg.service.FlightScheduleService;

@RestController
	@RequestMapping("/flightdetailss")
	@CrossOrigin("http://localhost:4200")
	public class FlightScheduleController {
		@Autowired
		 FlightScheduleService serviceobj;

		
		@GetMapping("/addFlightSchedule/{id}")
		private ResponseEntity<FlightSchedule> getFlightSchedule(@PathVariable("id") int id) {
			FlightSchedule f = serviceobj.addFlightScheduleById(id);
			if (f == null) {
				throw new IdNotFoundException("Id does not exist,so we couldn't fetch details");
			} else {
				return new ResponseEntity<FlightSchedule>(f, new HttpHeaders(), HttpStatus.OK);
			}
		}

		@GetMapping("/addFlightSchedule")
		private ResponseEntity<List<FlightSchedule>> addFlightSchedule() {
			List<FlightSchedule> flilist = serviceobj.getAllFlightSchedule();
			return new ResponseEntity<List<FlightSchedule>>(flilist, new HttpHeaders(), HttpStatus.OK);

		}

		
		@PutMapping("/UpdateFlightSchedule")
		public ResponseEntity<String> UpdateFlightSchedule(@RequestBody FlightSchedule fli) {
			FlightSchedule f = serviceobj.UpdateFlightSchedule(fli);
			if (f == null) {
				throw new IdNotFoundException("Update Operation Unsuccessful,Provided Id does not exist");
			} else {
				return new ResponseEntity<String>("flightdetails updated successfully", new HttpHeaders(), HttpStatus.OK);
			}
		}

		
		@DeleteMapping("/DeleteFlightSchedule/{id}")
		private ResponseEntity<String> delFli(@PathVariable("id") int id) {
			FlightSchedule f = serviceobj.delete(id);
			if (f == null) {
				throw new IdNotFoundException("Delete Operation Unsuccessful,Provided Id does not exist");
			} else {
				return new ResponseEntity<String>("Employee deleted successfully", new HttpHeaders(), HttpStatus.OK);
			}
		}

		@ExceptionHandler(IdNotFoundException.class)
		public ResponseEntity<String> userNotFound(IdNotFoundException f) {
			return new ResponseEntity<String>(f.getMessage(), HttpStatus.NOT_FOUND);
		}
}
