window.onload = function(){
	var isprazniRepertoar=$("#movie").empty();
	alert('AbA');
	/*
	$.ajax({
		url:"rest/userService/returnRoleUser",
		type:"GET",
		contentType:"application/json",
		dataType:"json",
		success:function(data){
			if(data==true){
				$("#navigations").append("<li><a href = \"startPage.html\">Start page</a></li>");
				$("#navigations").append("<li><a href=\"korisnickaStranica.html\">User page</a></li>");
				$("#navigations").append("<li onclick=\"checkAuthorize()\"><a href=\"noviPodforum.html\">Add new subforum</a></li>");
				$("#navigations").append("<li><a href = \"posaljiPoruku.html\">Send message</a></li>");
				
				$("#navigations").append("<li><a href=\"primljeneZalbe.html\">Received complaints</a></li>")
				$("#logout").append("<li  style=\"margin-right:20px;\"><a href=\"#\" onclick=\"logOutUser()\"><span class=\"glyphicon glyphicon-log-in\"></span> Logout</a></li>");
			}else{
				$("#logout").append("<li  style=\"margin-right:20px;\"><a href=\"login.html\" ><span class=\"glyphicon glyphicon-log-in\"></span> Back to login page</a></li>");
				
				toastr["info"]("You entered as a guest");
				
			}
		},error: function(jqxhr,textStatus,errorThrown){
			alert(errorThrown);
		}
	});
	*/
	$.ajax({
		url:"/fp",
		type:"GET",
		contentType:"application/json",
		dataType:"json",
		success:function(data){
			if(data!=null){
				$.each(data,function(index,repertoar){
						napraviRepertoar(index,repertoar);
				});
			}
		},error: function(jqxhr,textStatus,errorThrown){
			alert(errorThrown);
		}
	});
}

function napraviRepertoar(index,repertoar){
	var divRepertoar=$("#movie")
	console.log(repertoar);
	divRepertoar.append("<div class=\"panel-heading\" style=\"background-color:lightsteelblue\"  id=\"film\"><label style=\"font-weight:bold;font-size: 17px;margin-right:5px;\">Name of show: </label><a style=\"color:white\" onclick=\"otvoriBioskop("+repertoar+")\">"+repertoar.naziv+"</a><button style=\"float: right; margin-right:10px;\" onclick=\"otvoriSale("+repertoar+")\"  class=\"btn btn-info\" float=\"right\" ><span class=\"glyphicon glyphicon-ok-sign\"></span> Halls</button><button style=\"float: right; margin-right:10px;\" onclick=\"edituj("+repertoar.id+")\"  class=\"btn btn-danger\" float=\"right\" ><span class=\"glyphicon glyphicon-remove\"></span> Repertoire</button><button class=\"btn btn-success\" style=\"margin-right:10px; margin-left:10px;\" onclick=\"zapratiPodforum("+repertoar+")\"float=\"right\"><span class=\"glyphicon glyphicon-eye-open\"></span> FOLLOW</button><button style=\"margin-right:10px; \" class=\"btn btn-warning\" onclick=\"otpratiPodforum("+repertoar+")\"float=\"right\"><span class=\"glyphicon glyphicon-eye-close\"></span> UNFOLLOW</button><button class=\"btn btn-info\"  onclick=\"napisiZalbu("+repertoar+")\"><span class=\"glyphicon glyphicon-list-alt\"></span> Write complaint</button></div>");
	divRepertoar.append("<div class=\"panel-footer\" id=\"time\"><label style=\"font-weight:bold;margin-right:5px;\">Duration: </label>"+repertoar.trajanje +"</div>");
	divRepertoar.append("<div class=\"panel-footer\" id=\"sala\"><label style=\"font-weight:bold;margin-right:5px;\">Director: </label>"+repertoar.reditelj +"</div>");
	divRepertoar.append("<div class=\"panel-footer\" id=\"cena\"><label style=\"font-weight:bold;margin-right:5px;\">Actors: </label>"+repertoar.spisakGlumaca +"</div>");
	divRepertoar.append("<div class=\"panel-footer\" id=\"cena\"><label style=\"font-weight:bold;margin-right:5px;\">Genre: </label>"+repertoar.zanr +"</div>");
}

function edituj(id){
	$.ajax({
		url:"/filmpred/"+id,
		type:"GET",
		success:function(data){
			if(data!=null){
				window.location.replace("eventedit.html");
			}
		},error: function(jqxhr,textStatus,errorThrown){
			alert(errorThrown);
		}
		
	});
}