package br.com.tech4me.petshop.shared;

import java.util.List;

public class PetDto {
    private String id;
    private String nome;
    private String raca;
    private int anoNascimento;
    private boolean vacinado;
    private List<String> procedimentos;


    public PetDto() {

    }

    public PetDto(String nome, String raca, int anoNascimento, boolean vacinado, List<String> procedimentos) {
        this.nome = nome;
        this.raca = raca;
        this.anoNascimento = anoNascimento;
        this.vacinado = vacinado;
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
    public String getRaca() {
        return raca;
    }
    public void setRaca(String raca) {
        this.raca = raca;
    }
    public int getAnoNascimento() {
        return anoNascimento;
    }
    public void setAnoNascimento(int anoNascimento) {
        this.anoNascimento = anoNascimento;
    }
    public boolean isVacinado() {
        return vacinado;
    }
    public void setVacinado(boolean vacinado) {
        this.vacinado = vacinado;
    }
    public List<String> getProcedimentos() {
        return procedimentos;
    }
    public void setProcedimentos(List<String> procedimentos) {
        this.procedimentos = procedimentos;
    }
    
}
