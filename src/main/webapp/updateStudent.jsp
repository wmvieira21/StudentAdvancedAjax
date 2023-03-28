<%@page import="dao.StudentDAO"%>
<%@page import="java.sql.SQLException"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="org.json.simple.JSONArray"%>
<%@page import="java.util.List"%>
<%@page import="beans.Student"%>
<%

    JSONArray jsonArray = new JSONArray();
    JSONObject error = new JSONObject();
    JSONObject obj = new JSONObject();

    try {
        Integer id = Integer.valueOf(request.getParameter("id"));
        String name = request.getParameter("stdName");
        String course = request.getParameter("course");
        String fee = request.getParameter("fee");

        Student temStudent = new Student(id, name, course, fee);
        StudentDAO.updateStudent(temStudent);

        obj.put("success", "updated");
        jsonArray.add(obj);

    } catch (Exception e) {
        error.put("error", e.getMessage());
        jsonArray.add(error);
    }

    out.println(jsonArray.toJSONString());
    out.flush();
%>