package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class CtrProduct {

    @GetMapping("/Category")
    public List<Category> getCategories() {
        List<Category> categories = new ArrayList<>();
        categories.add(new Category(1, "Lentes", "Lts", 1));
        categories.add(new Category(2, "Refrescos", "Rfsc", 1));
        categories.add(new Category(3, "Playeras", "Ply", 1));
        return categories;
    }
}