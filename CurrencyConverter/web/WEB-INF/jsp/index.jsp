<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Currency Converter</title>
    </head>

    <body>
        <form action="exchangevalue" method="POST">
            <p>Welcome to Currency Converter Page!</p>
            <p><i>Pick from currency</i><br/>
                <select name="fromCode">
                    <c:forEach var="currency" items="${currencies}">
                        <option value="${currency.code}">${currency.name}</option>                
                    </c:forEach>
                </select>
            </p>
            <p><i>Amount of from currency</i><br/>
                <input name="fromAmount" type="text" />
            </p>

            <p><i>Pick to currency</i><br/>
                <select name="toCode">
                    <c:forEach var="currency" items="${currencies}">
                        <option value="${currency.code}">${currency.name}</option>                
                    </c:forEach>
                </select>
            </p>        
            <p><b><i>Conversion result</i></b><br/>
                <span>${toAmount}</span>
            </p>

            <input type="submit" value="Convert"/>
        </form>
    </body>
</html>
