package com.poka.app.quartz;

import org.springframework.beans.factory.annotation.Autowired;

import com.poka.app.anno.bussiness.AppointmentBussiness;


public class JobQuartz  {
	
	AppointmentBussiness appointmentBussiness;
	
	@Autowired
	public void setAppointmentBussiness(AppointmentBussiness appointmentBussiness) {
		this.appointmentBussiness = appointmentBussiness;
	}

	public void work() {
		appointmentBussiness.handAppointment();
	}

}
