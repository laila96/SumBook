<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Summary Form  </title>
        <s:url var="url_css" value="/static/css/style.css"/>
        <link href="${url_css}" rel="stylesheet" type="text/css"/>
    </head>
    <s:url var="url_bg" value="/static/images/bg.jpg"/>
    <body background="${url_bg}">
        <table border="1" width="80%" align="center">
            <tr>
                <td height="80px">
                    <%-- Header --%>
                    <jsp:include page="include/header.jsp"/>
                </td>
            </tr>
            <tr>
                <td height="25px">
                    <%-- Menu --%>
                    <jsp:include page="include/menu.jsp"/>
                </td>
            </tr>
            <tr>
                <td height="350px" valign="top">
                    <%-- Page Content Area--%>
                    <h3>Summary Form</h3>
                    <c:if test="${err!=null}">
                        <p class="error">${err}</p>
                    </c:if>                  
                    <s:url var="url_csave"  value="/user/save_contact"/>
                    <f:form action="${url_csave}" modelAttribute="command">
                        <table border="3"  height="250px"  >
                            <tr>
                                <td>Book title</td>
                                <td  ><f:input  path="name" /> </td>
                            </tr>
                            <tr>
                                <td>Author</td>
                                <td><f:input path="author" /> </td>
                            </tr>
                            <tr>
                              <td>Category</td>
                                <td><f:input path="category" /> </td>
                            </tr> 
                            <tr>
                                <td>Summary</td>
                                <td><f:textarea rows="13" cols="50" path="summary" /> </td>
                            </tr>
                            <tr>
                                <td>Photo</td>
                               <c:if test="${c.photo!=null}">
				              <td><image src="CatPhoto?idCat=${c.photo}"/></td>
					          </c:if>			
					         <td><input type="file" name="file" /></td>
                            </tr>
                            <tr>                                
                                <td colspan="2" align="right">
                                    <button>Save</button>                                
                                </td>
                            </tr>
                        </table>
                    </f:form>
                </td>
            </tr>
            <tr>
                <td height="25px">
                    <%-- Footer --%>
                    <jsp:include page="include/footer.jsp"/>
                </td>
            </tr>
        </table>
       
    </body>
</html>
