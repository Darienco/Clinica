/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import dao.MedicoDao;
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
public class MedicoMBTest {
    
    public MedicoMBTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testSomeMethod() {
        String teste = "Juan";
////        MedicoMB medMB = new MedicoMB();
////        medMB.listarPorNome(teste);
        
        MedicoDao dao = new MedicoDao();
        
        System.out.println(dao.buscarPorNome(teste));
        
    }
    
}
