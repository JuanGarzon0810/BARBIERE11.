package dao;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsuarioDAO {

    public boolean iniciarSesion(String usuario, String password) {

        String sql = "SELECT * FROM usuarios WHERE usuario = ? AND password = ?";

        try {

            Connection conexion = Conexion.conectar();

            PreparedStatement sentencia = conexion.prepareStatement(sql);

            sentencia.setString(1, usuario);
            sentencia.setString(2, password);
            
            System.out.println("Usuario recibido: " + usuario);
            System.out.println("Password recibida: " + password);

            ResultSet resultado = sentencia.executeQuery();

            return resultado.next();

        } catch (Exception e) {

            System.out.println("Error: " + e.getMessage());

        }

        return false;

    }

}