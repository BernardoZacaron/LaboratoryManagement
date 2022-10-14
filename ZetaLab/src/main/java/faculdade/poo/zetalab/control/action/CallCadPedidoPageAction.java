/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faculdade.poo.zetalab.control.action;

import faculdade.poo.zetalab.control.ICommanderAction;
import faculdade.poo.zetalab.dao.ExameDAO;
import faculdade.poo.zetalab.model.Exame;
import faculdade.poo.zetalab.util.VerificadorLogin;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Aluno
 */
public class CallCadPedidoPageAction implements ICommanderAction {

    public CallCadPedidoPageAction() {
    }

    @Override
    public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        VerificadorLogin.verificaLogado(request, response);
        
        List<Exame> exames = new ArrayList<>();
        
        try {
            exames = new ExameDAO().findAll();
        } catch (SQLException ex) {
            request.setAttribute("msg", "erro ao buscar exames no banco");
            new CallHomePageAction().executa(request, response);
        }
        request.setAttribute("exames", exames);
        
        RequestDispatcher rd = request.getRequestDispatcher("pages/master.jsp?pg=cadPedido");
        rd.forward(request,response);
    }
    
}
