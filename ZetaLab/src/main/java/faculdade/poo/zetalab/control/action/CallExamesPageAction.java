/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faculdade.poo.zetalab.control.action;

import faculdade.poo.zetalab.control.ICommanderAction;
import faculdade.poo.zetalab.dao.ExameDAO;
import faculdade.poo.zetalab.model.Exame;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Windows 10
 */
public class CallExamesPageAction implements ICommanderAction {

    public CallExamesPageAction() {
    }

    @Override
    public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Exame> exames = new ArrayList<>();
        
        try {
            exames = new ExameDAO().findAll();
        } catch (SQLException ex) {
            request.setAttribute("msg", "erro ao buscar exames no banco");
            new CallHomePageAction().executa(request, response);
        }
        
        if(!exames.isEmpty())
            request.setAttribute("exames", exames);
        
        RequestDispatcher rd = request.getRequestDispatcher("pages/master.jsp?pg=listaExames");
        rd.forward(request,response);
    }
    
}
