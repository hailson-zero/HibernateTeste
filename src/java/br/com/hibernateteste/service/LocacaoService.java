package br.com.hibernateteste.service;

import br.com.hibernateteste.dao.LocacaoDao;
import br.com.hibernateteste.domain.Locacao;
import java.util.List;

/**
 *
 * @author T-Gamer
 */
public class LocacaoService {
    
    private LocacaoDao locacaoDao = new LocacaoDao();
    
    
    public List<Locacao> listar(){
        return locacaoDao.listar();
    }
    
    public Locacao consultar(Integer id){
        return locacaoDao.consultar(id);
    }
    
    public boolean inserir(List<Locacao> locacoes){
        return locacaoDao.inserir(locacoes);
    }
    
    public boolean alterar(List<Locacao> locacoes){
        return locacaoDao.alterar(locacoes);
    }
    
    public boolean deletar(List<Locacao> locacoes){
        return locacaoDao.deletar(locacoes);
    }
}