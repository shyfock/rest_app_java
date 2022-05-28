package com.example.demorest.services;

import java.util.ArrayList;
import java.util.List;

import com.example.demorest.models.Demo;

import org.springframework.stereotype.Service;

@Service
public class DemoService {
    private List<Demo> demos = new ArrayList<>();

    public List<Demo> getAll() {
        return demos;
    }

    public void add(Demo demo) {
        demos.add(demo);
    }

    public Demo get(String nombre) {
        for (Demo demo : demos) {
            if (demo.getNombre().equalsIgnoreCase(nombre)) {
                return demo;
            }
        }
        return null;
    }
}
