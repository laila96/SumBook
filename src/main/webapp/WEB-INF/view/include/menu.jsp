<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>

<s:url var="url_logout" value="/logout"/>

<c:if test="${sessionScope.userId==null}">
    <%-- User is not yet logged in : Guest Menu --%>
    <s:url var="url_reg_form" value="/reg_form"/>
    <s:url var="url_index" value="/index"/>
     <s:url var="url_home" value="/home"/>
      <s:url var="url_sum" value="/sum"/>
     <s:url var="url_about" value="/about"/>
      <s:url var="url_help" value="/help"/>
    <a href="${url_home}">Home</a> | <a href="${url_sum}">Summary</a> | <a href="${url_index}">Log In</a> | <a href="${url_reg_form}">Sign In</a> | <a href="${url_about}">About</a> | <a href="${url_help}">Help</a>   
</c:if>
<c:if test="${sessionScope.userId!=null && sessionScope.role == 1}">
    <%-- Admin is logged in : Admin Menu --%> 
     <s:url var="url_home" value="/home"/> 
    <a href="${url_home}">Home</a> | <a href="<s:url value="/admin/users"/>">User List</a> | <a href="${url_logout}">Logout</a>  
</c:if>
<c:if test="${sessionScope.userId!=null && sessionScope.role == 2}">
    <%-- General User is logged in : User Menu --%>
    <s:url var="url_uhome" value="/user/dashboard"/>
    <s:url var="url_cform" value="/user/contact_form"/>
    <s:url var="url_clist" value="/user/clist"/>
    <a href="${url_uhome}">Home</a> | <a href="${url_cform}">Add Summary</a> | <a href="${url_clist}">Summary List</a> | <a href="${url_logout}">Logout</a>  
</c:if>



