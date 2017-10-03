/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.Medico;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author juano
 */
public class MedicoDaoTest {
    
    public MedicoDaoTest() {
    }

    @Test
    public void testSomeMethod() {
        MedicoDao dao = new MedicoDao();
        List<Medico> lista = dao.buscarPorNomeParcial("Juan");
        for(Medico n: lista){
        System.out.println(n.getNome());}
    }
    
}
