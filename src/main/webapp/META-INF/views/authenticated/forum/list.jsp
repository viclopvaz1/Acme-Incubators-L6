<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:list>
	<acme:list-column code="authenticated.forum.form.label.title" path="title" width="20%"/>
	<acme:list-column code="authenticated.forum.form.label.ticker" path="investmentRound.ticker" width="60%"/>
</acme:list>