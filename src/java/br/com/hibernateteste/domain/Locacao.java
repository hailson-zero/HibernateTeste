/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hibernateteste.domain;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="locacao")
public class Locacao implements Serializable{
    
    @Id
    private Integer id;
    
    @NotNull
    @Column(name="dataInicio")
    private String dataInicio;
    
    @NotNull
    @Column(name="dataFim")
    private String dataFim;
    
    @NotNull
    @Column(name="valor")
    private Double valor;
    
    @ManyToOne(optional = false)
    @JoinColumn(name="idCliente", referencedColumnName="id")
    private Cliente cliente;
    
    @ManyToOne(optional = false)
    @JoinColumn(name="idVeiculo", referencedColumnName="id")
    private Veiculo veiculo;

    public Locacao() {
    }

    public Locacao(Integer id, String dataInicio, String dataFim, Double valor, Cliente cliente, Veiculo veiculo) {
        this.id = id;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.valor = valor;
        this.cliente = cliente;
        this.veiculo = veiculo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataFim() {
        return dataFim;
    }

    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
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
        final Locacao other = (Locacao) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Locacao{" + "id=" + id + ", dataInicio=" + dataInicio + ", dataFim=" + dataFim + ", valor=" + valor + ", cliente=" + cliente + ", veiculo=" + veiculo + '}';
    }
    
    
}
