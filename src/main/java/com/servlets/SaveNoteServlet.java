package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entities.Note;
import com.helper.FactoryProvider;

/**
 * Servlet implementation class SaveNoteServlet
 */
public class SaveNoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			String Title = request.getParameter("title");
			String Content = request.getParameter("content");
			
			Note note = new Note(Title,Content,new Date());
			
			System.out.println(note.getId()+" "+note.getContent());
			
			
			//hibernate:save()
			Session s= FactoryProvider.getFactory().openSession();
			Transaction tx = s.beginTransaction();
			
			
			
			
			
			s.save(note);
			
			tx.commit();
			s.close();
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("<h1 style='text-align:center;'>Note is added succesfully</h1>");
			out.println("<h1 style='text-align:center;'><a href='all_notes.jsp'>View notes</h1>");
			
			
			
		}catch(Exception e) {
			
			
		}
			
		}
		
	}


