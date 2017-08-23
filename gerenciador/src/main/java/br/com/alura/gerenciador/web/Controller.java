package br.com.alura.gerenciador.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/executa")
public class Controller extends HttpServlet {

	private static final long serialVersionUID = 4985869016058892850L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// qual tarefa eu quero executar??
		String tarefa = req.getParameter("tarefa");
		if (tarefa == null)
			throw new IllegalArgumentException("Você esqueceu de passar a tarefa");

		try {
			String nomeDaClasse = "br.com.alura.gerenciador.web." + tarefa;
			Class<?> type = Class.forName(nomeDaClasse);
			Tarefa instancia = (Tarefa) type.newInstance();
			String pagina = instancia.executa(req, resp);
			
			// para qual pagina desejo ir??
			RequestDispatcher requestDispatcher = req.getRequestDispatcher(pagina);
			requestDispatcher.forward(req, resp);
			
		} catch (Exception e) {
			throw new ServletException(e);
		}

	}

}
