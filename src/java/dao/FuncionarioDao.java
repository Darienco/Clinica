package dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import modelo.Funcionario;
import util.JpaUtil;

public class FuncionarioDao implements Serializable {
    EntityManager manager;
    
    public Funcionario autenticar(Funcionario func) {
        Funcionario temp = null; // administrador retornado na consulta ao banco
        manager = JpaUtil.getEntityManager();
        TypedQuery<Funcionario> query = manager.createQuery("SELECT f FROM Funcionario f WHERE f.CPF = :CPF AND f.Senha = :Senha",
                Funcionario.class); 
        query.setParameter("CPF", func.getCPF());
        query.setParameter("Senha", func.getSenha());
        try {
            temp = query.getSingleResult(); 
        }
        catch(Exception e){ }    
        finally {
            manager.close();
        }        
        return temp;
    }
    
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
