<%-- 
    Document   : kupci
    Created on : Jul 6, 2017, 8:13:25 AM
    Author     : Nermin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="baseURL" value="${pageContext.request.localName}"/>
<!DOCTYPE html>
<html>
     <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

       <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
       
        <title>KUPCI Lapic store </title>
        
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
            <h3 id="naslov">Lista kupaca</h3> 
	  <table >
             <tr>
                 <th align="left"> Id kupca</th>
                 <th align="left"> Ime</th>
                 <th align="left"> Prezime</th>
                 <th align="left"> E-mail</th>
             </tr>
        <c:forEach items="${kupci}" var="kupac">
        
                    <tr>
                        <td align="left">${kupac[0]}</td>  
                        <td align="left">${kupac[1]}</td>  
                        <td align="left">${kupac[2]}</td>  
                         <td align="left">${kupac[3]}</td>  
                        <td align="left"><a href="brisiKupca/${kupac[0]}">Briši</a></td>
                        <td align="left"><a href="izmjeniKupca/${kupac[0]}">Izmjeni</a></td>
                    </tr>
      
        </c:forEach>
            </table>
       <div>
           </br>
           
       </div>
       <div>
           <a id="dodaj" href="/Spring_MVC_Web_Prodavnica/new_customer.htm">Dodaj kupca</a>
           
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
