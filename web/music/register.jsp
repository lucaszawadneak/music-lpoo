<%-- 
    Document   : index
    Created on : May 2, 2022, 4:20:47 PM
    Author     : lucas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://unpkg.com/multiple-select@1.5.2/dist/multiple-select.min.css">
        <link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath}/assets/favicon.ico" />
        <!-- Latest compiled and minified JavaScript -->
        <script src="https://unpkg.com/multiple-select@1.5.2/dist/multiple-select.min.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar artista</title>
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <link href="<c:out value="${pageContext.request.contextPath}"/>/css/styles.css" rel="stylesheet" />
        <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css" />
        <link href="https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700" rel="stylesheet" type="text/css" />
    </head>

    <body id="page-top" class="container">

        <div style="margin-top: 100px; height: 600px">
            <div class="mt-lg-5">
                <h2 style="color: #ffc800">Cadastrar música</h2>
                <a class="btn btn-primary mb-2" href="/music-lpoo/artist/selecionarArtista.jsp?album_id=${param.album_id}&redirectPage=../music-lpoo/music/register.jsp">Selecionar artista</a>
                <a class="btn btn-primary mb-2" href="/music-lpoo/album/selecionarAlbum.jsp?artist_id=${param.artist_id}&redirectPage=/music-lpoo/music/register.jsp">Selecionar álbum</a>
                <form id="music" name="music" action="../MusicController" method="POST">
                    <input name="action" value="store" type="hidden"/>
                    <input class="form-control mb-2" placeholder="Nome" maxlength="50" name="nome" required/>
                    <input class="form-control mb-2" placeholder="Artista" name="artist" readonly maxlength="50" required value="${param.artist_id}"/>
                    <input class="form-control mb-2" placeholder="Duração" maxlength="50" name="duracao" required/>
                    <textarea class="form-control mb-2" placeholder="Letra" maxlength="1000" name="letra" required></textarea>
                    <input class="form-control mb-2" placeholder="Link Spotify" maxlength="50" name="link_spotify" required/>
                    <input class="form-control mb-2" placeholder="Link Deezer" maxlength="50" name="link_deezer" required/>
                    <input class="form-control mb-2" placeholder="Link Apple Music" maxlength="50" name="link_apple" required/>
                    <input class="form-control mb-2" placeholder="Genero" maxlength="50" name="genero" required/>
                    <label for="album">Album</label>
                    <input class="form-control mb-2 album" name="album" value="${param.album_id}" readonly required/>
                
                    <button type="submit" class="btn btn-warning">Cadastrar</button>
                    <a href="./index.jsp"  class="btn btn-secondary">Cancelar</a>
                </form>
            </div>
        </div>
        <script>
            $('select').multipleSelect({
                    placeholder: 'Escolha os Generos'
            });            
        </script>
    </body>
</html>
