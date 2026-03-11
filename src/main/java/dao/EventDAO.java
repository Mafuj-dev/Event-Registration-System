package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Event;
import util.DBConnection;

public class EventDAO {

    Connection con;

    public EventDAO() {
        con = DBConnection.getConnection();
    }

    // Add Event
    public boolean addEvent(Event event) {

        boolean status = false;

        try {

            String sql = "INSERT INTO events(event_name,event_date,event_location,description) VALUES(?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, event.getEventName());
            ps.setString(2, event.getEventDate());
            ps.setString(3, event.getLocation());
            ps.setString(4, event.getDescription());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                status = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    // Get All Events
    public List<Event> getAllEvents() {

        List<Event> list = new ArrayList<>();

        try {

            String sql = "SELECT * FROM events";

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Event e = new Event();

                e.setEventId(rs.getInt("event_id"));
                e.setEventName(rs.getString("event_name"));
                e.setEventDate(rs.getString("event_date"));
                e.setLocation(rs.getString("event_location"));
                e.setDescription(rs.getString("description"));

                list.add(e);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    // Delete Event
    public boolean deleteEvent(int eventId) {

        boolean status = false;

        try {

            String sql = "DELETE FROM events WHERE event_id=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, eventId);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                status = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }
}