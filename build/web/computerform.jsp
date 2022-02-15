<%--
    Document   : computerform
    Created on : Feb 10, 2022, 1:30:39 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="fu.ex.dtos.RoomDTO"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create a new computer</title>
    </head>
    <body>
        <h1>add new computer information</h1>
        <form action="" method="POST">
            <table border="1">
                <tr>
                    <td>ID</td>
                    <td>: <input type="text" name="txtID" value=""/></td>
                </tr>
                <tr>
                    <td>CPU</td>
                    <td>: <input type="text" name="txtCPU" value=""</td>
                </tr>
                <tr>
                    <td>HardDisk</td>
                    <td>: <input type="text" name="txtHardDisk" value=""</td>
                </tr>
                <tr>
                    <td>RAM</td>
                    <td>: <input type="text" name="txtRAM" value=""</td>
                </tr>
                <tr>
                    <td>VGA</td>
                    <td>: <input type="text" name="txtVGA" value=""</td>
                </tr>
                <tr>
                    <td>Monitor</td>
                    <td>: <input type="text" name="txtMonitor" value=""</td>
                </tr>
                <tr>
                    <td>Room</td>
                    <td><select name="cboRoom">
                            <%
                                ArrayList<RoomDTO> lstRooms = new ArrayList<RoomDTO>();
                                lstRooms = (ArrayList<RoomDTO>) request.getAttribute("listRooms");
                                for (RoomDTO dt : lstRooms) {%>

                            <option><%= dt.getId()%>-<%= dt.getName()%></option>
                            <%}
                            %>
                        </select></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" value="Create"/></td>

                </tr>
            </table>
        </form>
    </body>
</html>
