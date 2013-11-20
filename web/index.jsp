<%-- 
    Document   : index
    Created on : Nov 19, 2013, 9:34:48 PM
    Author     : HugoCésar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Accounts</title>
    </head>
    <body>
        <h1>Account info</h1>
        <form action="controller" method="get">
            Id:<input type="text" name="id"/><br/>
            <input type="submit" value="read"/>
            
        </form>
        
                <h1>Account update</h1>
        <form action="controller" method="post">
            Id:<input type="text" name="id" value="${account.id}"/><br/>
            Balance:<input type="text" name="balance" value="${account.balance}"/><br/>
            Address:<input type="text" name="address" value="${account.address}"/><br/>
            <input type="submit" value="update"/>
            
        </form>
    </body>
</html>
