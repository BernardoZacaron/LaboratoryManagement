/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faculdade.poo.zetalab.control.action;

import faculdade.poo.zetalab.control.ICommanderAction;
import faculdade.poo.zetalab.dao.PedidoDAO;
import faculdade.poo.zetalab.model.Usuario;
import faculdade.poo.zetalab.util.VerificadorLogin;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Windows 10
 */
public class CancelarPedidoAction implements ICommanderAction {

    public CancelarPedidoAction() {
    }

    @Override
    public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        VerificadorLogin.verificaLogado(request, response);
        
        PedidoDAO ped = new PedidoDAO();

        try {
            ped.apagar(ped.findById(Integer.parseInt(request.getParameter("id"))));
            request.setAttribute("msg", "Pedido cancelado com sucesso");
        } catch (SQLException ex) {
            request.setAttribute("msg", "não foi possível cancelar o pedido");
        }
        
        Usuario logado = (Usuario) request.getSession().getAttribute("user");
        
        if(logado.getTipo()==1)
            new CallListaMeusPedidosPageAction().executa(request, response);
        else
            new CallListaTodosPedidosPageAction().executa(request, response);
    }
}
