package br.com.hibernateteste.dao;

import br.com.hibernateteste.domain.Cliente;
import br.com.hibernateteste.util.HibernateUtil;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.hibernate.Session;

/**
 *
 * @author T-Gamer
 */
public class ClienteDao {
    
    public List<Cliente> listar(){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();        
        try{
            long tempoInicial = System.currentTimeMillis();
            List<Cliente> clientes = session.createQuery("from Cliente order by id").list();
            session.getTransaction().commit();
            long tempoFinal = System.currentTimeMillis();
            System.out.printf("%.3f ms%n", (tempoFinal - tempoInicial) / 1000d);
            
            return clientes;
        }catch(Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
            return null;
        }
    }
    
    public Cliente consultar(Integer id){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        try{
            long tempoInicial = System.currentTimeMillis();
            Cliente cliente = (Cliente)session.createQuery("from Cliente where id = " + id).uniqueResult();
            session.getTransaction().commit();
            long tempoFinal = System.currentTimeMillis();
            System.out.printf("%.3f ms%n", (tempoFinal - tempoInicial) / 1000d);
            
            return cliente;
        }catch(Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
            return null;
        }
    }
    
    public boolean inserir(List<Cliente> clientes){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        try{ 
            long tempoInicial = System.currentTimeMillis();
            for(Cliente cliente : clientes) {
                session.save(cliente);
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
    
    public boolean alterar(List<Cliente> clientes){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        try{
            long tempoInicial = System.currentTimeMillis();
            for(Cliente cliente : clientes) {
                session.update(cliente);
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
    
    public boolean deletar(List<Cliente> clientes){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        try{ 
            long tempoInicial = System.currentTimeMillis();
            for(Cliente cliente : clientes) {
                session.delete(cliente);
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

