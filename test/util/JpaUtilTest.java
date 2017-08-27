package util;

import dao.FuncionarioDao;
import dao.MedicoDao;
import dao.ProprietarioDao;
import modelo.Funcionario;
import modelo.Medico;
import modelo.Proprietario;
import org.junit.Test;

public class JpaUtilTest {
    
    public JpaUtilTest() {
    }

    @Test
    public void testeconexao(){
        Medico med = new Medico();
        med.setNome("Medico de Teste");
        med.setCRMV(12345698);
        med.setCodigo(1);
        MedicoDao daoMed = new MedicoDao();
        daoMed.inserir(med);
        /*
        Proprietario prop = new Proprietario();
        prop.setNome("Proprietario de Teste");
        prop.setEndereco("Av. Pirocuda, Nº 82 - Centro");
        prop.setCPF(798392662);
        prop.setTelefone("(14) 99852-3695");
        prop.setCodigo(1);
        ProprietarioDao daoProp = new ProprietarioDao();
        daoProp.inserir(prop);
        
        Funcionario func = new Funcionario();
        func.setNome("Funcionario de Teste");
        func.setSenha("admin");
        func.setCPF(156489023);
        func.setCodigo(1);
        FuncionarioDao daoFunc = new FuncionarioDao();
        daoFunc.inserir(func); */
    }
}
