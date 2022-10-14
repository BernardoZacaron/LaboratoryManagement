<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous"/>
        <link rel="stylesheet" href="css/estilo.css">
        <title>Zeta Lab</title>
    </head>
    <body>
        <h1 class="titulo">Olá, faça o login para acessar o sistema.</h1><br>
        <div id="box-login">
            <form action="control" method="post">
                <input type="hidden" name="ac" value="verificarLogin"/>
                <div class="form-group">
                    <label for="cpLogin"><b>Login</b></label>
                    <input type="text" name="cpLogin" class="form-control" required>
                    <br>
                    <label for="cpSenha"><b>Senha</b></label>
                    <input type="password" name="cpSenha" class="form-control" required>
                    <br><br>
                    <button type="submit" class="btn btn-primary">Entrar</button>
                    <br>
                    <a href="control?ac=addUsuario">Registrar novo usuário</a>
                </div>
            </form>
        </div>
    <center><span style="color: red; background-color: grey;">${requestScope.msg}</span></center>
    </body>
</html>
