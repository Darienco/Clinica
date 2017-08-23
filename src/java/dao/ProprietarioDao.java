package dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.criteria.CriteriaQuery;
import modelo.Proprietario;
import util.JpaUtil;

public class ProprietarioDao implements Serializable {
    EntityManager manager;
    
    public boolean alterar(Proprietario prop){
        manager = JpaUtil.getEntityManager();
        manager.getTransaction().begin();
        manager.merge(prop);
        manager.getTransaction().commit();
        manager.close();
        return true;
    }
    
    public Proprietario buscarPorCodigo(int cod){
        manager = JpaUtil.getEntityManager();
        Proprietario prop = manager.find(Proprietario.class, cod);
        manager.close();
        return prop;
    }
        
    public boolean excluir(Proprietario prop){
        manager = JpaUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction(); 
        tx.begin();
        // recupera a referência ao objeto
        Proprietario temp = manager.find(Proprietario.class, prop.getCodigo());
        manager.remove(temp);
        tx.commit();
        manager.close();
        return true;
    }
    
    public boolean inserir(Proprietario prop){
        manager = JpaUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        manager.persist(prop);
        tx.commit();
        manager.close();
        return true;
    }
    
    public List<Proprietario> listarTodos(){
        manager = JpaUtil.getEntityManager();
        CriteriaQuery<Proprietario> query = manager.getCriteriaBuilder().createQuery(Proprietario.class);
        query.select(query.from(Proprietario.class));
        List<Proprietario> lista = manager.createQuery(query).getResultList();
        manager.close();
        return lista;
    }
}