package com.capg.entity;

import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
	public class Schedule 
	{
	    @Id
	    @Column(name="source_airport")
	    String sourceAirport;
	    @Column(name="destination_airport")
	    String destinationAirport;
	    @Column(name="arrival_time")
	    LocalTime arrivalTime;
	    @Column(name="departure_time")
	    LocalTime departureTime;
	    public Schedule() {}
		public Schedule(String sourceAirport, String destinationAirport, LocalTime arrivalTime,
				LocalTime departureTime) {
			super();
			this.sourceAirport = sourceAirport;
			this.destinationAirport = destinationAirport;
			this.arrivalTime = arrivalTime;
			this.departureTime = departureTime;
		}
		public String getSourceAirport() {
			return sourceAirport;
		}
		public void setSourceAirport(String sourceAirport) {
			this.sourceAirport = sourceAirport;
		}
		public String getDestinationAirport() {
			return destinationAirport;
		}
		public void setDestinationAirport(String destinationAirport) {
			this.destinationAirport = destinationAirport;
		}
		public LocalTime getArrivalTime() {
			return arrivalTime;
		}
		public void setArrivalTime(LocalTime arrivalTime) {
			this.arrivalTime = arrivalTime;
		}
		public LocalTime getDepartureTime() {
			return departureTime;
		}
		public void setDepartureTime(LocalTime departureTime) {
			this.departureTime = departureTime;
		}
	}