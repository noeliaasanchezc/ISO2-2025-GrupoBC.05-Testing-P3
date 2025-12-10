public class RecomendadorActividades {

    public String recomendarActividad(
            boolean plenasFacultades,
            boolean sintomasRecientes,
            double temperatura,
            double humedad,
            String precipitacion,
            boolean superaAforo,
            boolean nublado
    ) {

        if (!plenasFacultades || sintomasRecientes) {
            return "Ninguna actividad";
        }

        if (temperatura < 0 && humedad < 15 &&
                (precipitacion.equals("nieve") || precipitacion.equals("agua"))) {
            return "Quedarse en casa";
        }

        if (temperatura < 0 && humedad < 15 && precipitacion.equals("ninguna")) {
            if (!superaAforo) return "Esquiar";
            else return "Actividad no disponible por aforo";
        }

        if (temperatura >= 0 && temperatura < 15 &&
                precipitacion.equals("ninguna")) {
            if (!superaAforo) return "Senderismo o escalada";
            else return "Actividad no disponible por aforo";
        }

        if (temperatura >= 15 && temperatura < 25 &&
                precipitacion.equals("ninguna") &&
                !nublado &&
                humedad <= 60) {
            if (!superaAforo) return "Actividades de primavera/verano/otoño";
            else return "Actividad no disponible por aforo";
        }

        if (temperatura >= 25 && temperatura <= 35 &&
                precipitacion.equals("ninguna")) {
            return "Culturales o gastronómicas";
        }

        if (temperatura > 30 && precipitacion.equals("ninguna")) {
            if (!superaAforo) return "Playa o piscina";
            else return "Actividad no disponible por aforo";
        }

        return "Sin recomendación";
    }


    public static void main(String[] args) {

        RecomendadorActividades r = new RecomendadorActividades();

        String resultado = r.recomendarActividad(
                true,      // plenasFacultades
                false,     // sintomasRecientes
                10,        // temperatura
                40,        // humedad
                "ninguna", // precipitacion
                false,     // superaAforo
                false      // nublado
        );

        System.out.println("Resultado: " + resultado);
    }
}
