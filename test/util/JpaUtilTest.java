package util;

import dao.FuncionarioDao;
import modelo.Funcionario;
import org.junit.Test;

public class JpaUtilTest {
    
    public JpaUtilTest() {
    }

    @Test
    public void testeconexao(){
               
        Funcionario func = new Funcionario();
        func.setNome("Funcionario de Teste");
        func.setSenha("admin");
        func.setCPF(156489023);
        func.setCodigo(1);
        FuncionarioDao daoFunc = new FuncionarioDao();
        daoFunc.inserir(func);
    }
}
