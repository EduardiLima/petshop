package br.com.tech4me.petshop.shared;

import java.util.List;

public class PetListagemDto {
    private String id;
    private String nome;
    private List<String> procedimentos;

    public PetListagemDto() {

    }

    public PetListagemDto(String id, String nome, List<String> procedimentos) {
        this.id = id;
        this.nome = nome;
        this.procedimentos = procedimentos;
    }
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public List<String> getProcedimentos() {
        return procedimentos;
    }
    public void setProcedimentos(List<String> procedimentos) {
        this.procedimentos = procedimentos;
    }
    
}
