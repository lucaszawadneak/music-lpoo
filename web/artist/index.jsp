<%-- 
    Document   : index
    Created on : May 2, 2022, 4:20:47 PM
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
        <title>Artist</title>
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <link href="/music-lpoo/css/styles.css" rel="stylesheet" />
        <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css" />
        <link href="https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700" rel="stylesheet" type="text/css" />
    </head>
    <body id="page-top" class="container">
        <c:if test="${empty artista.id}">
            <c:redirect url="/index.jsp" />
        </c:if>
        <div class="mt-lg-5">
            <h2>${artista.nome}</h2>
            <c:if test="${empty musicCount}">
                <p>0 músicas</p>
            </c:if>
            <c:if test="${not empty musicCount}">    
                <p>${musicCount} músicas</p>
            </c:if>
                
            <p>${artista.descricao}</p>
            
            <nav class="navbar navbar-light bg-light px-5" style="border-radius:5px">
                <a class="btn btn-light" href="./music/register.jsp?artist_id=${artista.id}">Cadastrar nova música</a>
                <a class="btn btn-light" href="./album/register.jsp">Cadastrar novo álbum</a>
                <a class="btn btn-light" href="./index.jsp">Voltar para página inicial</a>
            </nav>
            
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
            <c:if test="${empty musicList}">
                <strong>Nenhuma música encontrada
            </c:if>
                    
            <c:forEach var="m" items="${musicList}">
                <div class="card my-3">
                    <strong class="card-header">${m.title}</strong>
                    <div class="card-body">
                        <p>Duração: ${m.duration}</p>
                        <a href="/music-lpoo/MusicController?id=${m.id}" class="card-link">Ir para música</a>
                    </div>
                </div>
            </c:forEach>
            
            <nav aria-label="Page navigation example">
            <c:if test="${not empty musicCount}">
              <ul class="pagination">
                  <c:forEach var="indexPage" begin="0" end="${musicCount}" >
                    <li class="page-item"><a class="page-link" href="ArtistController?id=${artista.id}&page=${indexPage}&searchParam=${param.searchParam}">${indexPage+1}</a></li>
                </c:forEach>
              </ul>
            </c:if>
            </nav>
        </div>
    </body>
</html>
