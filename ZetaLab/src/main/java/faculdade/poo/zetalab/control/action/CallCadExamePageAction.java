/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faculdade.poo.zetalab.control.action;

import faculdade.poo.zetalab.control.ICommanderAction;
import faculdade.poo.zetalab.util.VerificadorLogin;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Aluno
 */
public class CallCadExamePageAction implements ICommanderAction{
    
    @Override
    public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        VerificadorLogin.verificaLogado(request, response);
        
        RequestDispatcher rd = request.getRequestDispatcher("pages/master.jsp?pg=cadExame");
        rd.forward(request,response);
    }
}
