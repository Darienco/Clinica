package dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.criteria.CriteriaQuery;
import modelo.Funcionario;
import util.JpaUtil;

public class FuncionarioDao implements Serializable {
    EntityManager manager;
    
    public boolean alterar(Funcionario func){
        manager = JpaUtil.getEntityManager();
        manager.getTransaction().begin();
        manager.merge(func);
        manager.getTransaction().commit();
        manager.close();
        return true;
    }
    
    public Funcionario buscarPorCodigo(int cod){
        manager = JpaUtil.getEntityManager();
        Funcionario func = manager.find(Funcionario.class, cod);
        manager.close();
        return func;
    }
        
    public boolean excluir(Funcionario func){
        manager = JpaUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction(); 
        tx.begin();
        // recupera a referência ao objeto
        Funcionario temp = manager.find(Funcionario.class, func.getCodigo());
        manager.remove(temp);
        tx.commit();
        manager.close();
        return true;
    }
    
    public boolean inserir(Funcionario func){
        manager = JpaUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        manager.persist(func);
        tx.commit();
        manager.close();
        return true;
    }
    
    public List<Funcionario> listarTodos(){
        manager = JpaUtil.getEntityManager();
        CriteriaQuery<Funcionario> query = manager.getCriteriaBuilder().createQuery(Funcionario.class);
        query.select(query.from(Funcionario.class));
        List<Funcionario> lista = manager.createQuery(query).getResultList();
        manager.close();
        return lista;
    }    
}
