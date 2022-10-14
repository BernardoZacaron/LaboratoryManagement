/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faculdade.poo.zetalab.control;

import faculdade.poo.zetalab.control.action.CallVisualizarPedidoPageAction;
import faculdade.poo.zetalab.control.action.CallRelatorioPageAction;
import faculdade.poo.zetalab.control.action.CancelarPedidoAction;
import faculdade.poo.zetalab.control.action.SavePedidoAction;
import faculdade.poo.zetalab.control.action.LogoutAction;
import faculdade.poo.zetalab.control.action.CallCadPedidoPageAction;
import faculdade.poo.zetalab.control.action.CallCadUsuarioPageAction;
import faculdade.poo.zetalab.control.action.CallCadExamePageAction;
import faculdade.poo.zetalab.control.action.CallEntregarPedidoPageAction;
import faculdade.poo.zetalab.control.action.CallExamesPageAction;
import faculdade.poo.zetalab.control.action.CallErroPageAction;
import faculdade.poo.zetalab.control.action.CallHomePageAction;
import faculdade.poo.zetalab.control.action.CallListaMeusPedidosPageAction;
import faculdade.poo.zetalab.control.action.CallListaTodosPedidosPageAction;
import faculdade.poo.zetalab.control.action.CallLoginPageAction;
import faculdade.poo.zetalab.control.action.SaveEntregaPedidoAction;
import faculdade.poo.zetalab.control.action.SaveUsuarioAction;
import faculdade.poo.zetalab.control.action.SaveExameAction;
import faculdade.poo.zetalab.control.action.VerifyLoginAction;
import java.io.IOException;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Control", urlPatterns = {"/control"})
public class ControlServlet extends HttpServlet {
    
    static final HashMap<String, ICommanderAction> comandos = new HashMap<>();

    public ControlServlet() {
        if(comandos.isEmpty()){
            comandos.put(null, new CallLoginPageAction());
            comandos.put("login", new CallLoginPageAction());
            comandos.put("home", new CallHomePageAction());
            comandos.put("verificarLogin", new VerifyLoginAction()); 
            comandos.put("listaExames", new CallExamesPageAction());
            comandos.put("addExame", new CallCadExamePageAction());
            comandos.put("saveExame", new SaveExameAction());
            comandos.put("addUsuario", new CallCadUsuarioPageAction());
            comandos.put("saveCliente", new SaveUsuarioAction());
            comandos.put("addPedido", new CallCadPedidoPageAction());
            comandos.put("savePedido", new SavePedidoAction());
            comandos.put("logout", new LogoutAction());
            comandos.put("meusPedidos", new CallListaMeusPedidosPageAction());
            comandos.put("todosPedidos", new CallListaTodosPedidosPageAction());
            comandos.put("visualizarPedido", new CallVisualizarPedidoPageAction());
            comandos.put("cancelarPedido", new CancelarPedidoAction());
            comandos.put("entregarPedido", new CallEntregarPedidoPageAction());
            comandos.put("finalizarPedido", new SaveEntregaPedidoAction());
            comandos.put("relatorio", new CallRelatorioPageAction());
        }
    }
    
    static{
        comandos.put(null, new CallLoginPageAction());
        comandos.put("login", new CallLoginPageAction());
        comandos.put("home", new CallHomePageAction());
        comandos.put("verificarLogin", new VerifyLoginAction());
        comandos.put("listaExames", new CallExamesPageAction());
        comandos.put("addExame", new CallCadExamePageAction());
        comandos.put("addUsuario", new CallCadUsuarioPageAction());
        comandos.put("saveCliente", new SaveUsuarioAction());
        comandos.put("saveExame", new SaveExameAction());
        comandos.put("addPedido", new CallCadPedidoPageAction());
        comandos.put("savePedido", new SavePedidoAction());
        comandos.put("logout", new LogoutAction());
        comandos.put("meusPedidos", new CallListaMeusPedidosPageAction());
        comandos.put("todosPedidos", new CallListaTodosPedidosPageAction());
        comandos.put("visualizarPedido", new CallVisualizarPedidoPageAction());
        comandos.put("cancelarPedido", new CancelarPedidoAction());
        comandos.put("entregarPedido", new CallEntregarPedidoPageAction());
        comandos.put("finalizarPedido", new SaveEntregaPedidoAction());
        comandos.put("relatorio", new CallRelatorioPageAction());
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String ac = request.getParameter("ac");
        
        try{
        comandos.get(ac).executa(request, response);
        }catch(Exception e){
            new CallErroPageAction("Ocorreu um erro interno no sistema. "+e.getMessage()).executa(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
