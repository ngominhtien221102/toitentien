<%-- 
    Document   : LoadPage
    Created on : Jun 6, 2022, 1:32:31 PM
    Author     : Lenovo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri= "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <table>
            <c:forEach items="${requestScope.dao.stdList}" var="st" begin="${CP.begin}"
                       end="${CP.end}">
                <tr>
                    <td>${st.id}</td>
                    <td>${st.name}</td>
                    <td>${st.departId}</td>
                    <td>${st.gender}</td>
                    <td>${st.GPA}</td>
                    <td>${st.add}</td>
                </tr>
            </c:forEach>
            <tr>
        </table>
        <div>
            <c:if test ="${CP.cp!=0}">
                <span><a href ="LoadPage?currentPage=0"> Home</a></span>
                <span><a href ="LoadPage?currentPage=${CP.cp-1}"> Pre</a></span>
            </c:if>
            <c:forEach begin = "${0}" end ="${CP.np-1}" var="i">
                <span><a href = "LoadPage?currentPage=${i}">${i+1}</a></span>
                </c:forEach>
                <c:if test = "${CP.cp!=CP.np-1}">
                <span><a href ="LoadPage?currentPage=${CP.cp+1}"> Next</a></span>
                <span><a href ="LoadPage?currentPage=${CP.np-1}"> End</a></span>
            </c:if>

        </div>

        <div>
            <form action ="LoadPage" method ="post">
                <c:if test="${CP.cp!=0}">
                    <input type="submit" name="home" value="Home">
                    <input type="submit" name="pre" value="Pre">
                </c:if>
                <c:forEach begin="${CP.pageStart}" end = "${CP.pageEnd}" var = "i">
                    <span> <input type="submit" name ="btn${i}" value ="${i+1}"></span>
                    </c:forEach>
                    <c:if test="${CP.cp!= CP.np-1}">
                    <input type="submit" name="next" value="Next">
                    <input type="submit" name="end" value="End">   
                </c:if>
                <input type="text" hidden name="cp" value="${CP.cp}">
                <input type="text" hidden name="np" value="${CP.np}">
                <select name="nrpp">
                    <c:forEach items="${CP.arrNrpp}" var="i" varStatus="loop">
                        <option value="${loop.index}"
                                <c:if test="${loop.index == sessionScope.nrpp}">
                                    selected
                                </c:if>    
                                >${i}
                        </option>
                    </c:forEach>
                </select>
            </form>
        </div>  
    </body>
</html>
