<h2>Bem-vindo, ${sessionScope.user.nome}!</h2>
<p>Confira a seguir o relatório de ganhos da clínica:</p>
<br>
<h3 class="display-4" style="font-size: 2.5em;">Ganhos totais com exames de R$<b>${requestScope.ganhoTotal}</b>.</h3>
<h3 class="display-4" style="font-size: 2.5em; background-color: #73AD21;">Sendo R$<b>${requestScope.ganhoPlano}</b> derivado de planos de saúde.</h3>
<br>
<div class="alinhar-centro"><img src="img/relatorio.png" width="50%"></div>