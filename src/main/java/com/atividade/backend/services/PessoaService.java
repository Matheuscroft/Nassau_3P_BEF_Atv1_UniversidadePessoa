package com.atividade.backend.services;

import com.atividade.backend.models.PessoaModel;
import com.atividade.backend.repositories.PessoaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class PessoaService {

    @Autowired
    PessoaRepository pessoaRepository;

    public PessoaService() {

    }

    @Transactional
    public PessoaModel save(PessoaModel pessoaModel) {
        return pessoaRepository.save(pessoaModel);
    }


    public Optional<PessoaModel> findById(UUID id) {
        return pessoaRepository.findById(id);
    }
}


