package com.badar.muneer.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import com.badar.muneer.helper.Connect;
import com.badar.muneer.model.Note;

/**
 * Servlet implementation class SearchServlet
 */
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int id = Integer.parseInt(request.getParameter("id"));
		Session session = Connect.getFactory().openSession();
		session.beginTransaction();
		Note note = session.get(Note.class, id);
		session.getTransaction().commit();
		session.close();
		request.setAttribute("note", note);
		request.getRequestDispatcher("/WEB-INF/jsp/view/updateNote.jsp").forward(request, response);
	}

}
