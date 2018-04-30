/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.fmocc.ingenieria.tpi2018.Service;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Response;
import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mockito;
import static org.mockito.Mockito.times;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import ues.fmoocc.ingenieria.tpi2018.Entities.Prioridad;

/**
 *
 * @author sergio
 */

@RunWith(PowerMockRunner.class)
@PrepareForTest(PrioridadRest.class)
public class PrioridadRestTest {
    final PrioridadRest mokPrioridadRest = Mockito.mock(PrioridadRest.class);
    final Prioridad mokPrioridad = Mockito.mock(Prioridad.class);
    public PrioridadRestTest() {
        
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws Exception {
        PowerMockito.whenNew(Prioridad.class).withAnyArguments().thenReturn(mokPrioridad);
        Mockito.when(mokPrioridadRest.count()).thenReturn(1);
        Prioridad p = new Prioridad(1);    
        Prioridad p1 = new Prioridad(2);
        List<Prioridad> listaprioridad = new ArrayList<>();   
        listaprioridad.add(p);
        listaprioridad.add(p1);
        Mockito.when(mokPrioridadRest.findall()).thenReturn(listaprioridad);
        Mockito.when(mokPrioridadRest.findById(1)).thenReturn(p); 
        Mockito.when(mokPrioridadRest.create(mokPrioridad)).thenReturn(Response.status(Response.Status.CREATED).build());
        Mockito.when(mokPrioridadRest.edit(mokPrioridad)).thenReturn(Response.status(Response.Status.OK).build());
        Mockito.when(mokPrioridadRest.remove(1)).thenReturn(Response.status(Response.Status.OK).build());
     
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of findall method, of class PrioridadRest.
     */
    @Test
    public void testFindall() {

        System.out.println("findall");      
        PrioridadRest rest = mokPrioridadRest;
        List<Prioridad> result = rest.findall();
        Prioridad prioridad = new Prioridad(1);
        assertThat(result, CoreMatchers.hasItems(prioridad));
    }

    /**
     * Test of count method, of class PrioridadRest.
     * @throws java.lang.Exception
     */
    @Test
    public void testCount() throws Exception {
        System.out.println("count");
        PrioridadRest instance = mokPrioridadRest;
        int expResult = 1;
        int result = instance.count();
        assertEquals(expResult, result);
    }

    /**
     * Test of findById method, of class PrioridadRest.
     */
    @Test
    public void testFindById() {
        System.out.println("findById");
        Integer id = 1;
        PrioridadRest instance = mokPrioridadRest;
        Prioridad expResult = new Prioridad(1);
        Prioridad result = instance.findById(id);
        assertEquals(expResult, result);
        
    }

  
     @Test
    public void testBorrar() throws Exception {
        System.out.println("borrar");
        Integer id = 1;
        PrioridadRest instance = mokPrioridadRest;
        Response expResult = Response.status(200).build();
        Response result = instance.remove(id);
        assertEquals(expResult.getStatus(), result.getStatus());
        //(result);
        Mockito.verify(mokPrioridadRest, times(1)).remove(id);
    }

    /**
     * Test of guardarDiagnosticoparte method, of class Diagnostico_parteRest.
     */
    @Test
    public void testGuardar() throws Exception {
        System.out.println("guardarDiagnosticoparte");
        int id = 1;
        PrioridadRest instance = mokPrioridadRest;
        Response expResult = Response.status(201).build();
        Response result = instance.create(mokPrioridad);
        assertEquals(expResult.getStatus(), result.getStatus());
        assertNotNull(result);
        Mockito.verify(mokPrioridadRest, times(1)).create(mokPrioridad);

    }

    /**
     * Test of editarDiagnosticoparte method, of class Diagnostico_parteRest.
     */
    @Test
    public void testEditar() throws Exception {
        int id = 1;
        PrioridadRest instance = mokPrioridadRest;
        Response expResult = Response.status(200).build();
        Response result = instance.edit(mokPrioridad);
        assertEquals(expResult.getStatus(), result.getStatus());
        //assertNull(result);
        Mockito.verify(mokPrioridadRest, times(1)).edit(mokPrioridad);

    }
    
}
    

