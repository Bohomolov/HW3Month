<%@ page import="java.io.BufferedReader" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

</head>
<body>
<%
    BufferedReader bufferedReader = request.getReader();
    String data = bufferedReader.readLine();
    if (data.equals("1234")){
        PrintWriter writer = response.getWriter();
        session.setAttribute("success", "www");
        writer.println("success");
        response.setStatus(HttpServletResponse.SC_OK);
        response.sendRedirect("mainpage.jsp");
    } else {
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
    }
%>
<samp>Success</samp>
</body>
</html>