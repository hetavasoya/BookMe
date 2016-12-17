<%-- 
     Document   : calendarpage
     Created on : Nov 29, 2016, 10:17:59 AM
     Author     : TEJAS
 --%>
 
 <%@page contentType="text/html" pageEncoding="UTF-8"%>
 <!DOCTYPE html>
 <html>
     <head>
         <title>Book your appointment day</title>
         <meta charset="UTF-8">
         <meta name="viewport" content="width=device-width, initial-scale=1.0">
         
         <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
         <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
         <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
         
         <link href='http://fonts.googleapis.com/css?family=Roboto:400,500' rel='stylesheet' type='text/css'>
 	<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
         
         <link href="clockface.css" rel="stylesheet">
         <script src="clockface.js"></script>
     </head>
     <body>
         
             <div class="container">
                 <h3 class="head"> <span class="glyphicon glyphicon-calendar"> Welcome, Book your appointment </span> </h3>
                     <button type="button" class="btn btn-info btn-md" data-toggle="modal" data-target="#myModal"> Monday </button>
                     <button type="button" class="btn btn-info btn-md" data-toggle="modal" data-target="#myModal"> Tuesday </button>
                     <button type="button" class="btn btn-info btn-md" data-toggle="modal" data-target="#myModal"> Wednesday </button>
                     <button type="button" class="btn btn-info btn-md" data-toggle="modal" data-target="#myModal"> Thursday </button>
                     <button type="button" class="btn btn-info btn-md" data-toggle="modal" data-target="#myModal"> Friday </button>
                     <button type="button" class="btn btn-info btn-md" data-toggle="modal" data-target="#myModal"> Saturday </button>
                     <button type="button" class="btn btn-info btn-md" data-toggle="modal" data-target="#myModal"> Sunday </button>
                 
             </div>
         
         <div class="container">
             <div class="modal fade" id="myModal" role="dialog">
                 <div class="modal-dialog">
                     <div class="modal-content">
                         <div class="modal-body">
                             <div class="container-well">
                                 <div class="input-append">
                                     <input type="text" id="t2" class="input-small" readonly="">
                                     <button class="btn" type="button" id="toggle-btn"><i class="gylphicon glyphicon-time"></i></button>
                                 </div>
                             </div>                            
                         </div>
                     </div>
                 </div>
             </div>
         </div>
     </body>
         <script>
             $(function(){
                 $('#t2').clockface({
                     format:'HH:mm',
                     trigger:'manual'
                 });
                 $('#toggle-btn').click(function (e){
                     e.stopPropagation();
                     $('#t2').clockface('toggle');
                 });
             });
         </script>
    
	
 </html>
