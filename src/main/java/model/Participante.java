package model;

import java.util.ArrayList;
import java.util.List;

public class Participante {
    private int id;
    private final String nombre;
<<<<<<< .merge_file_MOka8o
    private final List<PreguntaOpcion> preguntas = new ArrayList<>();
=======
    @SuppressWarnings("FieldMayBeFinal")

    private List<PreguntaOpcion> preguntas = new ArrayList<>();
>>>>>>> .merge_file_I6q5W3
    private String respuestaParticipante;
    private PreguntaAproximacion pregEmpate;
    private double respuestaParticipanteEmpate;
    private int cantErrores=0;
    private int cantAciertos = 0;
    private int numEscalon=1;
    
    //Constructores
    public Participante(int id, String nombre, int edad) {
        this.id = id;
        this.nombre = nombre;
    }
    // Constructor sin id para agregar participantes
    public Participante(String nombre) {
        this.nombre = nombre;
    }
    
    //Metodos
    public void sumaAcierto(){
        this.cantAciertos++;
    }
    public void sumaError(){
        this.cantErrores++;
    }
    public void subeEscalon(){
        this.numEscalon++;
    }
    
    //Getters y Setters
    public String getNombre() {
        return nombre;
    }
    public String getRespuestaParticipante() {
        return respuestaParticipante;
    }
    public void setRespuestaParticipante(String respuestaParticipante) {
        this.respuestaParticipante = respuestaParticipante;
    }
    public List<PreguntaOpcion> getPreguntasParticipante(){
        return this.preguntas;
    } 
    public void setPreguntasParticipante(PreguntaOpcion preg){

        this.preguntas.add(preg);
    }
    public int getCantErrores(){
        return this.cantErrores;
    }
    public int getCantAciertos(){
        return this.cantAciertos;
    }
    public double getRespuestaParticipanteEmpate() {
        return respuestaParticipanteEmpate;
    }
    public void setRespuestaParticipanteEmpate(double respuestaParticipanteEmpate) {
        this.respuestaParticipanteEmpate = respuestaParticipanteEmpate;
    }
    public PreguntaAproximacion getPregEmpate() {
        return this.pregEmpate;
    }
    public void setPregEmpate(PreguntaAproximacion pregEmpate) {

        this.pregEmpate = pregEmpate;
    }
    public int getNumEscalon() {
        return numEscalon;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setCantErrores(int i) {
        this.cantErrores = i;
    }
}

