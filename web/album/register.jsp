<%-- 
    Document   : addAlbum
    Created on : 06/05/2022, 13:13:43
    Author     :  Gustavo Schwanka GRR20193748
                  Leonardo Xavier da Silva Moraes GRR20204488
                  Lucas Cassilha Zawadneak GRR20200141
                  Ludimilla Krautzuk GRR20204467
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar album</title>
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <link href="/music-lpoo/css/styles.css" rel="stylesheet" />
        <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css" />
        <link href="https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700" rel="stylesheet" type="text/css" />
    </head>
    <body id="page-top" class="container"></body>
        <div class="mt-lg-5">
            <h2>Cadastrar album</h2>
            <form action="../AlbumController" method="POST">
                <input name="action" value="store" type="hidden"/>
                <input class="form-control mb-2" placeholder="Nome" maxlength="50" name="nome" required/>
                <select name="ano" data-component="date" class="form-control mb-2" required>
                 <c:forEach var="ano" begin="1900" end="2022"step="1">
                     <option class="form-control mb-2">${ano}</option>
                </c:forEach>         
                </select>
                <button onclick="window.location.href='../index.jsp';" type="button" class="btn btn-secondary">Cancelar</button> 
                <button type="submit" class="btn btn-warning">Cadastrar</button>
            </form>
        </div>
    </body>
</html>

