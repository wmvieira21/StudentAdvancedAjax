<%@page import="java.util.List"%>
<%@page import="java.sql.SQLException"%>
<%@page import="dao.StudentDAO"%>
<%@page import="beans.Student"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="org.json.simple.JSONArray"%>
<%
    JSONArray list = new JSONArray();
    JSONObject error = new JSONObject();
    List<Student> listStudents = null;

    try {
        listStudents = StudentDAO.getStudents();

        for (Student student : listStudents) {
            JSONObject obj = new JSONObject();
            obj.put("idBase", student.getId());
            obj.put("nameBase", student.getName());
            obj.put("courseBase", student.getCourse());
            obj.put("feeBase", student.getFee());
            list.add(obj);
        }
    } catch (SQLException e) {
        error.put("error", e.getMessage());
        list.add(error);
    }
    session.setAttribute("listStudents", listStudents);
    out.println(list.toJSONString());
    out.flush();
%>