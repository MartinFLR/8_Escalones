package model.ABM;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.PreguntaOpcion;
import model.Tema;

public class FacadeBusqueda {


    public void busqueda(Object palabra, Object obj){
            Field[] fields = obj.getClass().getDeclaredFields();
            for (Field field: fields) {
                field.setAccessible(true);
                if(obj instanceof Tema){
                    new TemasDAO();
                    TemasDAO temadao = TemasDAO.getInstance();
                    List<Tema> preg = temadao.buscarObjeto(field.getName(), palabra);
                    System.out.println("Lista de Temas:");
                    for (Tema tema : preg) {
                      System.out.println(tema.getNombre()+", Id: "+ tema.getId());
                    }
                }//else con los otros      
             }

    }



    // public List<Tema> buscarObjeto(String nombreColumna, Object tipo) {
    //     List<Tema> temas = new ArrayList<>();
    //     String query = DAO.setQuery(nombreColumna, tipo);

    //     try (Connection conn = Database.getInstance().getConnection();
    //             PreparedStatement pstmt = conn.prepareStatement(query)) {
    //         if (tipo instanceof String) {
    //             pstmt.setString(1, "%" +  tipo + "%");
    //         } else if (tipo instanceof Integer) {
    //             pstmt.setInt(1, (Integer) tipo);
    //         } else {
    //             throw new IllegalArgumentException("Tipo de dato no soportado: " + tipo.getClass());
    //         }

    //         System.out.println("Consulta ejecutada: " + query);
    //         try (ResultSet resultSet = pstmt.executeQuery()) {

    //             while (resultSet.next()) {
    //                 Tema tema = new Tema(
    //                         resultSet.getInt("id_tema"),
    //                         resultSet.getString("nombre_tema"));
    //                 temas.add(tema);
    //             }
    //         }

    //     } catch (SQLException e) {
    //         System.err.println("Error al listar temas: " + e.getMessage());

    //     } catch (IllegalArgumentException e) {
    //         System.out.println(e.getMessage());
    //     }

    //     return temas;
    // }



}
