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
        List<Student> listSession = (List<Student>) session.getAttribute("listStudents");
        
        for (Student element : listSession) {
            if (element.getId().equals(id)) {
                obj.put("idBase", element.getId());
                obj.put("nameBase", element.getName());
                obj.put("courseBase", element.getCourse());
                obj.put("feeBase", element.getFee());
                jsonArray.add(obj);
                break;
            }
        }
        
    } catch (Exception e) {
        error.put("error", e.getMessage());
        jsonArray.add(error);
    }

    out.println(jsonArray.toJSONString());
    out.flush();
%>