package com.spring.academiacx.model;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "tb_cliente")
public class ClienteModel {

    @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int cpf;
    private String nome;

    public ClienteModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
