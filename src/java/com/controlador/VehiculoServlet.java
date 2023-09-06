import com.modelo.Vehiculo;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/VehiculoServlet")
@MultipartConfig(maxFileSize = 16177215) // Tamaño máximo de archivo (en bytes) = 16 MB
public class VehiculoServlet extends HttpServlet {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/saferoam_db";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "";

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("subirImagen".equals(action)) {
            subirImagen(request, response);
        } else if ("mostrarImagenes".equals(action)) {
            mostrarImagenes(request, response);
        }
    }

    private void subirImagen(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Part filePart = request.getPart("foto");
        String modelo = request.getParameter("modelo");
        String marca = request.getParameter("marca");
        int año = Integer.parseInt(request.getParameter("ano"));
        String estadoStr = request.getParameter("estado");
        Vehiculo.EstadoVehiculo estado = Vehiculo.EstadoVehiculo.valueOf(estadoStr);
        String placa = request.getParameter("placa");

        if (filePart != null) {
            try {
                InputStream inputStream = filePart.getInputStream();

                Connection conn = null;
                PreparedStatement statement = null;

                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);

                    String sql = "INSERT INTO vehiculos (modelo, marca, año, estado, placa, foto_vehiculo) VALUES (?, ?, ?, ?, ?, ?)";
                    statement = conn.prepareStatement(sql);
                    statement.setString(1, modelo);
                    statement.setString(2, marca);
                    statement.setInt(3, año);
                    statement.setString(4, estadoStr);
                    statement.setString(5, placa);
                    statement.setBlob(6, inputStream);
                    statement.executeUpdate();
                } catch (ClassNotFoundException | SQLException e) {
                    e.printStackTrace();
                } finally {
                    if (statement != null) {
                        statement.close();
                    }
                    if (conn != null) {
                        conn.close();
                    }
                }
            } catch (IOException | SQLException e) {
                e.printStackTrace();
            }
        }

        response.sendRedirect("CrudVehiculos.jsp"); // Redirige a la página principal o a donde desees
    }

    private void mostrarImagenes(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Vehiculo> vehiculos = new ArrayList<>();

        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);

            String sql = "SELECT id, modelo, marca, año, estado, placa, foto_vehiculo FROM vehiculos";
            statement = conn.prepareStatement(sql);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int idVehiculo = resultSet.getInt("idVehiculo");
                String modelo = resultSet.getString("modelo");
                String marca = resultSet.getString("marca");
                int año = resultSet.getInt("año");
                String estadoStr = resultSet.getString("estado");
                Vehiculo.EstadoVehiculo estado = Vehiculo.EstadoVehiculo.valueOf(estadoStr);
                String placa = resultSet.getString("placa");
                Blob foto = resultSet.getBlob("foto");

                Vehiculo vehiculo = new Vehiculo(idVehiculo, modelo, marca, año, estado, placa, foto);
                vehiculos.add(vehiculo);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        request.setAttribute("vehiculos", vehiculos);
        request.getRequestDispatcher("mostrarImagenes.jsp").forward(request, response); // Redirige a la página para mostrar imágenes
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    
}

}
