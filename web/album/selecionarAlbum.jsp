<%-- 
    Document   : selecionarAlbum
    Created on : May 5, 2022, 5:47:19 PM
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
        <title>Selecionar Album</title>
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <link href="/music-lpoo/css/styles.css" rel="stylesheet" />
        <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css" />
        <link href="https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700" rel="stylesheet" type="text/css" /> 
    </head>
    <body class="container">
        <h2 class="mt-5">Selecionar Album</h2>
        <form action="/music-lpoo/RecordController" method="POST">
            <div class="input-group mb-3 mt-3">
                <div class="input-group-prepend">
                  <button class="btn btn-outline-secondary" type="submit">Pesquisar</button>
                </div>
                <input type="text" class="form-control"name="searchParam" value="${param.searchParam}" minlength="3">
                <input type="hidden" name="action" value="search"/>
              </div>
        </form>
        
        <div class="card p-3">
            <c:forEach var="a" items="${albuns}">
                <c:if test="${empty redirectPage}">
                    <a class="btn btn-primary m-1" href="RecordController?id=${a.id}">
                        <strong>${a.nome}</strong>
                    </a>
                </c:if>
                <c:if test="${not empty redirectPage}">
                    <a class="btn btn-primary m-1" href="${redirectPage}?id=${a.id}">
                        <strong>${a.nome}</strong>
                    </a>
                </c:if>
            </c:forEach>
            <c:if test="${empty albuns}">
                <strong>Nenhum album encontrado</strong>
            </c:if>
        </div>
    </body>
</html>
