<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:list readonly="true">
<acme:list-column code="anonymous.cordon-bulletin.list.label.author" path="author" width="20%"/>
<acme:list-column code="anonymous.cordon-bulletin.list.label.company" path="company" width="20%"/>
<acme:list-column code="anonymous.cordon-bulletin.list.label.description" path="description" width="60%"/>

</acme:list>