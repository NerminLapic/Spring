<%-- 
    Document   : proizvodi
    Created on : Jun 28, 2017, 2:24:35 AM
    Author     : Nermin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

       <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
       
        <title>PROIZVODI Lapic store </title>
        
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
            <h3 id="naslov">Lista proizvoda</h3>
	  <table>
             <tr>
                 <th align="left"> Id proizvoda</th>
                 <th align="left"> Naziv proizvoda</th>
                 <th align="left""> Cijena proizvoda</th>
                  <th align="left"> Zaliha</th>
                 <th> </th>
             </tr>
        <c:forEach items="${proizvodi}" var="proizvod">
        
                    <tr>
                        <td align="left">${proizvod[0]}</td>  
                        <td align="left">${proizvod[1]}</td>
                        <td align="left"">${proizvod[2]}</td>
                        <td align="left">${proizvod[3]}</td>
                        <td  align="left"><a id="button" href="detalji/${proizvod[0]}">Detalji</a></td>
                        <td align="left"><a href="brisi/${proizvod[0]}">Briši</a></td>
                        <td align="left"><a href="izmjeni/${proizvod[0]}">Izmjeni</a></td>
                    </tr>
      
        </c:forEach>
                    
        </table>
            <div>
                <br/>
            </div>
       <div>
                <a id="dodaj" href="/Spring_MVC_Web_Prodavnica/new_product.htm">Dodaj proizvod</a>
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
