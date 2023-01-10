package sn.isi.controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sn.isi.dao.ComptesImpl;
import sn.isi.dao.RepositoryImpl;
import sn.isi.entities.Comptes;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(value = "/login" , name = "login")
public class LoginServlet extends HttpServlet {
	private static String VIEW_PATH = "/webapp/";
	private static final long serialVersionUID = 1L;
       
	private ComptesImpl Cdao ;
    private RepositoryImpl reposit;
    public void init() {
        Cdao = new ComptesImpl();

    }
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
    }

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String username = request.getParameter("username");
	        String password = request.getParameter("password");
	        System.out.println(username);
	       if (Cdao.validate(username, password)) {
	            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/home.jsp");
	            dispatcher.forward(request, response);
	        
	        } else {
	            //request.setAttribute("message", "login ou password incorrect");
	            RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
	            dispatcher.forward(request, response);
	        }
	}

}
