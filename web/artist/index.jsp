<%-- 
    Document   : index
    Created on : May 2, 2022, 4:20:47 PM
    Author     : lucas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Artist</title>
        <%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
        <link href="../css/styles.css" rel="stylesheet" />
        <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css" />
        <link href="https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700" rel="stylesheet" type="text/css" />
    </head>
    <body id="page-top" class="container"></body>
        <div class="mt-lg-5">
            <h2>Nome do artista</h2>
            <p>30 músicas</p>
            
            <nav class="navbar navbar-light bg-light px-5" style="border-radius:5px">
                <a class="btn btn-light">Cadastrar nova música</a>
                <a class="btn btn-light">Cadastrar novo álbum</a>
                <a class="btn btn-light" href="../index.jsp">Voltar para página inicial</a>
            </nav>
            
            
            <div class="card my-3">
                <strong class="card-header">Nome da música (ano)</strong>
                <div class="card-body">
                    <p>Duração: 3:12</p>
                    <a href="#" class="card-link">Ir para música</a>
                </div>
            </div>
            
            <nav aria-label="Page navigation example">
              <ul class="pagination">
                <li class="page-item">
                  <a class="page-link" href="#" aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                  </a>
                </li>
                <li class="page-item"><a class="page-link" href="?page=1">1</a></li>
<!--            <li class="page-item"><a class="page-link" href="?page=2">2</a></li>
                <li class="page-item"><a class="page-link" href="?page=3">3</a></li>-->
                <li class="page-item">
                  <a class="page-link" href="#" aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                  </a>
                </li>
              </ul>
            </nav>
        </div>
    </body>
</html>
