package model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

public class Participante {
    private int id_participante;
    private String nombre_participante;//fijarse que no pueda tener el mismo nombre que otro participante
    private final List<PreguntaOpcion> preguntas = new ArrayList<>();
    private String respuestaParticipante;
    private PreguntaAproximacion pregEmpate;
    private double respuestaParticipanteEmpate;
    private int cantErrores=0;
    private int cantAciertos = 0;
    private int numEscalon=1;
    private int vecesGanadas;
<<<<<<< HEAD
    
    //Constructores
    public Participante(int id, String nombre) {
        this.id_participante = id;
        this.nombre_participante = nombre;
    }
    // Constructor sin id para agregar participantes
    public Participante(String nombre) {
        this.nombre_participante = nombre;
    }

    public Participante(String nombre, int vecesGanadas) {
        this.nombre_participante = nombre;
        this.vecesGanadas = vecesGanadas;
    }
=======
    private ImageIcon img;

//holaaa soy martin, usen el setImg para setear la imagen, asi no tenemos como 10 constructores :P

    // Constructor sin id para crear el objeto desde local
    public Participante(String nombre) {
        this.nombre = nombre;
        this.img = img;
    }

    // Constructor con id para cuando generamos los objetos desde bd
>>>>>>> 4139275b255ea57a5f455b048fca28030fbb90f2
    public Participante(int id, String nombre, int veces_ganadas) {
        this.id_participante = id;
        this.nombre_participante = nombre;
        this.vecesGanadas=veces_ganadas;
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
        return nombre_participante;
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
        return id_participante;
    }
    public void setId(int id) {
        this.id_participante = id;
    }
    public void setCantErrores(int i) {
        this.cantErrores = i;
    }

    public void setCantAciertos(int cantAciertos) {
        this.cantAciertos = cantAciertos;
    }

    public int getVecesGanadas(){
        return this.vecesGanadas;
    }

    public void SetVecesGanadas(int vecesGanadas){
        this.vecesGanadas=vecesGanadas;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public List<PreguntaOpcion> getPreguntas() {
        return preguntas;
    }
    public void setNumEscalon(int numEscalon) {
        this.numEscalon = numEscalon;
    }
    public void setVecesGanadas(int vecesGanadas) {
        this.vecesGanadas = vecesGanadas;
    }
    public ImageIcon getImg() {
        return img;
    }
    public void setImg(ImageIcon img) {
        this.img = img;
    }
    
}

