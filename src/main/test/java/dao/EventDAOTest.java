package dao;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Event;

public class EventDAOTest {

    @Test
    public void testAddEvent() {

        EventDAO dao = new EventDAO();

        Event event = new Event();

        event.setEventName("Tech Conference");
        event.setEventDate("2026-05-20");
        event.setLocation("Kolkata");
        event.setDescription("Technology Event");

        boolean result = dao.addEvent(event);

        assertTrue(result);
    }
}