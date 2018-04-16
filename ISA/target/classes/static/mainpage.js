window.onload = function(){
	var isprazniBioskope=$("#bioskopi").empty();
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
		url:"/pba",
		type:"GET",
		contentType:"application/json",
		dataType:"json",
		success:function(data){
			if(data!=null){
				$.each(data,function(index,pbioskop){
						napraviPBioskop(index,pbioskop);
				});
			}
		},error: function(jqxhr,textStatus,errorThrown){
			alert(errorThrown);
		}
	});
}

function napraviPBioskop(index,pbioskop){
	var divPBioskopi=$("#bioskopi");
	alert(pbioskop);
	divPBioskopi.append("<div class=\"panel-heading\" style=\"background-color:lightsteelblue\"  id=\"naziv\"><label style=\"font-weight:bold;font-size: 17px;margin-right:5px;\">Name of cinema/theatre: </label><a style=\"color:white\" onclick=\"otvoriBioskop("+pbioskop+")\">"+pbioskop.naziv+"</a><button style=\"float: right; margin-right:10px;\" onclick=\"otvoriSale("+pbioskop+")\"  class=\"btn btn-info\" float=\"right\" ><span class=\"glyphicon glyphicon-ok-sign\"></span> Halls</button><button style=\"float: right; margin-right:10px;\" onclick=\"repertoar("+pbioskop.id+")\"  class=\"btn btn-danger\" float=\"right\" ><span class=\"glyphicon glyphicon-remove\"></span> Repertoire</button><button class=\"btn btn-success\" style=\"margin-right:10px; margin-left:10px;\" onclick=\"zapratiPodforum("+index+")\"float=\"right\"><span class=\"glyphicon glyphicon-eye-open\"></span> FOLLOW</button><button style=\"margin-right:10px; \" class=\"btn btn-warning\" onclick=\"otpratiPodforum("+index+")\"float=\"right\"><span class=\"glyphicon glyphicon-eye-close\"></span> UNFOLLOW</button><button class=\"btn btn-info\"  onclick=\"napisiZalbu("+index+")\"><span class=\"glyphicon glyphicon-list-alt\"></span> Write complaint</button></div>");
	divPBioskopi.append("<div class=\"panel-footer\" id=\"adresa\"><label style=\"font-weight:bold;margin-right:5px;\">Address: </label>"+pbioskop.adresa +"</div>");
	
	divPBioskopi.append("<div class=\"panel-footer\" id=\"promotivniOpis\"><label style=\"font-weight:bold;margin-right:5px;\">Description: </label>"+pbioskop.promotivniOpis +"</div>");
}

function repertoar(id){
	alert(id)
	$.ajax({
		url:"/projekcije/"+id,
		type:"GET",
		success:function(data){
			if(data!=null){
				window.location.replace("repertoire.html");
			}
		},error: function(jqxhr,textStatus,errorThrown){
			alert('Greska');
		}
		
	});
}