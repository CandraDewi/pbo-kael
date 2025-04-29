package com.kidaro.kael.controller;

import com.kidaro.kael.model.Menfess; // Assuming Note is in this package
import com.kidaro.kael.repository.MenfessRepository; // Assuming NoteRepository is in this package
import java.util.List;
import org.springframework.web.bind.annotation.*;
import java.util.Arrays;
import java.util.Random;

@RestController
@RequestMapping("/menfess")
@CrossOrigin(origins = "*")
public class MenfessController {
    private final MenfessRepository repo;

    public MenfessController(MenfessRepository repo) {
        this.repo = repo;
    }

    private final List<String> names = Arrays.asList(
        "🌸 Fluffy Panda", "🌼 Pink Goose", "🦊 Sneaky Fox",
        "🐢 Lazy Turtle", "🐸 Cheeky Frog", "🍄 Mushy Elf",
        "💡 Anonymous Bee", "🌈 Rainbow Wisp","Mekel 😈"
    );

    private String randomName() {
        return names.get(new Random().nextInt(names.size()));
    }

    @PostMapping("/add")
    public Menfess add(@RequestBody Menfess request) {
        request.setSender(randomName());
        return repo.save(request);
    }

    @GetMapping("/all")
    public List<Menfess> getAll() {
        return repo.findAll();
    }
}

