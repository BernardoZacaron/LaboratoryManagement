<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous"/>
        <link rel="stylesheet" href="css/estilo.css">
        <title>Zeta Lab</title>
    </head>
    <body>
        <h2 class="titulo">Cadastrar novo tipo de exame.</h2><br>
            <form action="control" method="post">
                <input type="hidden" name="ac" value="saveExame"/>
                <div class="form-group">
                    <label for="cpNome"><b>Nome do exame</b></label>
                    <input type="text" name="cpNome" class="form-control" required>
                    <br>
                    <div class="linha-form">
                        <div class="form-inline campo-linha">
                            <label for="cpCusto"><b>Custo: R$</b></label>
                            <input type="number" step="0.01" name="cpCusto" class="campo-pequeno form-control" required style="width: 40%;">
                        </div>
                        <div class="form-inline  campo-linha">
                            <label for="cpJejum"><b>Jejum de </b></label>
                            <input type="number" name="cpJejum" class="form-control campo-pequeno" required style="width: 25%;">
                            <label for="cpJejum"><b> horas</b></label>
                        </div>
                        <div class="form-inline  campo-linha">
                            <label for="cpPrazo"><b>Prazo de entrega </b></label>
                            <input type="number" name="cpPrazo" class="form-control campo-pequeno" required style="width: 18%;">
                            <label for="cpPrazo"><b> dias</b></label>
                        </div>
                    </div>
                    <br><br>
                    <div class="alinhar-centro"><button type="submit" class="btn-lg btn-primary">Salvar</button></div>
                </div>
            </form>
        <span style="color: red; background-color: grey;">${requestScope.msg}</span>
    </body>
</html>
