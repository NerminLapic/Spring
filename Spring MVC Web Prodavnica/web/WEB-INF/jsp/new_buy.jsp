<%-- 
    Document   : new_buy
    Created on : Jul 10, 2017, 9:33:33 AM
    Author     : Nermin
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

       <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
       
        <title>PRODAJA Lapic store </title>
        
    </head>
    <body>
        <div class="container">
                
            <header class="header">

		<div id="logo">
			
                    <h1> LAPIC WEB STORE </h1>
		</div>

		<nav>
			<ul>
				<li><a href="/Spring_MVC_Web_Prodavnica/">HOME</a></li>
				<li><a href="/Spring_MVC_Web_Prodavnica/lista.htm">PROIZVODI</a></li>
				<li><a href="/Spring_MVC_Web_Prodavnica/lista_kupaca.htm">KUPCI</a></li>
				<li><a href="/Spring_MVC_Web_Prodavnica/new_buy.htm">PRODAJA</a></li>
 				

			</ul>	
		</nav>

            </header>
	
	<aside class="aside">

	</aside>

	<div class="main">
            
	<h3 id="naslov">Prodaja</h3>

         <form:form action="new_buy.htm" method="post" commandName="buy">
             <div class="field">
                <form:label path="buyNumber">Unesite broj kupovine:</form:label>
                <form:input path="buyNumber"/>
                <form:errors path="buyNumber" cssClass="error"></form:errors>
            </div>
            <div class="field">
                <form:label path="productId">Odabirite artikal:</form:label>
                <form:select path="productId">
                  <c:forEach items="${proizvodi}" var="proizvod">
                    <option value=${proizvod.key}>${proizvod.value}</option>
                  </c:forEach>  
                </form:select>
                <form:errors path="productId" cssClass="error"></form:errors>
            </div>
             <div class="field">
                <form:label path="customerId">Odabirite kupca:</form:label>
                <form:select path="customerId"> 
                <c:forEach items="${kupci}" var="kupac">
                    <option value=${kupac.key}>${kupac.value}</option>
                  </c:forEach>
                </form:select>
                <form:errors path="customerId" cssClass="error"></form:errors>
            </div>
            
  
            <div class="field">
                <form:label path="buyQty">Unesite količinu:</form:label>
                <form:input path="buyQty"></form:input>
                <form:errors path="buyQty" cssClass="error"></form:errors>
            </div>
            
            <input id="OK" type="submit"  value="Izvrsi prodaju"/>
        </form:form>
            
            <div id="poruka">
              ${poruka}
              ${artikl}
            </div>
 
            
        </div>
        

	

	<footer class="footer">
		<div>
	
		</div>
		<div>
			<br>
			<br>
			<p> Copyright &copy Lapic</p>
	
	
		</div>
	</footer>
	
        </div>
</body>
</html>