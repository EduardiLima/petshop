package br.com.tech4me.petshop.repository;
import br.com.tech4me.petshop.model.Pet;

import org.springframework.data.mongodb.repository.MongoRepository;
public interface PetRepository extends MongoRepository<Pet, String> {

    
}
