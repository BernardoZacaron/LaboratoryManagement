<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${sessionScope.pedidos == null}">
    <h1>Nenhum pedido cadastrado</h1>
</c:if>

<c:forEach items="${sessionScope.pedidos}" var="p">
<div class="card-pedido">
    <div class="foto"><img src="img/pedido.png"></div>
    <div class="titulo-card"><b>${p.exame.nome}</b></div>
    <div class="exame-info">
            <c:if test="${!p.usuario.temPlano}">
                <p>Preço: R$<b>${p.exame.custo}</b></p>
            </c:if>
            <c:if test="${p.usuario.temPlano}">
                <p style="color: lightgreen;">Grátis</p>
            </c:if>
            <c:if test="${sessionScope.user.tipo == 2}">
                <p>Paciente: ${p.usuario.nome}</p>
            </c:if>
    </div>
    <div class="acoes">   
        <c:if test="${p.entregue == false}">
            <div class="btn-excluir btn-acao"><a href="control?ac=cancelarPedido&id=${p.id}"><img src="img/btn-excluir.png" width="100%"></a></div>
            <c:if test="${sessionScope.user.tipo == 2}">
                <div class="btn-acao"><a href="control?ac=entregarPedido&id=${p.id}"><img src="img/btn-confirmar.png" width="100%"></a></div>
            </c:if>
        </c:if>
        <c:if test="${p.entregue == true}">
            <div class="btn-abrir"><a href="control?ac=visualizarPedido&id=${p.id}"><img src="img/btn-abrir.png" width="100%"></a></div>        
        </c:if>
    </div>
</div>
</c:forEach>