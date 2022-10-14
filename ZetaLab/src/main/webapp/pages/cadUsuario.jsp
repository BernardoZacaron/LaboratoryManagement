<%-- 
    Document   : cadUsuario
    Created on : 11/05/2022, 11:21:41
    Author     : Windows 10
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous"/>
        <link rel="stylesheet" href="css/estilo.css">
        <title>Zeta Lab</title>
    </head>
    <body>
        <h1 class="titulo">Olá, registre-se para acessar o sistema.</h1><br>
        <div id="box-login">
            <form action="control" method="post">
                <input type="hidden" name="ac" value="saveCliente"/>
                <div class="form-group">
                    <label for="cpNome"><b>Nome</b></label>
                    <input type="text" name="cpNome" class="form-control" required>
                    <br>
                    <label for="cpLogin"><b>Login</b></label>
                    <input type="text" name="cpLogin" class="form-control" required>
                    <br>
                    <label for="cpSenha"><b>Senha</b></label>
                    <input type="password" name="cpSenha" class="form-control" required>
                    <br>
                    <div class="form-inline mx-sm-3 mb-2">
                        <div class="form-group campo-linha">
                            <label for="cpCpf"><b>CPF </b></label>
                            <input type="text" name="cpCpf" class="campo-medio form-control" required>
                        </div>
                        <div class="form-group campo-linha">
                            <label for="cpTelefone"><b>Telefone </b></label>
                            <input type="text" name="cpTelefone" class="form-control campo-medio" required>
                        </div>
                    </div>
                    <br>
                    <div style="margin-left: 40px;" class="campo-check">
                        <input class="form-check-input" type="checkbox" name="cpPlano">
                        <label for="cpPlano">Tenho plano de saúde</label>
                    </div>
                    <br><br>
                    <div class="alinhar-centro">
                        <button type="submit" class="btn btn-primary">Salvar</button>
                    </div>
                </div>
            </form>
        </div>
        <span style="color: red; background-color: grey;">${requestScope.msg}</span>
    </body>
</html>
