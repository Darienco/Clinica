package dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.criteria.CriteriaQuery;
import modelo.Medico;
import util.JpaUtil;

public class MedicoDao implements Serializable {
    EntityManager manager;
    
    public boolean alterar(Medico med){
        manager = JpaUtil.getEntityManager();
        manager.getTransaction().begin();
        manager.merge(med);
        manager.getTransaction().commit();
        manager.close();
        return true;
    }
    
    public Medico buscarPorCodigo(int cod){
        manager = JpaUtil.getEntityManager();
        Medico med = manager.find(Medico.class, cod);
        manager.close();
        return med;
    }
        
    public boolean excluir(Medico med){
        manager = JpaUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction(); 
        tx.begin();
        // recupera a referência ao objeto
        Medico temp = manager.find(Medico.class, med.getCodigo());
        manager.remove(temp);
        tx.commit();
        manager.close();
        return true;
    }
    
    public boolean inserir(Medico med){
        manager = JpaUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        manager.persist(med);
        tx.commit();
        manager.close();
        return true;
    }
    
    public List<Medico> listarTodos(){
        manager = JpaUtil.getEntityManager();
        CriteriaQuery<Medico> query = manager.getCriteriaBuilder().createQuery(Medico.class);
        query.select(query.from(Medico.class));
        List<Medico> lista = manager.createQuery(query).getResultList();
        manager.close();
        return lista;
    }
 
}