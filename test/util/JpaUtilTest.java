package util;

import dao.MedicoDao;
import dao.ProprietarioDao;
import modelo.Medico;
import modelo.Proprietario;
import org.junit.Test;

public class JpaUtilTest {
    
    public JpaUtilTest() {
    }

    @Test
    public void testeconexao(){
        Medico med = new Medico();
        med.setNome("SOJINHA KAWAII");
        med.setCRMV(7662);
        med.setCodigo(1);
        MedicoDao daoMed = new MedicoDao();
        daoMed.inserir(med);
        
        Proprietario prop = new Proprietario();
        prop.setNome("SOJINHA PROPRIETARIO");
        prop.setCPF(798392662);
        prop.setCodigo(1);
        ProprietarioDao daoProp = new ProprietarioDao();
        daoProp.inserir(prop);
    }
}
