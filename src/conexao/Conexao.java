package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Romario Cordeiro
 */
public class Conexao {

    public Connection connection = null;
    private final String DRIVER = "com.mysql.jdbc.Driver";
    private final String BDNAME = "teste";
    private final String URL = "jdbc:mysql://192.168.0.20/logins";
    private final String LOGIN = "F5Promotora";
    private final String SENHA = "F5+Promo#";

    public boolean getConnection() {
        try {
            Class.forName(DRIVER);
            this.connection = DriverManager.getConnection(URL + BDNAME, LOGIN, SENHA);
            return true;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "OCORREU O SEGUINTE ERRO:\n" + e, "ERRO", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

    public void close() {
        try {
            this.connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "OCORREU O SEGUINTE ERRO:\n" + e, "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }
}
