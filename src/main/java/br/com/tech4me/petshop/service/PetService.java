package br.com.tech4me.petshop.service;

import br.com.tech4me.petshop.shared.PetDto;
import br.com.tech4me.petshop.shared.PetListagemDto;

import java.util.List;

public interface PetService { 

    PetDto criarPet(PetDto petDto);
    PetDto obterPetPorId(String Id);
    List<PetListagemDto> obterTodosPets();
    PetDto atualizarPet(String id, PetDto petDto);
    void deletarPet(String id);

}
