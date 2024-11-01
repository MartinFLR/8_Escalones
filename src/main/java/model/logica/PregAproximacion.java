package model.logica;

public class PregAproximacion {
    private int id;
    private Double respuestaCorrecta;
    private int id_tema;

    
    public PregAproximacion(int id, Double respuestaCorrecta, int id_tema) {
        this.id = id;
        this.respuestaCorrecta = respuestaCorrecta;
        this.id_tema = id_tema;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Double getRespuestaCorrecta() {
        return respuestaCorrecta;
    }
    public void setRespuestaCorrecta(Double respuestaCorrecta) {
        this.respuestaCorrecta = respuestaCorrecta;
    }
    public int getId_tema() {
        return id_tema;
    }
    public void setId_tema(int id_tema) {
        this.id_tema = id_tema;
    }
}
