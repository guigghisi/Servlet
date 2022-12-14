package controller;

import java.io.BufferedReader;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import model.PessoaModel;
import service.PessoaService;


@WebServlet("/hello")
public class hello extends HttpServlet {
	
	private PessoaService service = new PessoaService();
	private Gson gson = new Gson();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String json= "";
		if (id != null) {
			json = gson.toJson(this.service.getPessoa(Long.parseLong(id)));
		}else {
			json = gson.toJson(this.service.getPessoas());
			
		}
		response.getWriter().append(json);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BufferedReader reader = request.getReader();
		PessoaModel pessoa = gson.fromJson(reader, PessoaModel.class);
		service.addPessoa(pessoa);
		doGet(request, response);
	}

}
