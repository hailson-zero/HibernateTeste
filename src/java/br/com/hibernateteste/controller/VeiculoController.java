package br.com.hibernateteste.controller;

import br.com.hibernateteste.domain.Veiculo;
import br.com.hibernateteste.service.VeiculoService;
import br.com.hibernateteste.util.UtilMensagens;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
/**
 *
 * @author T-Gamer
 */
@ManagedBean(name="veiculoMB")
@SessionScoped
public class VeiculoController implements Serializable{
    
    private Veiculo veiculo = new Veiculo();
    private List<Veiculo> veiculos;
    private VeiculoService veiculoService = new VeiculoService();
    private Random gerador = new Random();
    
    
        
    public String salvar(int y){
        veiculos = new ArrayList<Veiculo>();
        for (int x = 1; x <= y; x++){
            veiculo = new Veiculo();
            veiculo.setId(x);
            veiculo.setAno(gerador.nextInt());
            veiculo.setKm(gerador.nextDouble());
            veiculo.setMarca(gerarString());
            veiculo.setModelo(gerarString());
            veiculo.setPlaca(gerarString());
            veiculo.setValorDiaria(gerador.nextDouble());
            veiculos.add(veiculo);
        }
        if (veiculoService.inserir(veiculos)){
            UtilMensagens.mensagemSucesso("Sucesso", "Veiculos salvos com sucesso!");
            return null;
        }
        UtilMensagens.mensagemErro("Erro", "Ocorreu um erro ao salvar os veiculos!");
        return null;
    }
    
    public String alterar(){
        for(Veiculo v : veiculos) {
                v.setAno(gerador.nextInt());
                v.setKm(gerador.nextDouble());
                v.setMarca(gerarString());
                v.setModelo(gerarString());
                v.setPlaca(gerarString());
                v.setValorDiaria(gerador.nextDouble());
        }
        if (veiculoService.alterar(veiculos)){
            UtilMensagens.mensagemSucesso("Sucesso", "Veiculos alterados com sucesso!");
            return null;
        }
        UtilMensagens.mensagemErro("Erro", "Ocorreu um erro ao alterar os veiculos!");
        return null;
    }
    
    public String listar(){
        List<Veiculo> veiculos2 = new ArrayList<Veiculo>();
        veiculos2 = veiculoService.listar();
        if (!veiculos2.isEmpty()){
            UtilMensagens.mensagemSucesso("Sucesso", "Veiculos listados com sucesso!");
            return null;
        }
        UtilMensagens.mensagemErro("Erro", "Ocorreu um erro ao listar os Veiculos!");
        return null;
    }
    
    public String consultar(Integer x){
        Veiculo veiculo2 = new Veiculo();
        veiculo2 = veiculoService.consultar(x);
        if (veiculo2.getId() != null){
            UtilMensagens.mensagemSucesso("Sucesso", "Busca de Veiculo realizada com sucesso!");
            return null;
        }
        UtilMensagens.mensagemErro("Erro", "Ocorreu um erro ao buscar um Veiculo!");
        return null;
    }
    
    public String deletar(){
        if (veiculoService.deletar(veiculos)){
            UtilMensagens.mensagemSucesso("Sucesso", "Veiculos excluídos com sucesso!");
            return null;
        }
        UtilMensagens.mensagemErro("Erro", "Ocorreu um erro ao excluir os veiculos!");
        return null;
    }
    
    public String gerarString(){
        UUID uuid = UUID.randomUUID();
        String myRandom = uuid.toString();
        return (myRandom.substring(0,20));
    } 
    
    
}
