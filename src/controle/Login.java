package controle;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dominio.Usuario;
import servico.ServicoFactory;
@WebServlet("/Login")
public class Login extends HttpServlet {
private static final long serialVersionUID = 1L;

@Override
  public void doPost(HttpServletRequest request,
                     HttpServletResponse response) throws ServletException, IOException
  {
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    
    System.out.println(username);
    System.out.println(password);
    HttpSession session = request.getSession(true);

	List <Usuario>	lista = ServicoFactory.criarUsuarioServico().BuscarUsuarioPorEmailSenha(username, password);	  		
	System.out.println(lista.size());
	if (lista.size()>=1){
		session.setAttribute("username", username);
		session.setAttribute("password", password);
		System.out.println("Usuario Logado : " + username);
		response.getWriter().append("<script>window.location = '/LocarWeb/index.jsp';</script>");
	}
	else
	{
		response.getWriter().append("<script>window.location = '/LocarWeb/login.html';</script>");
	}
  }
}