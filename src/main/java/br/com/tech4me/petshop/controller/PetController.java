package br.com.tech4me.petshop.controller;

import br.com.tech4me.petshop.service.PetService;
import br.com.tech4me.petshop.shared.PetDto;
import br.com.tech4me.petshop.shared.PetListagemDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pets")
public class PetController {
    @Autowired
    private PetService petService;

    @PostMapping
    public ResponseEntity<PetDto> criarPet(@RequestBody PetDto petDto) {
        PetDto petSalvoDto = petService.criarPet(petDto);
        return new ResponseEntity<>(petSalvoDto, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PetDto> obterPetPorId(@PathVariable("id") String id) {
        PetDto petDto = petService.obterPetPorId(id);
        if (petDto != null) {
            return new ResponseEntity<>(petDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<PetListagemDto>> obterTodosPets() {
        List<PetListagemDto> pets = petService.obterTodosPets();
        return new ResponseEntity<>(pets, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PetDto> atualizarPet(@PathVariable("id") String id, @RequestBody PetDto petDto) {
        PetDto petAtualizadoDto = petService.atualizarPet(id, petDto);
        if (petAtualizadoDto != null) {
            return new ResponseEntity<>(petAtualizadoDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPet(@PathVariable("id") String id) {
        petService.deletarPet(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}