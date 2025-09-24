package com.example.aichatbot.aiHelper;

import com.example.aichatbot.model.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AppointmentService {

    private final List<Appointment> appointments = new ArrayList<>();

    @Autowired
    private NotificationService notificationService;

    public void bookAppointment(Appointment appointment) {
        appointments.add(appointment);
        notificationService.notifyAdmin(appointment); // send email
    }
}

