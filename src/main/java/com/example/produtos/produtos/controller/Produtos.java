package com.example.produtos.produtos.controller;

public class Produtos {

    private int id;
    private String nome;
    private double preco;
    private String cor;
    private String marca;
    private int potenciarms;

    public Produtos(String nome, double preco, String cor, String marca, int potenciarms) {
        this.nome = nome;
        this.preco = preco;
        this.cor = cor;
        this.marca = marca;
        this.potenciarms = potenciarms;
    }

    public Produtos(int id, String nome, double preco, String cor, String marca, int potenciarms) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.cor = cor;
        this.marca = marca;
        this.potenciarms = potenciarms;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getPotenciarms() {
        return potenciarms;
    }

    public void setPotenciarms(int potenciarms) {
        this.potenciarms = potenciarms;
    }
}
