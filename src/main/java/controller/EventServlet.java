package controller;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.ServletException;

import dao.EventDAO;
import model.Event;

@javax.servlet.annotation.WebServlet("/addEvent")
public class EventServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String name = req.getParameter("name");
        String date = req.getParameter("date");
        String location = req.getParameter("location");
        String description = req.getParameter("description");

        Event event = new Event();
        event.setEventName(name);
        event.setEventDate(date);
        event.setLocation(location);
        event.setDescription(description);

        EventDAO dao = new EventDAO();

        if (dao.addEvent(event)) {
            resp.sendRedirect("events.jsp");
        } else {
            resp.getWriter().println("Event not added");
        }
    }
}