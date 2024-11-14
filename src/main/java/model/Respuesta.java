package model;

public class Respuesta {
    private String respuesta;
    private boolean respuestaCorrecta;

    // Constructor, getters y setters
    public Respuesta(String respuesta, boolean respuestaCorrecta) {
        this.respuesta = respuesta;
        this.respuestaCorrecta = respuestaCorrecta;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public boolean isRespuestaCorrecta() {
        return respuestaCorrecta;
    }
}
