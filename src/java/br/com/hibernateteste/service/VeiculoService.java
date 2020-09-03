package br.com.hibernateteste.service;

import br.com.hibernateteste.dao.VeiculoDao;
import br.com.hibernateteste.domain.Veiculo;
import java.util.List;

/**
 *
 * @author T-Gamer
 */
public class VeiculoService {
    
    private VeiculoDao veiculoDao = new VeiculoDao();
    
    
    public List<Veiculo> listar(){
        return veiculoDao.listar();
    }
    
    public Veiculo consultar(Integer id){
        return veiculoDao.consultar(id);
    }
    
    public boolean inserir(List<Veiculo> veiculos){
        return veiculoDao.inserir(veiculos);
    }
    
    public boolean alterar(List<Veiculo> veiculos){
        return veiculoDao.alterar(veiculos);
    }
    
    public boolean deletar(List<Veiculo> veiculos){
        return veiculoDao.deletar(veiculos);
    }
}
