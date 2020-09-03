package br.com.hibernateteste.dao;

import br.com.hibernateteste.domain.Locacao;
import br.com.hibernateteste.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author T-Gamer
 */
public class LocacaoDao {
    
    public List<Locacao> listar(){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        
        try{
            long tempoInicial = System.currentTimeMillis();
            List<Locacao> locacoes = session.createQuery("from Locacao order by id").list();
            session.getTransaction().commit();
            long tempoFinal = System.currentTimeMillis();
            System.out.printf("%.3f ms%n", (tempoFinal - tempoInicial) / 1000d);
            
            return locacoes;
        }catch(Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
            return null;
        }
    }
    
    public Locacao consultar(Integer id){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        try{
            long tempoInicial = System.currentTimeMillis();
            Locacao locacao = (Locacao)session.createQuery("from Locacao where id = " + id).uniqueResult();
            session.getTransaction().commit();
            long tempoFinal = System.currentTimeMillis();
            System.out.printf("%.3f ms%n", (tempoFinal - tempoInicial) / 1000d);
            
            return locacao;
        }catch(Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
            return null;
        }
    }
    
    public boolean inserir(List<Locacao> locacoes){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        try{
            long tempoInicial = System.currentTimeMillis();
            for(Locacao locacao : locacoes) {
                session.save(locacao);
            }
            session.getTransaction().commit();
            long tempoFinal = System.currentTimeMillis();
            System.out.printf("%.3f ms%n", (tempoFinal - tempoInicial) / 1000d);
            
            return true;
        }catch(Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
            return false;
        }
    }
    
    public boolean alterar(List<Locacao> locacoes){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        try{
            long tempoInicial = System.currentTimeMillis();
            for(Locacao locacao : locacoes) {
                session.update(locacao);
            }               
            session.getTransaction().commit();
            long tempoFinal = System.currentTimeMillis();
            System.out.printf("%.3f ms%n", (tempoFinal - tempoInicial) / 1000d);
            
            return true;
        }catch(Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
            return false;
        }
    }
    
    public boolean deletar(List<Locacao> locacoes){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        try{
            long tempoInicial = System.currentTimeMillis();
            for(Locacao locacao : locacoes) {
                session.delete(locacao);
            }
            session.getTransaction().commit();
            long tempoFinal = System.currentTimeMillis();
            System.out.printf("%.3f ms%n", (tempoFinal - tempoInicial) / 1000d);
            
            return true;
        }catch(Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
            return false;
        }
    }
    
}

