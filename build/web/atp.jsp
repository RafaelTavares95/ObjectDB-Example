 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*,ATP.Player"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
  "http://www.w3.org/TR/html4/loose.dtd">

<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>ATP Men's Rankings</title>
    <link rel="stylesheet" href="css/bootstrap.css">
  </head>
  <body>
       <div class="container">
            <div class="row">
                <div class="col-md-6 col-md-push-3">
                     <form method="POST" action="atpServlet" class="form-horizontal form">
                         <fieldset>
                            <legend>Insert a new player:</legend>
                        </fieldset>
                        <div class="form-group">
                            <label for="nome" class="control-label col-sm-2">Nome </label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" name="name">
                            </div>
                        </div>	     
                        <div class="form-group">
                            <label for="country" class="control-label col-sm-2">Country </label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" name="country">
                            </div>
                        </div>	     
                        <div class="form-group">
                            <label for="ranking" class="control-label col-sm-2">Ranking </label>
                            <div class="col-sm-10">
                                <input type="number" class="form-control" name="ranking">
                            </div>
                        </div>     
                        <div class="form-group">
                            <label for="points" class="control-label col-sm-2">Points </label>
                            <div class="col-sm-10">
                                <input type="number" class="form-control" name="points">
                            </div>
                        </div>
                        
                        <input type="submit" value="Add" class="btn btn-primary pull-right"/>
                     </form>
                </div>
            </div> 
      <hr>      
          <table class="table table-striped">
              <thead>
                <tr>
                    <th>Ranking</th>
                    <th>Nome</th>
                    <th>País</th>
                    <th>Pontos</th>
                </tr>
              </thead>
            <tbody>
                 <c:forEach var="player" items="${players}">  
                 <tr>
                    <td>${player.ranking}</td>
                    <td>${player.name}</td>
                    <td>${player.country}</td>
                    <td>${player.points}</td>
                 </tr>
                 </c:forEach>
            </tbody>
          </table>  
      <hr>
    </div>
  </body>
</html>