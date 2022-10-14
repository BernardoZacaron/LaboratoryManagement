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
 * @author Windows 10
 */
public class CallCadUsuarioPageAction implements ICommanderAction {

    public CallCadUsuarioPageAction() {
    }

    @Override
    public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("pages/cadUsuario.jsp");
        rd.forward(request,response);
    }
    
}
