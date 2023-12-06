package com.mercadolibre.people_list_group_6.controller;

import com.mercadolibre.people_list_group_6.model.Person;
import com.mercadolibre.people_list_group_6.model.Stack;
import com.mercadolibre.people_list_group_6.repository.StackRepository;
import com.mercadolibre.people_list_group_6.service.StackService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.net.URI;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stack")
public class StackController {
    private final StackService stackService;
    private final StackRepository stackRepository;

    @GetMapping("/{id}")
    public ResponseEntity<Stack> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(stackRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)));
    }

    @PostMapping
    public ResponseEntity<Stack> createStack(@RequestBody Stack stack) {
        var newStack = stackService.create(stack);
        var location = URI.create(String.format("/stack/%s", newStack.getUUID()));
        return ResponseEntity.created(location).body(newStack);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStack(@PathVariable UUID id) {
        stackService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateStack(@PathVariable UUID id, @RequestBody Stack updatedStack) {
        stackService.update(id, updatedStack);
        return ResponseEntity.noContent().build();
    }

}
