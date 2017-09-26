package dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
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
    public Animal buscarPorNome(String nome){
        Animal temp;
        manager = JpaUtil.getEntityManager();
        String consulta = "SELECT c FROM Animal c WHERE c.Nome = :nome";
        TypedQuery<Animal> query = manager.createQuery(consulta, Animal.class);
        query.setParameter("nome", nome);
        temp = query.getSingleResult();
        manager.close();
        return temp;
    }
    public boolean excluir(Animal anml){
        manager = JpaUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction(); 
        tx.begin();
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