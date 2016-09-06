<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="/general/template_top.jsp" />

${usuario.id}<br>
${usuario.nombreCompleto}<br>
${usuario.usuario}<br>
${usuario.activo}

<c:import url="/general/template_bottom.jsp" />