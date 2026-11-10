
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.*;


public class Clientes {
    
    static String todos = "SELECT * FROM clientes ORDER BY nombrec DESC";
    static String ids = "SELECT codigoc FROM clientes ORDER BY codigoc";

    int codigoc;
    String nombrec, rfc;

    public Clientes() {

    }

    public Clientes(int codigoc, String nombrec, String rfc) {
        this.codigoc = codigoc;
        this.nombrec = nombrec;
        this.rfc = rfc;
    }

    public int insertar(Connection con) {
        int resultado = 0;

        try {
            String sql = "INSERT INTO clientes (nombrec, rfc) VALUES (?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, nombrec);
            ps.setString(2, rfc);

            return ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return resultado;
        }
    }

    public int borrar(Connection con) {
        int resultado = 0;

        try {
            String sql = "DELETE FROM clientes WHERE codigoc = ?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, codigoc);

            return ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return resultado;
        }
    }

    public int actualizar(Connection con) {
        int resultado = 0;

        try {
            String sql = "UPDATE clientes SET nombrec = ?, rfc = ? WHERE codigoc = ?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, nombrec);
            ps.setString(2, rfc);
            ps.setInt(3, codigoc);

            return ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return resultado;
        }
    }
}
