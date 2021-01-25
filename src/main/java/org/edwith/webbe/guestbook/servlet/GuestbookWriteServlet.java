package org.edwith.webbe.guestbook.servlet;

import javax.servlet.RequestDispatcher;
import org.edwith.webbe.guestbook.dao.GuestbookDao;
import org.edwith.webbe.guestbook.dto.Guestbook;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/guestbooks/write")
public class GuestbookWriteServlet extends HttpServlet {
    private final GuestbookDao guestbookDao = new GuestbookDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        final String name = request.getParameter("name");
        final String content = request.getParameter("content");
        guestbookDao.addGuestbook(new Guestbook(name, content));

        response.sendRedirect("/guestbooks");
    }

}
