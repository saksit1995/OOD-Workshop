package com.example.restapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class GenerateIdService {

    private Random random;

    public String getId() {
        return "XYZ" + random.nextInt(10);
    }

    @Autowired
    public void setRandom(Random random) {
        this.random = random;
    }
}