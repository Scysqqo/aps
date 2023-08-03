package com.aps.aps.Models;



public class User {
   
    private long id;
    private String nome;
    private String utilizador;
    private String senha;
    private String dataN;
    private String ocupacao;
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getUtilizador() {
        return utilizador;
    }
    public void setUtilizador(String utilizador) {
        this.utilizador = utilizador;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public String getDataN() {
        return dataN;
    }
    public void setDataN(String dataN) {
        this.dataN = dataN;
    }
    public String getOcupacao() {
        return ocupacao;
    }
    public void setOcupacao(String ocupacao) {
        this.ocupacao = ocupacao;
    }
    
    
}
