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
        <title>Cadastrar artista</title>
        <%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
        <link href="../css/styles.css" rel="stylesheet" />
        <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css" />
        <link href="https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700" rel="stylesheet" type="text/css" />
    </head>
    <body id="page-top" class="container"></body>
        <div class="mt-lg-5">
            <h2>Cadastrar artista</h2>
            <form action="../ArtistController" method="POST">
                <input class="form-control mb-2" placeholder="Nome" maxlength="50" name="nome"/>
                <input class="form-control mb-2" placeholder="País" maxlength="50" name="pais"/>
                <textarea class="form-control mb-2" placeholder="Descrição" maxlength="150" name="descricao"></textarea>
                <button type="submit" class="btn btn-secondary">Cancelar</button>
                <button type="submit" class="btn btn-warning">Cadastrar</button>
            </form>
        </div>
    </body>
</html>
