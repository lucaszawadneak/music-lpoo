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
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <link href="<c:out value="${pageContext.request.contextPath}"/>/css/styles.css" rel="stylesheet" />
        <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css" />
        <link href="https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700" rel="stylesheet" type="text/css" />
    </head>
    <body id="page-top" style="background-color:#0A0708" class="container">
        <c:if test="${empty artista}">
            <c:redirect url="/index.jsp" />
        </c:if>
        <div class="mt-lg-5">
            <h2>${artista.nome}</h2>
            <nav class="navbar navbar-expand-lg navbar-dark fixed-top" id="mainNav">
                <div class="container">
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                        Menu
                        <i class="fas fa-bars ms-1"></i>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarResponsive">
                        <ul class="navbar-nav text-uppercase ms-auto py-4 py-lg-0">
                            <li class="nav-item"><a class="nav-link" href="ArtistController?action=store">Cadastrar nova artista</a></li>
                            <li class="nav-item"><a class="nav-link" href="RecordController?action=store">Cadastrar novo álbum</a></li>
                            <li class="nav-item"><a class="nav-link" href="./index.jsp">Voltar para página inicial</a></li>
                        </ul>
                    </div>
                </div>
            </nav>
            <p>${musicCount} músicas</p>
            <form action="ArtistController" method="GET">
                <div class="input-group mb-3 mt-3">
                    <div class="input-group-prepend">
                        <button class="btn btn-outline-secondary" type="submit">Pesquisar</button>
                    </div>
                    <input type="text" class="form-control"name="searchParam" value="${param.searchParam}">
                    <input type="hidden" name="id" value="${artista.id}">
                    <input type="hidden" name="page" value="0">
                </div>
            </form>

            <c:forEach var="m" items="${musicas}">
                <div class="card my-3">
                    <strong class="card-header">${m.title} (${m.ano})</strong>
                    <div class="card-body">
                        <p>Duração: ${m.duracao}</p>
                        <a href="/music/index.jsp?id=${m.id}" class="card-link">Ir para música</a>
                    </div>
                </div>
            </c:forEach>
            <div class="card my-3">
                <strong class="card-header">Nome da música (ano)</strong>
                <div class="card-body">
                    <p>Duração: 3:12</p>
                    <a href="/music/index.jsp?id=1" class="card-link">Ir para música</a>
                </div>
            </div>

            <nav aria-label="Page navigation example">
                <ul class="pagination">
                    <li class="page-item"><a class="page-link" href="ArtistController?id=${artista.id}&page=1&searchParam=${param.searchParam}">1</a></li>
                    <li class="page-item"><a class="page-link" href="ArtistController?id=${artista.id}&page=2&searchParam=${param.searchParam}">2</a></li>
                    <li class="page-item"><a class="page-link" href="ArtistController?id=${artista.id}&page=3&searchParam=${param.searchParam}">3</a></li>
                    <li class="page-item"><a class="page-link" href="ArtistController?id=${artista.id}&page=4&searchParam=${param.searchParam}">4</a></li>
                    <li class="page-item"><a class="page-link" href="ArtistController?id=${artista.id}&page=5&searchParam=${param.searchParam}">5</a></li>
                    <li class="page-item"><a class="page-link" href="ArtistController?id=${artista.id}&page=6&searchParam=${param.searchParam}">6</a></li>
                    <li class="page-item"><a class="page-link" href="ArtistController?id=${artista.id}&page=7&searchParam=${param.searchParam}">7</a></li>
                    <li class="page-item"><a class="page-link" href="ArtistController?id=${artista.id}&page=8&searchParam=${param.searchParam}">8</a></li>
                    <li class="page-item"><a class="page-link" href="ArtistController?id=${artista.id}&page=9&searchParam=${param.searchParam}">9</a></li>
                </ul>
            </nav>
        </div>
    </body>
</html>
