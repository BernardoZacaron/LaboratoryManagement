<h2>O resultado do seu pedido chegou!</h2>
<br>
<p>&bull; ID: ${requestScope.pedido.id}</p>
<p>&bull; Paciente: ${requestScope.pedido.usuario.nome}</p>
<p>&bull; Resultado: </p>
<div class="box-resultado">
    <p>${requestScope.pedido.resultado}</p>
</div>