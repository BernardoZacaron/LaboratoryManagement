/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faculdade.poo.zetalab.control.action;

import faculdade.poo.zetalab.control.ICommanderAction;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Aluno
 */
public class CallErroPageAction implements ICommanderAction{
    
    private String error;

    public CallErroPageAction(String error) {
        this.error = error;
    }
        
    @Override
    public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("pages/master.jsp?pg=error");
        
        request.setAttribute("msgError", error);
        
        rd.forward(request,response);
    }
}
