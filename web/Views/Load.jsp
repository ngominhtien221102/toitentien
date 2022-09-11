<%-- 
    Document   : Load
    Created on : May 27, 2022, 1:11:06 PM
    Author     : Lenovo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Model.*"%>
<%@page import="DAL.DAO"%>
<%@page import="java.util.*"%>
<%@taglib prefix ="c" uri ="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            table, td{
                border: 1px solid black;
                border-collapse: collapse;
            }
        </style>
    </head>
    <body>

        <% DAO dao =(DAO)request.getAttribute("DAO");%>
        <%= request.getAttribute("Menu")%>
        <div> New Jsp : ${requestScope.menu}</div>
        <table>
            <c:forEach items="${requestScope.DAO.stdList}" var="st">
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
        <table>
            <%for (Student st : dao.getStdList()){%>

            <td><%=st.getId()%></td>
            <td><%=st.getName()%></td>
            <td><%=dao.getDepartHm().get(st.getDepartId()).getName() %></td>
            <td><%=(st.isGender()?"Male": "Female")%></td>
            <td><%=st.getGPA()%></td>
            <td><%=st.getAdd()%></td>
            <td><a href = './Update?type=0&id=<%=st.getId()%>'>Delete</a></td>
            <td><a href = './Update?type=1&id=<%=st.getId()%>'>Update</a></td>
        </tr>
        <%}%>
    </table>
    <% 
    Object obj = request.getAttribute("UpdateId");
    String id = "";
    String name = "";
    String departId = "SE";
    boolean gender = true;
    String gpa = "";
    String add = "";
    if(obj != null)
    {
        id = (obj+"").trim();
        if(id.length() != 0 )
        {
                for(Student st:dao.getStdList()){
                if (st.getId().equals(id)) {
                        name = st.getName();
                        departId = st.getDepartId();
                        gender = st.isGender();
                        gpa = st.getGPA() + "";
                        add = st.getAdd();
                        break;
                }
            }
        }
    }
    %>

    <br/><br/>
    <form action='loadDbSe1625' method ='post'>
        Id: <input type ='text' name ='id' value='<%=id%>'> <br/>
        Name: <input type ='text' name ='name' value='<%=name%>'> <br/>
        Department: <select name = 'departId'>
            <%for (Map.Entry<String, Department> en : dao.getDepartHm().entrySet()) {
            String key = en.getKey();
            Department val = en.getValue();%>
            <option value ='<%=key%>'
                    <%=(key.equals(departId)?"selected":"")%>>
                <%=val.getName()%>
            </option>
            <%}%>

            Gender: <input type="radio" name ='gender' value='m'
                           <%=(gender?"checked":"")%>>Male
            <input type="radio" name ='gender' value ='f'
                   <%=(gender?"":"checked")%> > Female <br/> 
            GPA: <input type ='text' name ='gpa' value='<%=gpa%>'> <br/>
            ADD: <input type ='text' name ='add' value='<%=add%>'> <br/>
            <input type ='submit' value ='Insert/Update'>
            </form>
            </body>
            </html>

