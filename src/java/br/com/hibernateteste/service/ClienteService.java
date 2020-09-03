package br.com.hibernateteste.service;

import br.com.hibernateteste.dao.ClienteDao;
import br.com.hibernateteste.domain.Cliente;
import java.util.List;

/**
 *
 * @author T-Gamer
 */
public class ClienteService {
    
    private ClienteDao clienteDao = new ClienteDao();
    
    
    public List<Cliente> listar(){
        return clienteDao.listar();
    }
    
    public Cliente consultar(Integer id){
        return clienteDao.consultar(id);
    }
    
    public boolean inserir(List<Cliente> clientes){
        return clienteDao.inserir(clientes);
    }
    
    public boolean alterar(List<Cliente> clientes){
        return clienteDao.alterar(clientes);
    }
    
    public boolean deletar(List<Cliente> clientes){
        return clienteDao.deletar(clientes);
    }
}