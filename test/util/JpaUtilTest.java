package util;

import dao.MedicoDao;
import modelo.Medico;
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
        MedicoDao dao = new MedicoDao();
        dao.inserir(med);
    }
}
