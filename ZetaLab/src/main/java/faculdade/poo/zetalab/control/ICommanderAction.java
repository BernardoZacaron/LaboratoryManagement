package faculdade.poo.zetalab.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ICommanderAction {
    public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
