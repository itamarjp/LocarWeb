package controle;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Usuario;
import servico.ServicoFactory;
import servico.UsuarioServico;

/**
 * Servlet implementation class excluir
 */
@WebServlet(urlPatterns={"/Usuario/Remove/*"} ,  name="/excluir"		)
public class Usuario_Remove extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Usuario_Remove() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String param = request.getPathInfo();
		UsuarioServico us = ServicoFactory.criarUsuarioServico();
		param = param.substring(1);
		System.out.println(param);
		Usuario x = us.buscar(Integer.parseInt(param));
		System.out.println("Removido..: "+ x.getNome());
		us.excluir(x);
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
