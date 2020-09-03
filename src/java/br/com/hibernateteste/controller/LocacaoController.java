package br.com.hibernateteste.controller;

import br.com.hibernateteste.domain.Cliente;
import br.com.hibernateteste.domain.Locacao;
import br.com.hibernateteste.domain.Veiculo;
import br.com.hibernateteste.service.ClienteService;
import br.com.hibernateteste.service.LocacaoService;
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
@ManagedBean(name="locacaoMB")
@SessionScoped
public class LocacaoController implements Serializable{
    
    private Locacao locacao = new Locacao();
    private List<Locacao> locacoes;
    private LocacaoService locacaoService = new LocacaoService();
    
    private List<Cliente> clientes;
    private ClienteService clienteService = new ClienteService();
    
    private List<Veiculo> veiculos;
    private VeiculoService veiculoService = new VeiculoService();
    
    private Random gerador = new Random();
        
    public String salvar(int y){
        locacoes = new ArrayList<Locacao>();
        clientes = new ArrayList<Cliente>();
        clientes = clienteService.listar();
        veiculos = new ArrayList<Veiculo>();
        veiculos = veiculoService.listar();
        for (int x = 1; x <= y; x++){
            locacao = new Locacao();
            locacao.setId(x);
            locacao.setCliente(clientes.get(gerador.nextInt(y-1)));
            locacao.setVeiculo(veiculos.get(gerador.nextInt(y-1)));
            locacao.setDataInicio(gerarString());
            locacao.setDataFim(gerarString());
            locacao.setValor(gerador.nextDouble());
            locacoes.add(locacao);
            //System.out.println(locacao.getValor());
        }
        if (locacaoService.inserir(locacoes)){
            UtilMensagens.mensagemSucesso("Sucesso", "Locacoes salvas com sucesso!");
            return null;
        }
        UtilMensagens.mensagemErro("Erro", "Ocorreu um erro ao salvar as locacoes!");
        return null;
    }
    
    public String alterar(int y){
        for(Locacao l : locacoes) {
            l.setCliente(clientes.get(gerador.nextInt(y-1)));
            l.setVeiculo(veiculos.get(gerador.nextInt(y-1)));
            l.setDataInicio(gerarString());
            l.setDataFim(gerarString());
            l.setValor(gerador.nextDouble());
        }
        if (locacaoService.alterar(locacoes)){
            UtilMensagens.mensagemSucesso("Sucesso", "Locações alteradas com sucesso!");
            return null;
        }
        UtilMensagens.mensagemErro("Erro", "Ocorreu um erro ao alterar as Locações!");
        return null;
    }
    
    public String listar(){
        List<Locacao> locacoes2 = new ArrayList<Locacao>();
        locacoes2 = locacaoService.listar();
        if (!locacoes2.isEmpty()){
            UtilMensagens.mensagemSucesso("Sucesso", "Locações listadas com sucesso!");
            return null;
        }
        UtilMensagens.mensagemErro("Erro", "Ocorreu um erro ao listar as Locações!");
        return null;
        
    }
    
    public String consultar(Integer x){
        Locacao locacao2 = new Locacao();
        locacao2 = locacaoService.consultar(x);
        if (locacao2.getId() != null){
            UtilMensagens.mensagemSucesso("Sucesso", "Busca de Locação realizada com sucesso!");
            return null;
        }
        UtilMensagens.mensagemErro("Erro", "Ocorreu um erro ao buscar um Locação!");
        return null;
        
    }
    
    public String deletar(){
        if (locacaoService.deletar(locacoes)){
            UtilMensagens.mensagemSucesso("Sucesso", "Locacoes excluídas com sucesso!");
            return null;
        }
        UtilMensagens.mensagemErro("Erro", "Ocorreu um erro ao excluir as locacoes!");
        return null;
    }
    
    public String gerarString(){
        UUID uuid = UUID.randomUUID();
        String myRandom = uuid.toString();
        return (myRandom.substring(0,20));
    } 

}

