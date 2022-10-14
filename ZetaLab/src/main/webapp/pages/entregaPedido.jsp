
        <h1 class="titulo">Pedido:</h1><br>
        <div class="card-pedido">
            <div class="foto"><img src="img/pedido.png"></div>
            <div class="titulo-card"><b>${requestScope.pedido.exame.nome}</b></div>
            <div class="exame-info">
                <p>ID do pedido: ${requestScope.pedido.id} | Paciente: ${requestScope.pedido.usuario.nome}</p>
            </div>
        </div>
        <br>
        <form action="control" method="POST">
            <input type="hidden" name="ac" value="finalizarPedido"/>
            <input type="hidden" name="id" value="${requestScope.pedido.id}"/>
            <label for="cpResultado">Insira o resultado do exame:</label>
            <textarea class="form-control" name="cpResultado" rows="3"></textarea>
            <br><br>
            <button type="submit" class="btn btn-primary">Enviar resultado</button>
        </form>
