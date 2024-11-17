package model.ABM;


public class ManagerSession {
    private static boolean logueado = false;

    public static boolean estaLogueado() {
        return logueado;
    }

    public static void setLogueado(boolean estado) {
        logueado = estado;
    }
}

