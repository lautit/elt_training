<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="/general/template_top.jsp" />

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

	<form:form method="post" modelAttribute="usuarioForm" action="guardarusuario.html">
		<form:input path="id" type="hidden" />
		<form:input path="nombreCompleto" type="text" />
		<form:input path="usuario" type="text" />
		<form:input path="password" type="password" />
		<form:checkbox path="activo"/>
		<input type="submit" value="Guardar">
	</form:form>
	

<c:import url="/general/template_bottom.jsp" />