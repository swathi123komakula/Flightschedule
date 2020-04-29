package com.capg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capg.dao.FlightScheduleDAO;
import com.capg.entity.FlightSchedule;

@Service
public abstract class FlightScheduleService 
{
    @Autowired
    FlightScheduleDAO fsdao;
    public void setFsdao(FlightScheduleDAO fsdao) { this.fsdao=fsdao; }
    
    @Transactional(readOnly=true)
    public FlightSchedule getFlightSchedule(String scheduleId)
    {
    	return fsdao.findById(scheduleId).get();
    }
    
    @Transactional(readOnly=true)
    public List<FlightSchedule> getAllFlightSchedule()
    {
    	return fsdao.findAll();
    }
    
    @Transactional
    public void addFlightSchedule(FlightSchedule flightSchedule)
    {
    	  fsdao.save(flightSchedule);
    }
    
    @Transactional
    public void updateFlightSchedule(FlightSchedule flightSchedule)
    {
    	  fsdao.save(flightSchedule);
    }
    
    @Transactional
    public void deleteFlightSchedule(String scheduleId)
    {
    	  fsdao.deleteById(scheduleId);
    }
}
