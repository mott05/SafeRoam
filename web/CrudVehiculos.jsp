<%-- 
    Document   : CrudVehiculos
    Created on : 30/08/2023, 3:28:04 p. m.
    Author     : P90
--%>

<%@page import="java.io.InputStream"%>
<%@page import="com.modelo.Vehiculo"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>

<%@page import="java.util.logging.Logger"%>
<%@page import="java.util.logging.Level"%>
<%@page import="java.sql.SQLException"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Subir Imagen de Vehículo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://getbootstrap.com/docs/5.3/assets/css/docs.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
    <h1>Subir Imagen de Vehículo</h1>

    <!-- Formulario para subir una imagen de vehículo -->
    
    <form action="VehiculoServlet" method="post" enctype="multipart/form-data">
        <nav class="navbar navbar-expand-lg" style="background-color: #008080;" data-bs-theme="dark">
            <div class="container mt-2">
            <div class="fila">
            <div class="card-header">
        <input type="hidden" name="action" value="subirImagen">
        <label for="modelo">Modelo:</label>
        <input type="text" name="modelo" required>
        <label for="marca">Marca:</label>
        <input type="text" name="marca" required>
        <label for="año">Año:</label>
        <input type="number" name="ano" required><br>
        <label for="estado">Estado:</label>
        <select name="estado" required>
            <option value="DISPONIBLE">Disponible</option>
            <option value="ALQUILADO">Alquilado</option>
            <option value="MANTENIMIENTO">Mantenimiento</option>
        </select><br>
        <label for="placa">Placa:</label>
        <input type="text" name="placa" required><br>
        <label for="foto">Seleccione una imagen:</label>
        <input type="file" name="foto" accept="image/*" required><br>
        <input type="submit" value="Subir Imagen">
    </form>
    </div> 
    </div> 
</nav>
      
</body>
</html>

