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
        <link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath}/assets/favicon.ico" />
        <link href="<c:out value="${pageContext.request.contextPath}"/>/css/styles.css" rel="stylesheet" />
        <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css" />
        <link href="https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700" rel="stylesheet" type="text/css" /> 
    </head>
    <body id="page-top" class="container">
        <nav class="navbar navbar-expand-lg navbar-dark fixed-top" id="mainNav">
            <div class="container">
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                    Menu
                    <i class="fas fa-bars ms-1"></i>
                </button>
                <div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav text-uppercase ms-auto py-4 py-lg-0">
                        <li class="nav-item"><a class="nav-link" href="./artist/register.jsp">CADASTRO ARTISTA</a></li>
                        <li class="nav-item"><a class="nav-link" href="./music/register.jsp">CADASTRO MUSICA</a></li>
                        <li class="nav-item"><a class="nav-link" href="./album/register.jsp">CADASTRO ALBUM</a></li>
                        <li class="nav-item"><a class="nav-link" href="./index.jsp">Página Inicial</a></li>  
                    </ul>
                </div>
            </div>
        </nav>
        <h2 class="mt-5">Selecionar Música</h2>
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
            <c:forEach var="m" items="${musicas}">
                <a class="btn m-1" href="${page}?music_id=${m.id}">
                    <strong class="card-header">${m.nome}</strong>
                </a>
            </c:forEach>     
        </div>
    </body>
</html>
