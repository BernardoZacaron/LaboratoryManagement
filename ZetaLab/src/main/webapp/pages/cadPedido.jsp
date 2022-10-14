
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h2 class="titulo">Agendamento de exame</h2><br>
            <form action="control" method="post">
                <input type="hidden" name="ac" value="savePedido"/>
                    <div class="form-row">
                        <div class="col-auto my-1 alinhar-centro">
                            <select class="custom-select mr-sm-2" name="cpExame" style="width: 650px;">
                                <option value="0">Selecione o exame</option>
                                <c:forEach items="${requestScope.exames}" var="e">
                                <option value="${e.id}">${e.nome}</option>
                                </c:forEach>
                            </select>
                        </div>
                        
                        <div class="col-auto my-1">
                            <button type="submit" class="btn btn-primary">Registrar pedido</button>
                        </div>
                    </div>
            </form>
                                
            <div class="alinhar-centro" style="margin-top: 60px;"><img src="img/doutor.jpg"/></div>
                                
        <span style="color: red; background-color: grey;">${requestScope.msg}</span>

