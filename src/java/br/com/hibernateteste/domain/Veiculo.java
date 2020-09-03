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
@Table(name="veiculo")
public class Veiculo implements Serializable{
    
    @Id
    private Integer id;
    
    @NotNull
    @Column(name="placa")
    private String placa;
    
    @NotNull
    @Column(name="marca")
    private String marca;
    
    @NotNull
    @Column(name="modelo")
    private String modelo;
    
    @NotNull
    @Column(name="ano")
    private Integer ano;
    
    @NotNull
    @Column(name="valorDiaria")
    private Double valorDiaria;
    
    @NotNull
    @Column(name="km")
    private Double km;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy="id")
    private List<Locacao> locacoes;

    public Veiculo() {
    }

    public Veiculo(Integer id, String placa, String marca, String modelo, Integer ano, Double valorDiaria, Double km) {
        this.id = id;
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.valorDiaria = valorDiaria;
        this.km = km;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public Double getValorDiaria() {
        return valorDiaria;
    }

    public void setValorDiaria(Double valorDiaria) {
        this.valorDiaria = valorDiaria;
    }

    public Double getKm() {
        return km;
    }

    public void setKm(Double km) {
        this.km = km;
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
        hash = 79 * hash + Objects.hashCode(this.id);
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
        final Veiculo other = (Veiculo) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Veiculo{" + "id=" + id + ", placa=" + placa + ", marca=" + marca + ", modelo=" + modelo + ", ano=" + ano + ", valorDiaria=" + valorDiaria + ", km=" + km + ", locacoes=" + locacoes + '}';
    }
    
}
