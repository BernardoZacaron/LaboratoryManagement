/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faculdade.poo.zetalab.control.action;

import faculdade.poo.zetalab.control.ICommanderAction;
import faculdade.poo.zetalab.dao.LaboratorioDAO;
import faculdade.poo.zetalab.dao.UsuarioDAO;
import faculdade.poo.zetalab.model.Laboratorio;
import faculdade.poo.zetalab.model.Usuario;
import faculdade.poo.zetalab.util.VerificadorLogin;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author Windows 10
 */
public class SaveUsuarioAction implements ICommanderAction {

    public SaveUsuarioAction() {
    }

    @Override
    public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {        
        Usuario user = new Usuario(0, request.getParameter("cpNome"), request.getParameter("cpCpf"), request.getParameter("cpTelefone"), request.getParameter("cpLogin"), request.getParameter("cpSenha"), 1, request.getParameter("cpPlano")!=null, null);
    
        try {
            Laboratorio lab = new LaboratorioDAO().findById(0);
            user.setLaboratorio(lab);
        } catch (SQLException ex) {
            request.setAttribute("msg", "Houve um erro ao cadastrar o usuário");
            new CallLoginPageAction().executa(request, response);
        }
        
        try {
            new UsuarioDAO().inserir(user);
        } catch (SQLException ex) {
            request.setAttribute("msg", "Houve um erro ao cadastrar o usuário");
            new CallLoginPageAction().executa(request, response);
        }
        new CallLoginPageAction().executa(request, response);
    }
    
}
