<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!Doctype Html>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<Html>   
<Head>    
<Title>   
Finstack sevices
</Title>
<style type=text/css> 

body 
{
height: 125vh;
margin-top: 80px;
padding: 30px;
background-size: cover;
font-family: sans-serif;
font-weight: bold;
 background-size: cover;
    text-align: center;
}
header {
background-color: orange;
position: fixed;
left: 0;
right: 0;
top: 5px;
height: 30px;
display: flex;
align-items: center;
box-shadow: 0 0 25px 0 black;
}
header * {
display: inline;
}
header li {
margin: 20px;
}
header li a {
color: blue;
text-decoration: none;
}
.pop{


                        position: relative;
                        width: 50%;
                        max-width: 600px;
                        border-radius: 6px;
                        padding-top: 20px;
                        padding-bottom: 20px;
                        margin:auto;
                        overflow: hidden;
                        background-color:rgb(174, 237, 174);
                         border: 2px solid green;
                          
                      
                    }
 
                    
.btn{ 
 background-color:lightblue;
border: 2px solid firebrick;
border-radius:  10px;   
color:black;
cursor: pointer;
font-weight: bold;
transition: background-color 0.5s;
margin: auto;
padding: 10px;
}
.btn:hover{
        background-color: bisque;
        border: 2px solid black;
        transform: translateY(-0.25rem);
        box-shadow: 0px 3px 10px black;
    }
.mail{
position:relative;
left:3%
}


table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

td, th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}

tr:nth-child(even) {
  background-color: #dddddd;
}
</style> 
</Head>

<Body> 
<header>
<nav>
<ul>
<li>
<a href="/welcome"> Home </a>
</li>
<li>
<a href="/register"> Registration </a>
</li>
<li>
<a href="/show-users">All Users</a>
</li>
<li> <a href="#"> Terms of use </a>
</li>
<li>
<a href="#"> Join Us </a>
</li>
</ul>
</nav>
</header>
<c:choose>
<c:when test="${mode=='MODE_HOME'}">
<h1>You are at Finstack Site.....</h1>
<br>
<img alt="FinstackLogo.jpg" src="Finsatack img ">
<br>
</c:when>
<c:when test="${mode=='MODE_REGISTER'}">
 <h2>Register User</h2>
<form action="user-saved" method="POST" >
<input type="hidden" name="id" value="${user.id}">
<br>
<br>
<div class="pop">
<label for="name">UserName:</label>
<input type="text" name="name" id="name" value="${user.name}"/>
<br>
<br>
<div class="mail">
<label for="email">Email: </label>
<input type="email" name="email"  id="mail" value="${user.email}"/>
</div>
<br>
<br>
<br>
<button  class ="btn" onclick="fun()">Enter</button>
</div>
</form>
</c:when>
<c:when test="${mode=='MODE_ADDUSER'}">
<h2>USER DATA TABLE</h2>

<table>
  <tr>
    <th>ID</th>
    <th>NAME</th>
    <th>E-MAIL</th>
    <th>Delete</th>
    <th>Update</th>
  </tr>
    <c:forEach var="user" items="${users}">
    <tr>
    <td>${user.id}</td>
    <td>${user.name}</td>
    <td>${user.email}</td>
    <td><a href="/delete-user?id=${user.id}">Remove</a></td>
    <td><a href="/update-user?id=${user.id}">Edit</a></td>
  </tr>
  </c:forEach>
  </table>
  </c:when>
  
  <c:when test="${mode=='MODE_UPDATE'}">
  <h2>Update User</h2>
<form action="user-saved" method="POST"  >
<input type="hidden" name="id" value="${user.id}">
<br>
<br>
<div class="pop">
<label for="name">UserName:</label>
<input type="text" name="name" id="name" value="${user.name}"/>
<br>
<br>
<div class="mail">
<label for="email">Email: </label>
<input type="email" name="email"  id="mail" value="${user.email}"/>
</div>
<br>
<br>
<br>
<button  class ="btn" onclick="gun()">Update</button>
</div>
</form>

</c:when>
</c:choose>

 <script >
 
 function fun(){
		alert("User Saved")
		

 }
 function gun(){
		alert("User Updated")
		

}
</script>
</Body> 

</Html>

 
    