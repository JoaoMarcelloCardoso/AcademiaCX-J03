package com.cx.academy.exerciciontt.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_client")
public class ClientModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cpf;

    private String nome;

    @OneToMany(mappedBy = "clientModel", cascade = CascadeType.ALL)
    private List<AddressModel> addresses;

    @OneToMany(mappedBy = "clientModel", cascade = CascadeType.ALL)
    private List<CartModel> carts;

    public ClientModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<AddressModel> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<AddressModel> addresses) {
        this.addresses = addresses;
    }

    public List<CartModel> getCarts() {
        return carts;
    }

    public void setCarts(List<CartModel> carts) {
        this.carts = carts;
    }
}
