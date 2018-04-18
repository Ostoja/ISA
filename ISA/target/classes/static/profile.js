window.onload = function(){
	$("#divKorisnickiPodaci").empty();
	$("#divPoruke").empty();
	$("#divGlasovi").empty();
	$("#divPodforumiKojeKorisnikPrati").empty();
	$("#divPracenja").empty();
	$("#divSnimljeniEntiteti").empty();
	
	$.ajax({
		url:"/returnRoleUser",
		type:"GET",
		contentType:"application/json",
		dataType:"json",
		success:function(data){
			if(data==true){
				$("#navigations").append("<li><a href = \"profile.html\">Profile</a></li>");
				
				$("#logout").append("<li  style=\"margin-right:20px;\"><a href=\"#\" onclick=\"logOutUser()\"><span class=\"glyphicon glyphicon-log-in\"></span> Logout</a></li>");
			}else{
				$("#logout").append("<li  style=\"margin-right:20px;\"><a href=\"login.html\" ><span class=\"glyphicon glyphicon-log-in\"></span> Login</a></li>");
				
				toastr["info"]("You entered as a guest");
				
			}
		},error: function(jqxhr,textStatus,errorThrown){
			alert(errorThrown);
		}
	});
	
	$.ajax({
		url:"/returnAdmin",
		type:"GET",
		contentType:"application/json",
		dataType:"json",
		success:function(data){
			if(data==true){
				$("#navigations").append("<li><a href = \"mainpage.html\">Admin page</a></li>");
			}else{
						
			}
			},error:function(jqxhr,textStatus,errorThrown){
				alert(errorThrown);
			}
	});
	
	
	/*
	$.ajax({
		url:"/rezervacije",
		type:"GET",
		contentType:"applicaton/json",
		dataType:"json",
		success:function(data){
			if(data!=null){
				$.each(data,function(index,tema){
					izradiSnimljeneTeme(index,tema);
				});
			}else{
				toastr["error"]("An error occurred while returning saved enitities");
				
			}
			
		},error:function(jqxhr,textStatus,errorThrown){
			alert(errorThrown);
		}
	});
	*/
	
	
	$.ajax({
		url:"/returnUser",
		type:"GET",
		contentType:"application/json",
		dataType:"json",
		success:function(data){
			if(data!=null){
				console.log(data);
				izradiKorisnika(data);
			}else{
				toastr["error"]("An error occurred while returning user data");
				
			}
		},error: function(jqxhr,textStatus,errorThrown){
			alert(errorThrown);
		}
	});
	
	
	
	
	
}




function logOutUser(){
	$.ajax({
		async:"false",
		url:"/logout",
		type:"GET",
		success:function(data){
			if(data==true){
				top.location.href="login.html";
			}else{
				toastr["error"]("Failed to logout");
				
			}
		},error: function(jqxhr,textStatus,errorThrown){
			alert(errorThrown);
		}
		
	});
	
}
/*
function izradiSnimljeneTeme(index,tema){
	$("#divSnimljeniEntiteti").append("<div class=\"panel-heading\"><p style=\"font-weight:bold;color:#AB7846;\">User saved topic:</p><ul>"
			+"<li><label style=\"font-weight:bold;color:#AB7846;margin:5px;\">Topic name: </label>"+tema.naslov+"</li>"
			+"<li><label style=\"font-weight:bold;color:#AB7846;margin:5px;\">Topic type: </label>"+tema.tip+"</li>");
	if(tema.tip=="TEXT"){
			$("#divSnimljeniEntiteti").append("<li><label style=\"font-weight:bold;color:#AB7846;margin:5px;\">Topic content: </label>"+tema.sadrzaj+"</li>"
			+"<li><label style=\"font-weight:bold;color:#AB7846;margin:5px;\">Topic author: </label>"+tema.autor+"</li></ul></div>");
	}
	else if(tema.tip=="LINK"){
		$("#divSnimljeniEntiteti").append("<li><label style=\"font-weight:bold;color:#AB7846;margin:5px;\">Topic content: </label><a href=\""+tema.sadrzaj+"\">"+tema.sadrzaj+"</a></li>"
				+"<li><label style=\"font-weight:bold;color:#AB7846;margin:5px;\">Topic author: </label>"+tema.autor+"</li></ul></div>");
		
	}
	else if(tema.tip=="SLIKA"){

		$("#divSnimljeniEntiteti").append("<li><label style=\"font-weight:bold;color:#AB7846;margin:5px;\">Topic content: </label><img  src=\"./rest/userService/loadFile/"+tema.sadrzaj+"\" height=\"100\" width=\"100\" class=\"icon\"></li>"
				+"<li><label style=\"font-weight:bold;color:#AB7846;margin:5px;\">Topic author: </label>"+tema.autor+"</li></ul></div>");
		
	}
}
*/
function izradiKorisnika(korisnik){
	$("#divKorisnickiPodaci").append("<table class=\"table table-bordered table-info\"><h2 style=\"font-weigth:bold\"><label style=\"font-weight:bold;color:#174AC1;margin-left:10px;\">"+korisnik.ime + " " + korisnik.prezime+"</label><br/>"+
			"<tbody><tr><td style=\"color:#174AC1;\"><b>Username</b></td><td>"+korisnik.username+"</td></tr>"+
			"<tr ><td style=\"color:#174AC1;\"><b>First Name</b></td><td>"+korisnik.ime+"</td></tr>"+
			"<tr ><td style=\"color:#174AC1;\"><b>Last Name</b></td><td>"+korisnik.prezime+"</td></tr>"+
			"<tr ><td style=\"color:#174AC1;\"><b>Role</b></td><td>"+korisnik.tip+"</td></tr>"+
			"<tr ><td style=\"color:#174AC1;\"><b>Telephone number</b></td><td>"+korisnik.brojTelefona+"</td></tr>"+
			"<tr ><td style=\"color:#174AC1;\"><b>E-mail</b></td><td>"+korisnik.email+"</td></tr>"+
			"<tr ><td style=\"color:#174AC1;\"><b>City</b></td><td>"+korisnik.grad+"</td></tr></table>");
	
}