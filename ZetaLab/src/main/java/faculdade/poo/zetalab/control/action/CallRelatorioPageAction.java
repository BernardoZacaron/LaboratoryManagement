/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faculdade.poo.zetalab.control.action;

import faculdade.poo.zetalab.control.ICommanderAction;
import faculdade.poo.zetalab.dao.PedidoDAO;
import faculdade.poo.zetalab.model.Laboratorio;
import faculdade.poo.zetalab.util.VerificadorLogin;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Windows 10
 */
public class CallRelatorioPageAction implements ICommanderAction {

    public CallRelatorioPageAction() {
    }

    @Override
    public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        VerificadorLogin.verificaLogado(request, response);
        
        Laboratorio lab = new Laboratorio();
        double ganhoTotal=0, ganhoPlano=0;
        
        try {
            ganhoTotal = lab.calcularGanhosTotais(new PedidoDAO().findAll());
        } catch (SQLException ex) {
            request.setAttribute("msg", "Erro ao buscar pedidos no banco");
            new CallHomePageAction().executa(request, response);
        }
        
        try {
            ganhoPlano = lab.calcularGanhosPlano(new PedidoDAO().findAll());
        } catch (SQLException ex) {
            request.setAttribute("msg", "Erro ao buscar pedidos no banco");
            new CallHomePageAction().executa(request, response);
        }
        
        request.setAttribute("ganhoTotal", ganhoTotal);
        request.setAttribute("ganhoPlano", ganhoPlano);
        
        RequestDispatcher rd = request.getRequestDispatcher("pages/master.jsp?pg=relatorio");
        rd.forward(request,response);
    }
    
}
