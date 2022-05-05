<%-- 
    Document   : selecionarArtista
    Created on : May 5, 2022, 5:47:19 PM
    Author     : lucas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Selecionar artista</title>
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <link href="/music-lpoo/css/styles.css" rel="stylesheet" />
        <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css" />
        <link href="https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700" rel="stylesheet" type="text/css" /> 
    </head>
    <body class="container">
        <h2 class="mt-5">Selecionar artista</h2>
        <form action="/music-lpoo/ArtistController" method="GET">
            <div class="input-group mb-3 mt-3">
                <div class="input-group-prepend">
                  <button class="btn btn-outline-secondary" type="submit">Pesquisar</button>
                </div>
                <input type="text" class="form-control"name="searchParam" value="${param.searchParam}">
                <input type="hidden" name="action" value="search"/>
              </div>
        </form>
        
        <div class="card">
                    
            <c:forEach var="a" items="${artistas}">
                <a class="btn m-1" href="${page}?artist_id=${a.id}">
                    <strong class="card-header">${a.nome}</strong>
                </a>
            </c:forEach>           
        </div>
    </body>
</html>