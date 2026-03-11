<%@ page import="java.util.*,dao.EventDAO,model.Event" %>

<html>
<body>

<h2>Available Events</h2>

<table border="1">

<tr>
<th>ID</th>
<th>Name</th>
<th>Date</th>
<th>Location</th>
<th>Description</th>
</tr>

<%
EventDAO dao = new EventDAO();
List<Event> events = dao.getAllEvents();

for(Event e : events){
%>

<tr>
<td><%=e.getEventId()%></td>
<td><%=e.getEventName()%></td>
<td><%=e.getEventDate()%></td>
<td><%=e.getLocation()%></td>
<td><%=e.getDescription()%></td>
</tr>

<%
}
%>

</table>

</body>
</html>