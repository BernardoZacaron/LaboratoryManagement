/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faculdade.poo.zetalab.util;

import faculdade.poo.zetalab.control.action.CallLoginPageAction;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Windows 10
 */
public class VerificadorLogin {
    public static void verificaLogado(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if(request.getSession().getAttribute("user")==null){
            request.setAttribute("msg", "Acesso não autorizado");
            new CallLoginPageAction().executa(request, response);
        }
    }
    
}
