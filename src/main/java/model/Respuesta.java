package model;

public class Respuesta {
    private int id_respuesta;
    private String respuesta;
    private boolean respuestaCorrecta;

    // Constructor, getters y setters
    public Respuesta(String respuesta, boolean respuestaCorrecta) {
        this.respuesta = respuesta;
        this.respuestaCorrecta = respuestaCorrecta;
    }

    public Respuesta(int id_respuesta, String respuesta, boolean respuestaCorrecta) {
        this.id_respuesta = id_respuesta;
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
