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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author web
 */
public class SaveEntregaPedidoAction implements ICommanderAction {

    public SaveEntregaPedidoAction() {
    }

    @Override
    public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        VerificadorLogin.verificaLogado(request, response);
        
        PedidoDAO pd = new PedidoDAO();
        Pedido pedido = null;
        
        try {
            pedido = pd.findById(Integer.parseInt(request.getParameter("id")));
        } catch (SQLException ex) {
            request.setAttribute("msg", "pedido não encontrado");
            new CallListaTodosPedidosPageAction().executa(request, response);
        }
        
        try {
            pedido.setResultado(request.getParameter("cpResultado"));
            pedido.setEntregue(true);
            pd.alterar(pedido);
            
            request.setAttribute("msg", "Resultado atribuido com sucesso!");
        } catch (SQLException ex) {
            request.setAttribute("msg", "Não foi possível alterar o pedido");
        }

        new CallListaTodosPedidosPageAction().executa(request, response);
    }
}
