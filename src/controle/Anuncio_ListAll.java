package controle;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.LinkedHashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;

import dominio.Anuncio;
import servico.ServicoFactory;
@WebServlet("/Anuncios/ListAll")
public class Anuncio_ListAll extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Anuncio_ListAll() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.addHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Cache-Control", "private, no-store, no-cache, must-revalidate");        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        response.setDateHeader("Expires", 0); // Proxies.
        response.setCharacterEncoding("UTF-8");

        SimpleDateFormat dt1 = new SimpleDateFormat("dd/MM/yyyy");
        
		JSONArray json = new JSONArray();
			 
		List <Anuncio>	lista = ServicoFactory.criarAnuncioServico().buscarTodos();
			
	 	for (Anuncio x: lista){
			LinkedHashMap obj = new LinkedHashMap();
			obj.put("codigo", x.getCodAnuncio());
			obj.put("descricao", x.getDescricao());   
			obj.put("Valor", x.getVlrLocacao());
			obj.put("bairro", x.getBairro());
			obj.put("cidade", x.getCidade());
			obj.put("DataPublicacao", dt1.format(x.getDataIni()));
			obj.put("Anunciante", x.getUsuario().getNome());

			json.add(obj);	
	}	
	response.getWriter().append( json.toJSONString());
	}

}
