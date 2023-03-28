<%@page import="java.sql.SQLException"%>
<%@page import="dao.StudentDAO"%>
<%@page import="beans.Student"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="org.json.simple.JSONArray"%>
<%

    JSONArray list = new JSONArray();
    JSONObject obj = new JSONObject();

    try {
        String name = request.getParameter("stdName");
        String course = request.getParameter("course");
        String fee = request.getParameter("fee");

        Student tempStudent = new Student(name, course, fee);
        StudentDAO.insertStudent(tempStudent);
        obj.put("success", "inserted");
    } catch (SQLException e) {
        obj.put("error", e.getMessage());
    }

    list.add(obj);
    out.println(list.toJSONString());
    out.flush();
%>