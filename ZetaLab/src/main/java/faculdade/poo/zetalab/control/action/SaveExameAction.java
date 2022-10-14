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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author Windows 10
 */
public class SaveExameAction implements ICommanderAction {

    public SaveExameAction() {
    }

    @Override
    public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        VerificadorLogin.verificaLogado(request, response);
        
        Exame exame = new Exame(0, request.getParameter("cpNome"), Double.parseDouble(request.getParameter("cpCusto")), 
                Integer.parseInt(request.getParameter("cpJejum")), Integer.parseInt(request.getParameter("cpPrazo")));
    
        try {
            new ExameDAO().inserir(exame);
        } catch (SQLException ex) {
            request.setAttribute("msg", "Houve um erro ao cadastrar o exame");
            new CallCadExamePageAction().executa(request, response);
        }
        new CallHomePageAction().executa(request, response);
    }
    
}
