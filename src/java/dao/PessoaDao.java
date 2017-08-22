
package dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.criteria.CriteriaQuery;
import modelo.Pessoa;
import util.JpaUtil;


public class PessoaDao implements Serializable {
    EntityManager manager;
    
    /**
     * Altera os dados do objeto com o codigo igual ao parâmetro.
     * @param d
     * @return 
     */
    public boolean alterar(Disciplina d){
        manager = JpaUtil.getEntityManager();
        manager.getTransaction().begin();
        manager.merge(d);
        manager.getTransaction().commit();
        manager.close();
        return true;
    }
    
    public Disciplina buscarPorCodigo(int cod){
        manager = JpaUtil.getEntityManager();
        Disciplina disciplina = manager.find(Disciplina.class, cod);
        manager.close();
        return disciplina;
    }
    
    
    public boolean excluir(Disciplina disciplina){
        manager = JpaUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction(); 
        tx.begin();
        // recupera a referência ao objeto
        Disciplina temp = manager.find(Disciplina.class, disciplina.getCodigo());
        manager.remove(temp);
        tx.commit();
        manager.close();
        return true;
    }
    
    public boolean inserir(Disciplina disciplina){
        manager = JpaUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        manager.persist(disciplina);
        tx.commit();
        manager.close();
        return true;
    }
    
    public List<Disciplina> listarTodos(){
        manager = JpaUtil.getEntityManager();
        CriteriaQuery<Disciplina> query = manager.getCriteriaBuilder().createQuery(Disciplina.class);
        query.select(query.from(Disciplina.class));
        List<Disciplina> lista = manager.createQuery(query).getResultList();
        manager.close();
        return lista;
    }
        
    
}