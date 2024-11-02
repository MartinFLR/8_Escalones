package model;

public class PregAproximacion extends Preguntas {
    private int id;
    private int id_tema;
    private final String pregunta;
    private Double respuestaCorrecta;

    public PregAproximacion(int id, Double respuestaCorrecta, int id_tema, String pregunta, String tipo_preg) {
        super(tipo_preg, id_tema, id_tema);
        this.id = id;
        this.id_tema = id_tema;
        this.respuestaCorrecta = respuestaCorrecta;
        this.pregunta = pregunta;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getPregunta() {
        return pregunta;
    }
    public Double getRespuestaCorrecta() {
        return respuestaCorrecta;
    }
    public void setRespuestaCorrecta(Double respuestaCorrecta) {
        this.respuestaCorrecta = respuestaCorrecta;
    }
}
