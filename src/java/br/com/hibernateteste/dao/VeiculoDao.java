package br.com.hibernateteste.dao;

import br.com.hibernateteste.domain.Veiculo;
import br.com.hibernateteste.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author T-Gamer
 */
public class VeiculoDao {
    
    public List<Veiculo> listar(){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        
        try{
            List<Veiculo> veiculos = session.createQuery("from Veiculo order by id").list();
            session.getTransaction().commit();
            return veiculos;
        }catch(Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
            return null;
        }
    }
    
    public Veiculo consultar(Integer id){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        try{
            Veiculo veiculo = (Veiculo)session.createQuery("from Veiculo where id = " + id).uniqueResult();
            session.getTransaction().commit();
            return veiculo;
        }catch(Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
            return null;
        }
    }
    
    public boolean inserir(List<Veiculo> veiculos){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        try{
            for(Veiculo veiculo : veiculos) {
                session.save(veiculo);
            }
            session.getTransaction().commit();
            return true;
        }catch(Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
            return false;
        }
    }
    
    public boolean alterar(List<Veiculo> veiculos){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        try{
            for(Veiculo veiculo : veiculos) {
                session.update(veiculo);
            }               
            session.getTransaction().commit();
            return true;
        }catch(Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
            return false;
        }
    }
    
    public boolean deletar(List<Veiculo> veiculos){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        try{
            for(Veiculo veiculo : veiculos) {
                session.delete(veiculo);
            }
            session.getTransaction().commit();
            return true;
        }catch(Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
            return false;
        }
    }
    
}
