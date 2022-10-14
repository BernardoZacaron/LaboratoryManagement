/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faculdade.poo.zetalab.control.action;

import faculdade.poo.zetalab.control.ICommanderAction;
import faculdade.poo.zetalab.dao.ExameDAO;
import faculdade.poo.zetalab.dao.PedidoDAO;
import faculdade.poo.zetalab.model.Pedido;
import faculdade.poo.zetalab.model.Usuario;
import faculdade.poo.zetalab.util.VerificadorLogin;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Aluno
 */
public class SavePedidoAction implements ICommanderAction {

    public SavePedidoAction() {
    }

    @Override
    public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        VerificadorLogin.verificaLogado(request, response);
        
        Pedido pedido = new Pedido(0, (Usuario)request.getSession().getAttribute("user"), null, null, false);
        
        try {
            pedido.setExame(new ExameDAO().findById(Integer.parseInt(request.getParameter("cpExame"))));
        } catch (SQLException ex) {
            request.setAttribute("msg", "exame não encontrado");
            new CallCadPedidoPageAction().executa(request, response);
        }
        
        try {
            new PedidoDAO().inserir(pedido);
        } catch (SQLException ex) {
            request.setAttribute("msg", "erro ao salvar pedido no banco");
            new CallCadPedidoPageAction().executa(request, response);
        }

        new CallListaMeusPedidosPageAction().executa(request, response);
    }
    
}
