package com.liveasy.Assignment.controller;

import com.liveasy.Assignment.models.Load;
import com.liveasy.Assignment.services.LoadService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/load")
public class LoadController {

    @Autowired
    private LoadService loadService;

    @PostMapping
    public Load createLoad(@Valid @RequestBody Load load) {
        return loadService.createLoad(load);
    }

    @GetMapping
    public List<Load> getAllLoads() {
        return loadService.getAllLoads();
    }

    @GetMapping("/{id}")
    public Optional<Load> getLoadById(@PathVariable UUID id) {
        return loadService.getLoadById(id);
    }

    @GetMapping(params = "shipperId")
    public List<Load> getLoadsByShipperId(@RequestParam String shipperId) {
        return loadService.getLoadsByShipperId(shipperId);
    }

    @GetMapping(params = "truckType")
    public List<Load> getLoadsByTruckType(@RequestParam String truckType) {
        return loadService.getLoadsByTruckType(truckType);
    }

    @PutMapping("/{id}")
    public Load updateLoad(@PathVariable UUID id, @RequestBody Load load) {
        return loadService.updateLoad(id, load);
    }

    @DeleteMapping("/{id}")
    public void deleteLoad(@PathVariable UUID id) {
        loadService.deleteLoad(id);
    }

}
