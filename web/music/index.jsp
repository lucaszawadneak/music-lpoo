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
        <title>Music</title>
        <link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath}/assets/favicon.ico" />
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <link href="<c:out value="${pageContext.request.contextPath}"/>/css/styles.css" rel="stylesheet" />
        <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css" />
        <link href="https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700" rel="stylesheet" type="text/css" />
    </head>
<<<<<<< HEAD
    <body id="page-top"  class="container">
        <c:if test="${empty musica.id}">
            <c:redirect url="/index.jsp" />
        </c:if>
        <div class="mt-lg-5">
            <nav class="navbar navbar-expand-lg">
=======
    <body id="page-top" style="background-color:#0A0708" class="container">
        <c:if test="${empty musica}">
            <c:redirect url="/index.jsp" />
        </c:if>
        <div class="mt-lg-5">
            <h2>${musica.nome}</h2>
            <nav class="navbar navbar-expand-lg navbar-dark fixed-top" id="mainNav">
>>>>>>> 4590848cadcfc236a9ce97474313af5571845153
                <div class="container">
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                        Menu
                        <i class="fas fa-bars ms-1"></i>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarResponsive">
                        <ul class="navbar-nav text-uppercase ms-auto py-4 py-lg-0">
                            <li class="nav-item"><a class="nav-link" href="MusicController?action=store">Cadastrar nova Musica</a></li>
                            <li class="nav-item"><a class="nav-link" href="RecordController?action=store">Cadastrar novo álbum</a></li>
                            <li class="nav-item"><a class="nav-link" href="./index.jsp">Voltar para página inicial</a></li>
                        </ul>
                    </div>
                </div>
            </nav>

<<<<<<< HEAD
            <div class="card my-3 mt-5">
                    <strong class="card-header">${musica.title}</strong>
                    <div class="card-body">
                        <p>Duração: ${musica.duration}</p>
                        <p>Letra: ${musica.lyrics}</p>
                        <p>Generos: ${musica.generos}</p>
                        <p>Links: ${musica.links}</p>
                        <p>Visualizações: ${musica.visualizacoes}</p>
                        <a href="/music-lpoo/AlbumController?id=${musica.album.id}" class="card-link">Ir para Album</a>
=======
            <c:forEach var="m" items="${musicas}" varStatus="count">
                <div class="card my-3">
                    <strong class="card-header">${m.title}</strong>
                    <div class="card-body">
                        <p>Duração: ${m.duration}</p>
                        <p>Artista: ${m.artist.name}</p>
                        <p>Letra: ${m.lyrics}</p>
                        <p>Generos: ${m.generos}</p>
                        <p>Links: ${m.links.linkSpotify}/${m.links.linkDeezer}/${m.links.linkAppleMusic}</p>
                        <p>Visualizações: ${m.visualizacoes}</p>
                        <a href="/music-lpoo/album/AlbumController?id=${m.album.id}" class="card-link">Ir para Album</a>
                        <a href="/music-lpoo/artist/ArtistController?id=${m.arist.id}" class="card-link">Ir para Artista</a>
>>>>>>> 4590848cadcfc236a9ce97474313af5571845153
                    </div>
                </div>
            <strong>Artistas</strong>
            <c:forEach var="a" items="${artistas}">
                <br></br>
                <a href="/music-lpoo/ArtistController?id=${a.id}" >${a.nome}</a>
            </c:forEach>
        </div>
    </body>
</html>
