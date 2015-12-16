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
@WebServlet("/Usuario/ListAll")
public class Usuario_ListAll extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Usuario_ListAll() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.addHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Cache-Control", "private, no-store, no-cache, must-revalidate");        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        response.setDateHeader("Expires", 0); // Proxies.

		JSONArray json = new JSONArray();
			 
		List <Usuario>	lista = ServicoFactory.criarUsuarioServico().buscarTodos();	  		
		for (Usuario x: lista){
			LinkedHashMap obj = new LinkedHashMap();
		
			obj.put("codUsuario", x.getCodUsuario());   
			obj.put("nome", x.getNome());
			obj.put("cpf", x.getCpf());
			obj.put("celular", x.getCelular());
			obj.put("email", x.getEmail());
			
			json.add(obj);	
	}
			
	response.getWriter().append( json.toJSONString());
	
	}

}
