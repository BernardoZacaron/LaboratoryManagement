/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faculdade.poo.zetalab.control.action;

import faculdade.poo.zetalab.control.ICommanderAction;
import faculdade.poo.zetalab.dao.PedidoDAO;
import faculdade.poo.zetalab.model.Pedido;
import faculdade.poo.zetalab.util.VerificadorLogin;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Windows 10
 */
public class CallVisualizarPedidoPageAction implements ICommanderAction {

    public CallVisualizarPedidoPageAction() {
    }

    @Override
    public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        VerificadorLogin.verificaLogado(request, response);
        
        Pedido pedido = null;

        try {
            pedido = new PedidoDAO().findById(Integer.parseInt(request.getParameter("id")));
            request.setAttribute("pedido", pedido);
            RequestDispatcher rd = request.getRequestDispatcher("pages/master.jsp?pg=pedido");
            rd.forward(request, response);
        } catch (SQLException ex) {
            request.setAttribute("msg", "Não foi possível localizar o pedido");
            new CallExamesPageAction().executa(request, response);
        }
    }
    
}
