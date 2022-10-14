<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--<div class="card-exame">
    <div class="foto"><img src="img/exame.png"></div>
    <div class="titulo-card">Exame de sangue</div>
    <div class="exame-info">
        Resultado em X dias | Preço: R$50,0
    </div>
</div>-->

<c:if test="${requestScope.exames == null}">
    <h1>Nenhum exame cadastrado</h1>
</c:if>

<c:forEach items="${requestScope.exames}" var="e">
<div class="card-exame">
    <div class="foto"><img src="img/exame.png"></div>
    <div class="titulo-card"><b>${e.nome}</b></div>
    <div class="exame-info">
        <p>Resultado em <b>${e.prazoEntrega}</b> dias | Preço: R$<b>${e.custo}</b></p>
    </div>
</div>
</c:forEach>