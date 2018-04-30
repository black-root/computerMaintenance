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
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import static org.mockito.Mockito.times;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import ues.fmoocc.ingenieria.tpi2018.Entities.Diagnostico;

/**
 *
 * @author viktor
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(DiagnosticoRest.class)
public class DiagnosticoRestTest {
    final DiagnosticoRest mokDiagnosticoRest = Mockito.mock(DiagnosticoRest.class);
    final Diagnostico mokDiagnostico = Mockito.mock(Diagnostico.class);
    public DiagnosticoRestTest() {
    
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws Exception{
        PowerMockito.whenNew(Diagnostico.class).withAnyArguments().thenReturn(mokDiagnostico);
        Diagnostico d = new Diagnostico(1, 2);
        Diagnostico d1 = new Diagnostico(3, 4);
        Diagnostico d2 = new Diagnostico(3,5);
        List<Diagnostico> listadiagnostico = new ArrayList<>();
        listadiagnostico.add(d);
        listadiagnostico.add(d1);
        Mockito.when(mokDiagnosticoRest.findAll()).thenReturn(listadiagnostico);
        Mockito.when(mokDiagnosticoRest.findById(1)).thenReturn(d);
        Mockito.when(mokDiagnosticoRest.create(mokDiagnostico)).thenReturn(Response.status(Response.Status.CREATED).entity(d1).build());
        Mockito.when(mokDiagnosticoRest.edit(mokDiagnostico)).thenReturn(Response.status(Response.Status.OK).entity(d2).build());
        Mockito.when(mokDiagnosticoRest.remove(1)).thenReturn(Response.status(Response.Status.OK).build());
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of findAll method, of class DiagnosticoRest.
     * @throws java.lang.Exception
     */
    @Test
    public void testFindAll() throws Exception {
        System.out.println("findAll");
        DiagnosticoRest rest = mokDiagnosticoRest;
        List<Diagnostico> result = rest.findAll();
        Diagnostico diagnostico = new Diagnostico(1, 2);
        assertThat(result, CoreMatchers.hasItem(diagnostico));
        assertNotNull(result);
    }

    /**
     * Test of findById method, of class DiagnosticoRest.
     */
    @Test
    public void testFindById() {
        System.out.println("findById");
        int id = 1;
        DiagnosticoRest instance = mokDiagnosticoRest;
        Diagnostico expResult = new Diagnostico(1,2);
        Diagnostico result = instance.findById(id);
        //assertNotNull(result);
        assertEquals(expResult, result);
    }

    /**
     * Test of borrarDiagnostico method, of class DiagnosticoRest.
     * @throws java.lang.Exception
     */
    @Test
    public void testBorrarDiagnostico() throws Exception {
        
        DiagnosticoRest instance = mokDiagnosticoRest;
        Response expResult = Response.status(Response.Status.OK).build();
        Response result = instance.remove(1);
        assertEquals(expResult.getStatus(), result.getStatus());
        assertNotNull(result);
        Mockito.verify(mokDiagnosticoRest, times(1)).remove(1);
}

    /**
     * Test of guardarDiagnostico method, of class DiagnosticoRest.
     * @throws java.lang.Exception
     */
    @Test
    public void testGuardarDiagnostico() throws Exception {
        int id = 1;
        DiagnosticoRest instance = mokDiagnosticoRest;
        Response expResult = Response.status(201).build();
        Response result = instance.create(mokDiagnostico);
        assertEquals(expResult.getStatus(), result.getStatus());
        assertNotNull(result);
        Mockito.verify(mokDiagnosticoRest, times(1)).create(mokDiagnostico);
}
    

    /**
     * Test of editarDiagnostico method, of class DiagnosticoRest.
     */
    @Test
    public void testEditarDiagnostico() throws Exception {
        int id = 1;
        DiagnosticoRest instance = mokDiagnosticoRest;
        Response expResult = Response.status(200).build();
        Response result = instance.edit(mokDiagnostico);
        assertEquals(expResult.getStatus(), result.getStatus());
        assertNotNull(result);
        Mockito.verify(mokDiagnosticoRest, times(1)).edit(mokDiagnostico);

    
    }
    
}
