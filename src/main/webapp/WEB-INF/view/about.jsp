
  <%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>About us </title>
 <s:url var="url_css" value="/static/css/style.css"/>
 <link href="${url_css}" rel="stylesheet" type="text/css"/>
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
                    <h3 class="success"> Why SumBook !! </h3>
                    <h4 >Often we find ourselves in a situation where we read a book <br/> 
                    and we liked the story of this book or even the way in which <br/>
                    it was written, and we want to reward <br/> the author for the wonderful
                    moments <br/> that we lived in. through this book, but<br/> we do not know how!
                    <br/>SumBook is the solution, it is a way to reward <br/> the author by proposing
                    a summary and thus<br/> encouraging others to read this book.
                    </h4>
                   </td>
            </tr>
            <tr>
                <td class="successs" height="25px">
                    <%-- Footer --%>
                    <jsp:include page="include/footer.jsp"/>
                </td>
            </tr>
        </table>
    </body>
</head>
<body>

</body>
</html>