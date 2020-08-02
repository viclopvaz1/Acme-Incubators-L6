<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:list readonly="true">
<acme:list-column code="anonymous.ruiz-bulletin.list.label.job" path="job" width="20%"/>
<acme:list-column code="anonymous.ruiz-bulletin.list.label.company" path="company" width="20%"/>
<acme:list-column code="anonymous.ruiz-bulletin.list.label.moment" path="moment" width="60%"/>

</acme:list>