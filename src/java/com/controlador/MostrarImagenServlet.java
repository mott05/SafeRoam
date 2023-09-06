
package com.controlador;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MostrarImagenServlet")
public class MostrarImagenServlet extends HttpServlet {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/bd_safaroam";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "";

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Obtener el ID del vehículo de la solicitud GET
        String idVehiculoStr = request.getParameter("id");

        if (idVehiculoStr != null) {
            try {
                int idVehiculo = Integer.parseInt(idVehiculoStr);

                // Conectar a la base de datos y recuperar la imagen del vehículo
                Blob foto = obtenerFotoVehiculoDesdeLaBaseDeDatos(idVehiculo);

                if (foto != null) {
                    // Configurar la respuesta HTTP para la imagen
                    response.setContentType("image/png"); // Cambia el tipo de contenido según el formato de imagen
                    response.setContentLength((int) foto.length());

                    // Escribir la imagen en la respuesta HTTP
                    InputStream inputStream = foto.getBinaryStream();
                    OutputStream outputStream = response.getOutputStream();

                    byte[] buffer = new byte[4096];
                    int bytesRead = -1;

                    while ((bytesRead = inputStream.read(buffer)) != -1) {
                        outputStream.write(buffer, 0, bytesRead);
                    }

                    inputStream.close();
                    outputStream.close();
                } else {
                    // Si no se encuentra la imagen, puedes enviar una imagen predeterminada o un mensaje de error
                    response.setContentType("text/plain");
                    response.getWriter().println("Imagen no encontrada");
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
                // Manejo de error si el ID del vehículo no es un número válido
            } catch (SQLException ex) {
                Logger.getLogger(MostrarImagenServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            // Manejo de error si no se proporciona un ID de vehículo en la solicitud GET
        }
    }

    private Blob obtenerFotoVehiculoDesdeLaBaseDeDatos(int idVehiculo) {
        Blob foto = null;
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);

            String sql = "SELECT foto FROM vehiculos WHERE idVehiculo = ?";
            statement = conn.prepareStatement(sql);
            statement.setInt(1, idVehiculo);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                foto = resultSet.getBlob("foto");
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

        return foto;
    }
}
