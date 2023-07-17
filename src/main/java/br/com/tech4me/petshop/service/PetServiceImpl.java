package br.com.tech4me.petshop.service;

import br.com.tech4me.petshop.model.Pet;
import br.com.tech4me.petshop.repository.PetRepository;
import br.com.tech4me.petshop.shared.PetDto;
import br.com.tech4me.petshop.shared.PetListagemDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PetServiceImpl implements PetService {
    @Autowired
    private PetRepository petRepository;

    @Override
    public PetDto criarPet(PetDto petDto) {
        Pet pet = new Pet();
        BeanUtils.copyProperties(petDto, pet);
        Pet petSalvo = petRepository.save(pet);
        PetDto petSalvoDto = new PetDto();
        BeanUtils.copyProperties(petSalvo, petSalvoDto);
        return petSalvoDto;
    }

    @Override
    public PetDto obterPetPorId(String id) {
        Pet pet = petRepository.findById(id).orElse(null);
        if (pet != null) {
            PetDto petDto = new PetDto();
            BeanUtils.copyProperties(pet, petDto);
            return petDto;
        } else {
            return null;
        }
    }

    @Override
    public List<PetListagemDto> obterTodosPets() {
        List<Pet> pets = petRepository.findAll();
        return pets.stream()
                .map(pet -> {
                    PetListagemDto petListagemDto = new PetListagemDto();
                    petListagemDto.setId(pet.getId());
                    petListagemDto.setNome(pet.getNome());
                    petListagemDto.setProcedimentos(pet.getProcedimentos());
                    return petListagemDto;
                })
                .collect(Collectors.toList());
    }

    @Override
    public PetDto atualizarPet(String id, PetDto petDto) {
        Pet pet = petRepository.findById(id).orElse(null);
        if (pet != null) {
            BeanUtils.copyProperties(petDto, pet);
            Pet petAtualizado = petRepository.save(pet);
            PetDto petAtualizadoDto = new PetDto();
            BeanUtils.copyProperties(petAtualizado, petAtualizadoDto);
            return petAtualizadoDto;
        } else {
            return null;
        }
    }

    @Override
    public void deletarPet(String id) {
        petRepository.deleteById(id);
    }
}

