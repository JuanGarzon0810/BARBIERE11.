package programagit;

import conexion.Conexion;
import vista.Login;

public class Main {

    public static void main(String[] args) {

    Conexion.conectar();

    Login login = new Login();

    login.setLocationRelativeTo(null);

    login.setVisible(true);

}

}