<%-- 
    Document   : mostrarImagenes
    Created on : 2/09/2023, 8:40:41 p. m.
    Author     : P90
--%>

<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Imágenes de Vehículos</title>
</head>
<body>
    <h1>Imágenes de Vehículos</h1>

    <%@ page import="com.modelo.Vehiculo" %>
    <% List<Vehiculo> vehiculos = (List<Vehiculo>) request.getAttribute("vehiculos"); %>

    <table border="1">
        <tr>
            <th>ID</th>
            <th>Modelo</th>
            <th>Marca</th>
            <th>Año</th>
            <th>Estado</th>
            <th>Placa</th>
            <th>Imagen</th>
        </tr>
        <% for (Vehiculo vehiculo : vehiculos) { %>
            <tr>
                <td><%= vehiculo.getIdVehiculo() %></td>
                <td><%= vehiculo.getModelo() %></td>
                <td><%= vehiculo.getMarca() %></td>
                <td><%= vehiculo.getAño() %></td>
                <td><%= vehiculo.getEstado() %></td>
                <td><%= vehiculo.getPlaca() %></td>
                <td><img src="MostrarImagenServlet?id=<%= vehiculo.getIdVehiculo() %>" width="100" height="100" /></td>
            </tr>
        <% } %>
    </table>
    
    <br>
    <a href="index.jsp">Volver al Inicio</a>
</body>
</html>

