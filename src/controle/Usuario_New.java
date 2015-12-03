package controle;

import java.io.IOException;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Usuario;
import servico.ServicoFactory;
import servico.UsuarioServico;

/**
 * Servlet implementation class Usuario_New
 */
@WebServlet("/Usuario/New")
public class Usuario_New extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Usuario_New() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UsuarioServico us = ServicoFactory.criarUsuarioServico();
		
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		
        Usuario usr1 = new Usuario(null, nome,"000", "34-123", email,  senha);
        us.inserirAtualizar(usr1);		
		response.getWriter().append("OK");
		System.out.println("OK");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
