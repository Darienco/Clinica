/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import modelo.Animal;
import modelo.Proprietario;
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
public class AnimalDaoTest {
    
    public AnimalDaoTest() {
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
    public void testInserir() {
        Proprietario p = new ProprietarioDao().buscarPorCodigo(2);
        System.out.println(p.getNome());
        Animal a = new Animal();
        a.setNome("dog");
        a.setEspecie("especie");
        a.setRaca("raça");
        a.setProp(p);
        new AnimalDao().inserir(a);
    }
    
}
