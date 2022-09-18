package com.badar.muneer.servlets;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import com.badar.muneer.helper.Connect;
import com.badar.muneer.model.Note;

/**
 * Servlet implementation class UpdateNoteServlet
 */
public class UpdateNoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateNoteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int id = Integer.parseInt(request.getParameter("id").trim());
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		Session session = Connect.getFactory().openSession();
		session.beginTransaction();
		Note note = session.get(Note.class, id);
		note.setTitle(title);
		note.setContent(content);
		note.setAddedDate(new Date());
		session.getTransaction().commit();
		session.close();
		
		request.getRequestDispatcher("/WEB-INF/jsp/view/allNotes.jsp").forward(request, response);
	}

}
