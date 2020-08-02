<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:list>
	<acme:list-column code="authenticated.tool-record.form.label.title" path="title"  width="10%"/>
	<acme:list-column code="authenticated.tool-record.form.label.sector" path="sector"  width="25%"/>
</acme:list>