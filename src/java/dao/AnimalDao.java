package dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.criteria.CriteriaQuery;
import modelo.Animal;
import util.JpaUtil;

public class AnimalDao implements Serializable {
    EntityManager manager;
    
    public boolean alterar(Animal anml){
        manager = JpaUtil.getEntityManager();
        manager.getTransaction().begin();
        manager.merge(anml);
        manager.getTransaction().commit();
        manager.close();
        return true;
    }
    
    public Animal buscarPorCodigo(int cod){
        manager = JpaUtil.getEntityManager();
        Animal func = manager.find(Animal.class, cod);
        manager.close();
        return func;
    }
        
    public boolean excluir(Animal anml){
        manager = JpaUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction(); 
        tx.begin();
        // recupera a referência ao objeto
        Animal temp = manager.find(Animal.class, anml.getCodigo());
        manager.remove(temp);
        tx.commit();
        manager.close();
        return true;
    }
    
    public boolean inserir(Animal anml){
        manager = JpaUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        manager.persist(anml);
        tx.commit();
        manager.close();
        return true;
    }
    
    public List<Animal> listarTodos(){
        manager = JpaUtil.getEntityManager();
        CriteriaQuery<Animal> query = manager.getCriteriaBuilder().createQuery(Animal.class);
        query.select(query.from(Animal.class));
        List<Animal> lista = manager.createQuery(query).getResultList();
        manager.close();
        return lista;
    }    
}