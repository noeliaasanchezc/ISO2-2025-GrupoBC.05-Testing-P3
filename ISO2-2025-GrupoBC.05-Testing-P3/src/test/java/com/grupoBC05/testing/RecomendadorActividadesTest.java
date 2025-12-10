package com.grupoBC05.testing;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RecomendadorActividadesTest {

    RecomendadorActividades r = new RecomendadorActividades();

    @Test
    void testNoPlenasFacultades() {
        String res = r.recomendarActividad(false, false, 20, 40, "ninguna", false, false);
        assertEquals("Ninguna actividad", res);
    }

    @Test
    void testConSintomas() {
        String res = r.recomendarActividad(true, true, 20, 40, "ninguna", false, false);
        assertEquals("Ninguna actividad", res);
    }

    @Test
    void testNevadaQuedarseEnCasa() {
        String res = r.recomendarActividad(true, false, -1, 10, "nieve", false, false);
        assertEquals("Quedarse en casa", res);
    }

    @Test
    void testLluviaQuedarseEnCasa() {
        String res = r.recomendarActividad(true, false, -1, 10, "agua", false, false);
        assertEquals("Quedarse en casa", res);
    }

    @Test
    void testEsquiarDisponible() {
        String res = r.recomendarActividad(true, false, -1, 10, "ninguna", false, false);
        assertEquals("Esquiar", res);
    }

    @Test
    void testEsquiarNoDisponibleAforo() {
        String res = r.recomendarActividad(true, false, -1, 10, "ninguna", true, false);
        assertEquals("Actividad no disponible por aforo", res);
    }

    @Test
    void testSenderismoDisponible() {
        String res = r.recomendarActividad(true, false, 10, 40, "ninguna", false, false);
        assertEquals("Senderismo o escalada", res);
    }

    @Test
    void testSenderismoNoDisponibleAforo() {
        String res = r.recomendarActividad(true, false, 10, 40, "ninguna", true, false);
        assertEquals("Actividad no disponible por aforo", res);
    }

    @Test
    void testActividadesVerano() {
        String res = r.recomendarActividad(true, false, 20, 50, "ninguna", false, false);
        assertEquals("Actividades de primavera/verano/otoño", res);
    }

    @Test
    void testActividadesVeranoNoAforo() {
        String res = r.recomendarActividad(true, false, 20, 50, "ninguna", true, false);
        assertEquals("Actividad no disponible por aforo", res);
    }

    @Test
    void testCulturalesGastronomicas() {
        String res = r.recomendarActividad(true, false, 30, 40, "ninguna", false, false);
        assertEquals("Culturales o gastronómicas", res);
    }

    @Test
    void testPlayaPiscinaDisponible() {
        String res = r.recomendarActividad(true, false, 32, 40, "ninguna", false, false);
        assertEquals("Playa o piscina", res);
    }

    @Test
    void testPlayaPiscinaNoDisponibleAforo() {
        String res = r.recomendarActividad(true, false, 32, 40, "ninguna", true, false);
        assertEquals("Actividad no disponible por aforo", res);
    }

    @Test
    void testSinRecomendacionGeneral() {
        String res = r.recomendarActividad(true, false, 15, 90, "lluvia", false, true);
        assertEquals("Sin recomendación", res);
    }
}