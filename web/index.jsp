<%-- 
    Document   : index
    Created on : 27/08/2023, 10:37:11 p. m.
    Author     : P90
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
            <link href="https://getbootstrap.com/docs/5.3/assets/css/docs.css" rel="stylesheet">
        <title>SafeRoam</title>
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"></script>
   
    </head>
    <body>
 <nav class="navbar navbar-expand-lg" style="background-color: #008080;" data-bs-theme="dark">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">SafeRoam</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="#">Historial</a>
        </li>
        <li class="nav-item">
          <a class="nav-link active" href="#">Factura</a>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            Contacto
          </a>
          <ul class="dropdown-menu">
              <li><a class="dropdown-item" href="CrudVehiculos.jsp">Action</a></li>
            <li><a class="dropdown-item" href="#">Another action</a></li>
            <li><hr class="dropdown-divider"></li>
            <li><a class="dropdown-item" href="#">Something else here</a></li>
          </ul>
        </li>
        <li class="nav-item">
          <a class="nav-link disabled" aria-disabled="true">En desarrollo...</a>
        </li>
      </ul>
      <form class="d-flex" role="search">
        <input class="form-control me-2" type="search" placeholder="Buscar vehiculo" aria-label="Search">
        <button class="btn btn-success" type="submit">Buscar</button>
      </form><!-- comment -->
      <ul class="navbar-nav">
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            Iniciar session
          </a>
          <ul class="dropdown-menu">
              <li><a class="dropdown-item" href="#">Action</a></li>
            <li><a class="dropdown-item" href="#">Another action</a></li>
            <li><hr class="dropdown-divider"></li>
            <li><a class="dropdown-item" href="#">Something else here</a></li>
          </ul>
        </li>
      </ul>

      
    </div>
  </div>
</nav>
       <div class="container mt-2">
            <div class="fila">
               
                <div class="col-sm-4">
                    <div class="card" style="background-color: #6B7C7C">
                        <div class="card-header"><label style="color: #FFFFFF">Marca</label></div>
                        <div class="card-body">
                            <i style="color: #00FF00">$.1.200.000</i>
                            <img src="src" width="190" height="180">
                        </div>
                        
                        <div class="card-footer">
                                  <li class="list-group-item" style="color: #333333">Modelo: </li>
                                  <li class="list-group-item" style="color: #333333">Año: </li> 
                                <a class="btn btn-outline-success" style="background-color: #00CED1">Solicitar Alquiler</a>                                                              
                            </div>
                        </div>
                    </div>
                    
                </div> 
                

                
            </div>
        </div>
        
    </body>
</html>
