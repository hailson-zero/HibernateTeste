package br.com.hibernateteste.controller;

import br.com.hibernateteste.domain.Cliente;
import br.com.hibernateteste.service.ClienteService;
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
@ManagedBean(name="clienteMB")
@SessionScoped
public class ClienteController implements Serializable{
    
    private Cliente cliente = new Cliente();
    private List<Cliente> clientes;
    private ClienteService clienteService = new ClienteService();
       
    public String salvar(int y){
        clientes = new ArrayList<Cliente>();
        for (int x = 1; x <= y; x++){
            cliente = new Cliente();
            cliente.setId(x);
            cliente.setNome(gerarString());
            cliente.setEndereco(gerarString());
            cliente.setCidade(gerarString());
            cliente.setBairro(gerarString());
            cliente.setEstado(gerarString());
            cliente.setCep(gerarString());
            cliente.setTelefone(gerarString());
            cliente.setEmail(gerarString());
            cliente.setNascimento(gerarString());
            clientes.add(cliente);
        }
        if (clienteService.inserir(clientes)){
            UtilMensagens.mensagemSucesso("Sucesso", "Clientes salvos com sucesso!");
            return null;
        }
        UtilMensagens.mensagemErro("Erro", "Ocorreu um erro ao salvar os clientes!");
        return null;
    }
    
    public String alterar(){
        for(Cliente c : clientes) {
                c.setNome(gerarString());
                c.setEndereco(gerarString());
                c.setCidade(gerarString());
                c.setBairro(gerarString());
                c.setEstado(gerarString());
                c.setCep(gerarString());
                c.setTelefone(gerarString());
                c.setEmail(gerarString());
                c.setNascimento(gerarString());
        }
        if (clienteService.alterar(clientes)){
            UtilMensagens.mensagemSucesso("Sucesso", "Clientes alterados com sucesso!");
            return null;
        }
        UtilMensagens.mensagemErro("Erro", "Ocorreu um erro ao alterar os clientes!");
        return null;
    }
    
    public String listar(){
        List<Cliente> clientes2 = new ArrayList<Cliente>();
        clientes2 = clienteService.listar();
        if (!clientes2.isEmpty()){
            UtilMensagens.mensagemSucesso("Sucesso", "Clientes listados com sucesso!");
            return null;
        }
        UtilMensagens.mensagemErro("Erro", "Ocorreu um erro ao listar os Clientes!");
        return null;
    }
    
    public String consultar(Integer x){
        Cliente cliente2 = new Cliente();
        cliente2 = clienteService.consultar(x);
        if (cliente2.getId() != null){
            UtilMensagens.mensagemSucesso("Sucesso", "Busca de Cliente realizada com sucesso!");
            return null;
        }
        UtilMensagens.mensagemErro("Erro", "Ocorreu um erro ao buscar um Cliente!");
        return null;
    }
    
    public String deletar(){
        if (clienteService.deletar(clientes)){
            UtilMensagens.mensagemSucesso("Sucesso", "Clientes excluídos com sucesso!");
            return null;
        }
        UtilMensagens.mensagemErro("Erro", "Ocorreu um erro ao excluir os clientes!");
        return null;
    }
    
    public String gerarString(){
        UUID uuid = UUID.randomUUID();
        String myRandom = uuid.toString();
        return (myRandom.substring(0,20));
    } 

}
