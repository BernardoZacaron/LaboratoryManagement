<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" href="css/estilo.css">
        <title>Zeta Lab</title>
    </head>
    <body>
        <header>
            <div id="img-logo">
                <img src="img/logo.png" height="120px">
            </div>
            <div id="texto-header">
                <p class="display-3"><b>Zeta Lab</b> - Análises Clínicas</p>
                <p class="font1 font-weight-light">Bem-vindo!&nbsp;&nbsp;&nbsp; <span style="color: purple; background-color: orange;">${requestScope.msg}</span></p>
            </div>
        </header>
        <main>
            <div id="menu-principal">
                <div class="d-flex flex-column flex-shrink-0 p-3 bg-light" style="width: 100%;">
                    <h5 style="font-size: 2.0em;">&nbsp;&nbsp;<u>Navegação</u></h5>
                    <ul class="nav nav-pills flex-column mb-auto">
                      <li class="nav-item">
                        <a href="control?ac=home" class="nav-link link-dark item-menu" aria-current="page">
                            <img src="img/icon-home.png" class="icone-menu">
                            Home
                        </a>
                      </li>
                      <li>
                        <a href="control?ac=listaExames" class="nav-link link-dark item-menu" aria-current="page" class="item-menu">
                            <img src="img/icon-exames.png" class="icone-menu">
                            Exames
                        </a>
                      </li>
                      
                      <c:if test="${sessionScope.user.tipo == 3}">
                      <li>
                        <a href="control?ac=relatorio" class="nav-link link-dark item-menu" aria-current="page" class="item-menu">
                            <img src="img/icon-grafico.png" class="icone-menu">
                            Relatório
                        </a>
                      </li>
                      </c:if>
                      
                      <c:if test="${sessionScope.user.tipo == 2}">
                      <li>
                        <a href="control?ac=addExame" class="nav-link link-dark item-menu" aria-current="page" class="item-menu">
                            <img src="img/icon-add.png" class="icone-menu">
                            Cadastrar exame
                        </a>
                      </li>
                      <li>
                        <a href="control?ac=todosPedidos" class="nav-link link-dark item-menu" aria-current="page" class="item-menu">
                            <img src="img/icon-exames.png" class="icone-menu">
                            Listar pedidos
                        </a>
                      </li>
                      </c:if>
                      
                      <c:if test="${sessionScope.user.tipo == 1}">
                      <li>
                        <a href="control?ac=addPedido" class="nav-link link-dark item-menu" aria-current="page" class="item-menu">
                            <img src="img/icon-add.png" class="icone-menu">
                            Cadastrar pedido
                        </a>
                      </li>
                      <li>
                        <a href="control?ac=meusPedidos" class="nav-link link-dark item-menu" aria-current="page" class="item-menu">
                            <img src="img/icon-lista.png" class="icone-menu">
                            Meus pedidos
                        </a>
                      </li>
                      </c:if>
                      
                      <c:if test="${sessionScope.user != null}">
                      <li id="ultimo-item">
                        <a href="control?ac=logout" class="nav-link link-dark item-menu" aria-current="page" class="item-menu">
                            <img src="img/icon-sair.png" class="icone-menu">
                            Sair
                        </a>
                      </li>
                      </c:if>
                    </ul>
                    <hr>

                </div>
            </div> 
            <div id="box-conteudo"><jsp:include page="${param.pg}.jsp"/></div>
        </main>
    </body>
</html>
