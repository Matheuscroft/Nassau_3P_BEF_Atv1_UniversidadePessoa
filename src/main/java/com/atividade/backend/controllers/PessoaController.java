package com.atividade.backend.controllers;

import com.atividade.backend.dtos.PessoaDto;
import com.atividade.backend.models.PessoaModel;
import com.atividade.backend.services.PessoaService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    PessoaService pessoaService;

    public PessoaController() {

    }

    @PostMapping
    public ResponseEntity<Object> savePessoa(@RequestBody @Valid PessoaDto pessoaDto) {

        var pessoaModel = new PessoaModel();
        BeanUtils.copyProperties(pessoaDto, pessoaModel);

        return ResponseEntity.status(HttpStatus.CREATED).body(pessoaService.save(pessoaModel));
    }


    @GetMapping("/{id}")
    public ResponseEntity<Object> getOnePessoa(@PathVariable(value = "id") UUID id) {
        Optional<PessoaModel> pessoaModelOptional = pessoaService.findById(id);
        if (!pessoaModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pessoa não encontrada.");

        }

        return ResponseEntity.status(HttpStatus.OK).body(pessoaModelOptional.get());
    }

}
