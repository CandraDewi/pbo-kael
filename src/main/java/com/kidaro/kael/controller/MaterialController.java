package com.kidaro.kael.controller;
import com.kidaro.kael.model.Material;
import com.kidaro.kael.repository.MaterialRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/materials")
@RequiredArgsConstructor
public class MaterialController {
    private final MaterialRepository materialRepo;

    @GetMapping
    public List<Material> getAll() {
        return materialRepo.findAll();
    }
}