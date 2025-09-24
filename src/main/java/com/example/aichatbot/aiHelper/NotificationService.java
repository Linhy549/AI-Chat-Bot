package com.example.aichatbot.aiHelper;

import com.example.aichatbot.model.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
@Service
public class NotificationService {

    @Autowired
    private JavaMailSender mailSender;

    public void notifyAdmin(Appointment appointment) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("linhy549@gmail.com");
        message.setSubject("New Appointment Scheduled");
        message.setText("User " + appointment.getUserName() + " scheduled an appointment on " + appointment.getAppointmentDate());

        mailSender.send(message);
    }
}
