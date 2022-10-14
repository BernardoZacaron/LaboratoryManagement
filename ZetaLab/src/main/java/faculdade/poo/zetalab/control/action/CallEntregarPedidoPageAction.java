/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
 * @author web
 */
public class CallEntregarPedidoPageAction implements ICommanderAction {

    public CallEntregarPedidoPageAction() {
    }

    @Override
    public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        VerificadorLogin.verificaLogado(request, response);
        
        try {
            Pedido pedido = new PedidoDAO().findById(Integer.parseInt(request.getParameter("id")));
            
            request.setAttribute("pedido", pedido);
            RequestDispatcher rd = request.getRequestDispatcher("pages/master.jsp?pg=entregaPedido");
            rd.forward(request, response);
        } catch (SQLException ex) {
            request.setAttribute("msg", "pedido não localizado");
            new CallListaTodosPedidosPageAction().executa(request, response);
        }

    }
    
}
