/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
 * @author web
 */
public class CallListaTodosPedidosPageAction implements ICommanderAction{

    public CallListaTodosPedidosPageAction() {
    }

    @Override
    public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        VerificadorLogin.verificaLogado(request, response);
        
        List<Pedido> todosPedidos = new ArrayList<>();
        
        try {
            todosPedidos = new PedidoDAO().findAll();
        } catch (SQLException ex) {
            request.setAttribute("msg", "erro ao buscar pedidos no banco");
            new CallHomePageAction().executa(request, response);
        }
        
        if(!todosPedidos.isEmpty())
            request.getSession().setAttribute("pedidos", todosPedidos);
        
        RequestDispatcher rd = request.getRequestDispatcher("pages/master.jsp?pg=listaPedidos");
        rd.forward(request,response);
    }
}
