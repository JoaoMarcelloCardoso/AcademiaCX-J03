package com.demo.academiacx.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_endereco")
public class EnderecoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String cep;

    private String logradouro;

    private String bairro;

    private String cidade;

    private String numeroEndereco;

    //Utilizei como base o código de UF que está na nota fiscal
    private Integer UF;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private ClienteModel cliente;


    public EnderecoModel(Long id, String cep, String logradouro, String bairro, String cidade, String numeroEndereco, Integer UF, ClienteModel cliente) {
        this.id = id;
        this.cep = cep;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.cidade = cidade;
        this.numeroEndereco = numeroEndereco;
        this.UF = UF;
        this.cliente = cliente;
    }

    public EnderecoModel() {

    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getNumeroEndereco() {
        return numeroEndereco;
    }

    public void setNumeroEndereco(String numeroEndereco) {
        this.numeroEndereco = numeroEndereco;
    }

    public Integer getUF() {
        return UF;
    }

    public void setUF(Integer UF) {
        this.UF = UF;
    }

    public ClienteModel getClienteModel() {
        return cliente;
    }

    public void setClienteModel(ClienteModel cliente) {
        this.cliente = cliente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
