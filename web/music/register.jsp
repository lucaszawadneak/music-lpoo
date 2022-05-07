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

        <!-- Latest compiled and minified JavaScript -->
        <script src="https://unpkg.com/multiple-select@1.5.2/dist/multiple-select.min.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar artista</title>
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <link href="<c:out value="${pageContext.request.contextPath}"/>/css/styles.css" rel="stylesheet" />
        <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css" />
        <link href="https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700" rel="stylesheet" type="text/css" />
    </head>

    <body id="page-top" style="background-color:#0A0708" class="container">

        <div style="margin-top: 100px; height: 600px">
            <div class="mt-lg-5">
                <h2 style="color: #ffc800">Cadastrar música</h2>
                <form action="../MusicController" method="POST">
                    <input name="action" value="store" type="hidden"/>
                    <a href="/music-lpoo/artist/selecionarArtista.jsp?redirectPage=music/register.jsp" class="btn btn-primary mb-2">Selecionar Artista</a>
                    <a href="/music-lpoo/album/selecionarAlbum.jsp?redirectPage=music/register.jsp" class="btn btn-primary mb-2">Selecionar Álbum</a>
                    <input class="form-control mb-2" placeholder="Nome" maxlength="50" name="nome" required/>
                    <input class="form-control mb-2" placeholder="Duração" maxlength="50" name="duracao" required/>
                    <textarea class="form-control mb-2" placeholder="Letra" maxlength="1000" name="letra" required></textarea>
                    <input class="form-control mb-2" placeholder="Link Spotify" maxlength="50" name="link_spotify" required/>
                    <input class="form-control mb-2" placeholder="Link Deezer" maxlength="50" name="link_deezer" required/>
                    <input class="form-control mb-2" placeholder="Link Apple Music" maxlength="50" name="link_apple" required/>
                    <select style="width:100%;" id="select" class="mb-2" for="music"  name="generos[]" multiple="multiple"  required>
                        <option value="Rock">Rock</option>
                        <option value="Funk">Funk</option>
                        <option value="Hip-Hop">Hip-Hop</option>
                        <option value="EDM">EDM</option>
                        <option value="Rap">Rap</option>
                    </select>

                    <input class="form-control mb-2" placeholder="Álbum" name="album" disabled value="${param.album_id}  name="album_id"/>

                    <input class="form-control mb-2" placeholder="Artista" value="${param.artist_id}" name="artist_id"/>
                
                    <<button type="submit" class="btn btn-warning">Cadastrar</button>
                    <a href="/music-lpoo/index.jsp" class="btn btn-secondary">Cancelar</a>
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
