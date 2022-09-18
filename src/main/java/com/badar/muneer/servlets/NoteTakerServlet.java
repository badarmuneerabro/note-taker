package com.badar.muneer.servlets;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import com.badar.muneer.helper.Connect;
import com.badar.muneer.model.Note;

/**
 * Servlet implementation class NoteTakerServlet
 */

@WebServlet
(
		name = "noteTakerSerlvet",
		urlPatterns = "/note"
)
public class NoteTakerServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String action = request.getParameter("action");
		if(action == null)
			action = "";
		switch(action)
		{
		case "add":
			addNote(request, response);
			break;
		case "view":
			viewAllNotes(request, response);
			break;
		case "delete":
			deleteNote(request, response);
			break;
		case "update":
			updateNoteForm(request, response);
			break;
		default:
			toHomePage(request, response);
			break;
			
		}
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		saveNoteToDatabase(request, response);
	}
	
	private void toHomePage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		request.getRequestDispatcher("/WEB-INF/jsp/view/home.jsp").forward(request, response);
	}
	
	private void addNote(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		request.getRequestDispatcher("/WEB-INF/jsp/view/addNote.jsp").forward(request, response);
	}
	
	private void saveNoteToDatabase(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		Session session = Connect.getFactory().openSession();
		session.beginTransaction();
		Note note = new Note();
		note.setTitle(title);
		note.setContent(content);
		note.setAddedDate(new Date());
		synchronized(this)
		{
			session.save(note); // saving the note object.
			session.getTransaction().commit();
		}
		session.close();
		viewAllNotes(request, response);
	}
	
	private void viewAllNotes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		Session session = Connect.getFactory().openSession();
		List<Note> notes = session.createQuery("from Note").list();
		request.setAttribute("allNotes", notes);
		request.getRequestDispatcher("/WEB-INF/jsp/view/allNotes.jsp").forward(request, response);
	}
	
	private void deleteNote(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		int id = Integer.parseInt(request.getParameter("id").trim());
		Session session = Connect.getFactory().openSession();
		session.beginTransaction();
		
		Query query = session.createQuery("delete from Note where id=:id");
		query.setParameter("id", id);
		synchronized(this)
		{
			query.executeUpdate();
			session.getTransaction().commit();
		}
		viewAllNotes(request, response);
	}
	
	private void updateNoteForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		System.out.println("Inside the update method.");
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
