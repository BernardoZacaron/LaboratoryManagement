/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faculdade.poo.zetalab.control.action;

import faculdade.poo.zetalab.control.ICommanderAction;
import faculdade.poo.zetalab.dao.PedidoDAO;
import faculdade.poo.zetalab.model.Pedido;
import faculdade.poo.zetalab.model.Usuario;
import faculdade.poo.zetalab.util.VerificadorLogin;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Windows 10
 */
public class CallListaMeusPedidosPageAction implements ICommanderAction {

    public CallListaMeusPedidosPageAction() {
    }

    @Override
    public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        VerificadorLogin.verificaLogado(request, response);
        
        Usuario user = (Usuario) request.getSession().getAttribute("user");
        List<Pedido> pedidos = new ArrayList<>();
        
        try {
            pedidos = new PedidoDAO().findMeusPedidos(user.getId());
        } catch (SQLException ex) {
            request.setAttribute("msg", "erro ao buscar pedidos no banco");
            new CallHomePageAction().executa(request, response);
        }
        
        if(!pedidos.isEmpty())
            request.getSession().setAttribute("pedidos", pedidos);
        
        RequestDispatcher rd = request.getRequestDispatcher("pages/master.jsp?pg=listaPedidos");
        rd.forward(request,response);
    }
    
}
