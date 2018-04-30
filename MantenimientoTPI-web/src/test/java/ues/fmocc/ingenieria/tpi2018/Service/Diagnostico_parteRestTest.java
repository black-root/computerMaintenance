/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.fmocc.ingenieria.tpi2018.Service;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.embeddable.EJBContainer;
import javax.ws.rs.core.Response;
import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;
import org.mockito.Mockito;
import static org.mockito.Mockito.times;
import org.powermock.api.mockito.PowerMockito;
import ues.fmoocc.ingenieria.tpi2018.Entities.Diagnosticoparte;

/**
 *
 * @author viktor
 */
public class Diagnostico_parteRestTest {

    final Diagnostico_parteRest mokDiagnostico_parteRest = Mockito.mock(Diagnostico_parteRest.class);
    final Diagnosticoparte mokDianosticoparte = Mockito.mock(Diagnosticoparte.class);

    public Diagnostico_parteRestTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws Exception {
        PowerMockito.whenNew(Diagnosticoparte.class).withAnyArguments().thenReturn(mokDianosticoparte);
        Diagnosticoparte d = new Diagnosticoparte(1, "descripcion");
        Diagnosticoparte d2 = new Diagnosticoparte(2, "descripcion");
        List<Diagnosticoparte> listadianosticoparte = new ArrayList<>();
        listadianosticoparte.add(d);
        listadianosticoparte.add(d2);
        Mockito.when(mokDiagnostico_parteRest.findAll()).thenReturn(listadianosticoparte);
        Mockito.when(mokDiagnostico_parteRest.findById(1)).thenReturn(d);
        Mockito.when(mokDiagnostico_parteRest.create(mokDianosticoparte)).thenReturn(Response.status(Response.Status.CREATED).entity(d).build());
        Mockito.when(mokDiagnostico_parteRest.edit(mokDianosticoparte)).thenReturn(Response.status(Response.Status.OK).entity(d2).build());
        Mockito.when(mokDiagnostico_parteRest.remove(1)).thenReturn(Response.status(Response.Status.OK).build());
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of findAll method, of class Diagnostico_parteRest.
     */
    @Test
    public void testFindAll() throws Exception {
        System.out.println("findAll");
        Diagnostico_parteRest rest = mokDiagnostico_parteRest;
        List<Diagnosticoparte> result = rest.findAll();
        Diagnosticoparte diagParte = new Diagnosticoparte(1, "descripcion");
        assertThat(result, CoreMatchers.hasItem(diagParte));
        assertNotNull(rest);
    }

    /**
     * Test of findById method, of class Diagnostico_parteRest.
     */
    @Test
    public void testFindById() throws Exception {
        System.out.println("findById");
        int id = 1;
        Diagnostico_parteRest instance = mokDiagnostico_parteRest;
        Diagnosticoparte expResult = new Diagnosticoparte(1, "descripcion");
        Diagnosticoparte result = instance.findById(id);
        //assertNotNull(result);
        assertEquals(expResult, result);
    }

    /**
     * Test of borrarDiagnosticoparte method, of class Diagnostico_parteRest.
     */
    @Test
    public void testBorrarDiagnosticoparte() throws Exception {
        System.out.println("borrarDiagnosticoparte");
        Integer id = 1;
        Diagnostico_parteRest instance = mokDiagnostico_parteRest;
        Response expResult = Response.status(200).build();
        Response result = instance.remove(id);
        assertEquals(expResult.getStatus(), result.getStatus());
        //(result);
        Mockito.verify(mokDiagnostico_parteRest, times(1)).remove(id);
    }

    /**
     * Test of guardarDiagnosticoparte method, of class Diagnostico_parteRest.
     */
    @Test
    public void testGuardarDiagnosticoparte() throws Exception {
        System.out.println("guardarDiagnosticoparte");
        int id = 1;
        Diagnostico_parteRest instance = mokDiagnostico_parteRest;
        Response expResult = Response.status(201).build();
        Response result = instance.create(mokDianosticoparte);
        assertEquals(expResult.getStatus(), result.getStatus());
        assertNotNull(result);
        Mockito.verify(mokDiagnostico_parteRest, times(1)).create(mokDianosticoparte);

    }

    /**
     * Test of editarDiagnosticoparte method, of class Diagnostico_parteRest.
     */
    @Test
    public void testEditarDiagnosticoparte() throws Exception {
        int id = 1;
        Diagnostico_parteRest instance = mokDiagnostico_parteRest;
        Response expResult = Response.status(200).build();
        Response result = instance.edit(mokDianosticoparte);
        assertEquals(expResult.getStatus(), result.getStatus());
        //assertNull(result);
        Mockito.verify(mokDiagnostico_parteRest, times(1)).edit(mokDianosticoparte);

    }

}
