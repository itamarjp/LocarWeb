package controle;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;

import dominio.Usuario;
import servico.ServicoFactory;

/**
 * Servlet implementation class test
 */
@WebServlet("/test")
public class test extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public test() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		JSONArray usuarios = new JSONArray();
		
		
     
		List <Usuario>	lista = ServicoFactory.criarUsuarioServico().buscarTodos();	  		
		for (Usuario x: lista){
			LinkedHashMap obj = new LinkedHashMap();
		
			
			
			obj.put("codUsuario", x.getCodUsuario());   
			obj.put("nome", x.getNome());
			obj.put("cpf", x.getCpf());
			obj.put("celular", x.getCelular());
			obj.put("email", x.getEmail());
			
			
			
			
		 
			usuarios.add(obj);	
			//usuarios.addAll(lista);
	}
			
	response.getWriter().append( usuarios.toJSONString());
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
