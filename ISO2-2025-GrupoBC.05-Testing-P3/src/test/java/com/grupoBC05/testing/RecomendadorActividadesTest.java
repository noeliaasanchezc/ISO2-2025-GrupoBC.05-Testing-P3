package com.grupoBC05.testing;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RecomendadorActividadesTest {

    RecomendadorActividades r = new RecomendadorActividades();

    @Test
    void testSinFacultades() {
        String res = r.recomendarActividad(false, false, 20, 50, "ninguna", false, false);
        assertEquals("Ninguna actividad", res);
    }

    @Test
    void testSintomasRecientes() {
        String res = r.recomendarActividad(true, true, 20, 50, "ninguna", false, false);
        assertEquals("Ninguna actividad", res);
    }

    @Test
    void testFrioNieveAgua() {
        String res = r.recomendarActividad(true, false, -2, 10, "nieve", false, false);
        assertEquals("Quedarse en casa", res);
    }

    @Test
    void testFrioSecoEsquiarDisponible() {
        String res = r.recomendarActividad(true, false, -1, 10, "ninguna", false, false);
        assertEquals("Esquiar", res);
    }

    @Test
    void testFrioSecoEsquiarNoAforo() {
        String res = r.recomendarActividad(true, false, -1, 10, "ninguna", true, false);
        assertEquals("Actividad no disponible por aforo", res);
    }

    @Test
    void testSenderismoDisponible() {
        String res = r.recomendarActividad(true, false, 10, 30, "ninguna", false, false);
        assertEquals("Senderismo o escalada", res);
    }

    @Test
    void testSenderismoNoAforo() {
        String res = r.recomendarActividad(true, false, 10, 30, "ninguna", true, false);
        assertEquals("Actividad no disponible por aforo", res);
    }

    @Test
    void testActividadesPrimaveraDisponible() {
        String res = r.recomendarActividad(true, false, 20, 40, "ninguna", false, false);
        assertEquals("Actividades de primavera/verano/otoño", res);
    }

    @Test
    void testActividadesPrimaveraNoAforo() {
        String res = r.recomendarActividad(true, false, 20, 40, "ninguna", true, false);
        assertEquals("Actividad no disponible por aforo", res);
    }

    @Test
    void testCulturalesGastronomicas() {
        String res = r.recomendarActividad(true, false, 30, 40, "ninguna", false, false);
        assertEquals("Culturales o gastronómicas", res);
    }

    @Test
    void testPlayaPiscinaDisponible() {
        // Solo ocurre con temperatura > 35
        String res = r.recomendarActividad(true, false, 36, 40, "ninguna", false, false);
        assertEquals("Playa o piscina", res);
    }

    @Test
    void testPlayaPiscinaNoDisponibleAforo() {
        String res = r.recomendarActividad(true, false, 36, 40, "ninguna", true, false);
        assertEquals("Actividad no disponible por aforo", res);
    }

    @Test
    void testSinRecomendacion() {
        String res = r.recomendarActividad(true, false, 10, 40, "lluvia", false, true);
        assertEquals("Sin recomendación", res);
    }
}