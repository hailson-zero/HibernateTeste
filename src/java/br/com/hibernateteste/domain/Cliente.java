/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hibernateteste.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="cliente")
public class Cliente implements Serializable{
    
    @Id
    private Integer id;
    
    @NotNull
    @Column(name="nome")
    private String nome;
    
    @NotNull
    @Column(name="endereco")
    private String endereco;
    
    @NotNull
    @Column(name="cidade")
    private String cidade;
    
    @NotNull
    @Column(name="bairro")
    private String bairro;
    
    @NotNull
    @Column(name="estado")
    private String estado;
    
    @NotNull
    @Column(name="cep")
    private String cep;
    
    @NotNull
    @Column(name="telefone")
    private String telefone;
    
    @NotNull
    @Column(name="email")
    private String email;
    
    @NotNull
    @Column(name="nascimento")
    private String nascimento;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="id")
    private List<Locacao> locacoes;

    public Cliente() {
    }

    public Cliente(Integer id, String nome, String endereco, String cidade, String bairro, String estado, String cep, String telefone, String email, String nascimento) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.cidade = cidade;
        this.bairro = bairro;
        this.estado = estado;
        this.cep = cep;
        this.telefone = telefone;
        this.email = email;
        this.nascimento = nascimento;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }

    public List<Locacao> getLocacoes() {
        return locacoes;
    }

    public void setLocacoes(List<Locacao> locacoes) {
        this.locacoes = locacoes;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cliente other = (Cliente) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", nome=" + nome + ", endereco=" + endereco + ", cidade=" + cidade + ", bairro=" + bairro + ", estado=" + estado + ", cep=" + cep + ", telefone=" + telefone + ", email=" + email + ", nascimento=" + nascimento + ", locacoes=" + locacoes + '}';
    }

}

