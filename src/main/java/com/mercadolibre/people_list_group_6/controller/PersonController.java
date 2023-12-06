package com.mercadolibre.people_list_group_6.controller;
import com.mercadolibre.people_list_group_6.exceptions.ErrorClassDoc;
import com.mercadolibre.people_list_group_6.model.Person;
import com.mercadolibre.people_list_group_6.repository.PersonRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import com.mercadolibre.people_list_group_6.service.PersonService;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pessoas")
public class PersonController {

    private final PersonService personService;
    private final PersonRepository personRepository;

    @Operation(summary = "Get ID persons", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "OK"),
            @ApiResponse(responseCode = "400", description = "bad request"),
    })
    @GetMapping("/{id}")
    public ResponseEntity<Person> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(personRepository.findById(id).
                orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)));
    }

    @Operation(summary = "Cont persons", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "OK"),
            @ApiResponse(responseCode = "400", description = "bad request"),
    })
    @GetMapping("/contagem-pessoas")
    public ResponseEntity<String> getPersonCount() {
        return ResponseEntity.ok(String.valueOf(personService.getPersonCount()));
    }

    @Operation(summary = "Filter person", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "OK"),
            @ApiResponse(responseCode = "400", description = "bad request"),
    })
    @GetMapping("/persons")
    public ResponseEntity<List<Person>> getPersonsByFilter(@RequestParam String filter) {
        List<Person> filteredPersons = personRepository.findByNicknameContainingIgnoreCaseOrNameContainingIgnoreCase(filter, filter);
        return ResponseEntity.ok(filteredPersons);
    }

    @Operation(summary = "Create Person", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Created", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Person.class))),
            @ApiResponse(responseCode = "422", description = "Unprocessable Entity/Content", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorClassDoc.class))),
    })
    @PostMapping("")
    public ResponseEntity<Person> createPerson(@RequestBody Person person) {
        var createdPerson = personService.create(person);
        var location = URI.create(String.format("/person/%s", createdPerson.getUUID()));
        return ResponseEntity.created(location).body(createdPerson);

    }
    @Operation(summary = "Get ID Persons", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "OK"),
            @ApiResponse(responseCode = "400", description = "bad request"),
    })
    @PutMapping("/{id}")
    public ResponseEntity<Void> updatePerson(@PathVariable UUID id, @RequestBody Person updatedPerson) {
        personService.update(id, updatedPerson);
        return ResponseEntity.noContent().build();
    }
    @Operation(summary = "Delete Persons", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "OK"),
            @ApiResponse(responseCode = "400", description = "bad request"),
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePerson(@PathVariable UUID id) {
        personService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
