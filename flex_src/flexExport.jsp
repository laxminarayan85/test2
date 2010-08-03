
<%

	response.setContentType("application/text");
	response.setHeader("content-disposition","attachment; filename="+request.getParameter("fileName")+".txt");


	out.clear();
	out.println(request.getParameter("data"));
	out.flush();

%>