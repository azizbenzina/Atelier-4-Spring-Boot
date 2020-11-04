package com.aziz.jeuvideo;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.aziz.jeuvideo.entities.Jeuvideo;
import com.aziz.jeuvideo.service.JeuvideoService;

@SpringBootApplication
public class JeuvideoApplication implements CommandLineRunner {
@Autowired
JeuvideoService jeuvideoService;
public static void main(String[] args) {
SpringApplication.run(JeuvideoApplication.class, args);
}
@Override
public void run(String... args) throws Exception {
jeuvideoService.saveJeuvideo(new Jeuvideo("APEX LEGENDS", 26.0, new Date()));
jeuvideoService.saveJeuvideo(new Jeuvideo("PES20", 20.0, new Date()));
jeuvideoService.saveJeuvideo(new Jeuvideo("WATCH DOGS 2", 50.0, new Date()));
}
}