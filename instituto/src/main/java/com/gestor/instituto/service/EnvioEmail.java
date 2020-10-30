package com.gestor.instituto.service;

import com.gestor.instituto.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EnvioEmail {



    @Autowired
    private JavaMailSender mailSender;


    public void sendEmail(String to, String subject, String content) {

        SimpleMailMessage email = new SimpleMailMessage();

        email.setTo(to);
        email.setSubject(subject);
        email.setText(content);

        mailSender.send(email);
    }

    public void sendEmail(Usuario u, String subject, String content) {



            SimpleMailMessage email = new SimpleMailMessage();


            email.setTo(u.getEmail());
            email.setSubject(subject);
            email.setText(content);

            mailSender.send(email);
        }

    }



