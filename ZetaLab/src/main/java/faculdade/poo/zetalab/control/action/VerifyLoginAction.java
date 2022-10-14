/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faculdade.poo.zetalab.control.action;

import faculdade.poo.zetalab.control.ICommanderAction;
import faculdade.poo.zetalab.dao.UsuarioDAO;
import faculdade.poo.zetalab.model.Usuario;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
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
public class VerifyLoginAction implements ICommanderAction {

    @Override
    public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String login = request.getParameter("cpLogin");
            String senha = request.getParameter("cpSenha");
            
            Usuario user = new UsuarioDAO().verificarLogin(login, senha);
            
            if(user == null){
                request.setAttribute("msg", "Login ou senha incorreta");
                new CallLoginPageAction().executa(request, response);
            }else{
                request.getSession().setAttribute("user", user);
                new CallHomePageAction().executa(request, response);
            }
        } catch (SQLException ex) {
            new CallErroPageAction("Não foi possível conectar ou consultar o banco de dados").executa(request, response);
        }
    }
    
}
