window.onload = function(){
	//$("#izabraniModeraotri").empty();
	
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
				$("#navigations").append("<li onclick=\"checkAuthorize()\" class=\"active\"><a href=\"noviPodforum.html\">Add new subforum</a></li>");
				$("#navigations").append("<li><a href = \"posaljiPoruku.html\">Send message</a></li>");
				
				$("#navigations").append("<li><a href=\"primljeneZalbe.html\">Primljene zalbe</a></li>")
				$("#logout").append("<li  style=\"margin-right:20px;\"><a href=\"#\" onclick=\"logOutUser()\"><span class=\"glyphicon glyphicon-log-in\"></span> Logout</a></li>");
			}else{
				$("#logout").append("<li  style=\"margin-right:20px;\"><a href=\"login.html\" ><span class=\"glyphicon glyphicon-log-in\"></span> Back to login page</a></li>");
				
				
			}
		},error: function(jqxhr,textStatus,errorThrown){
			alert(errorThrown);
		}
	});
	
	
	$.ajax({
		url:"rest/userService/returnModerators",
		type:"GET",
		contentType:"application/json",
		dataType:"json",
		success:function(data){
			if(data!=null){
				$.each(data,function(index,value){
					$("#odaberiModeratore").append("<option>"+value.username+"</option>");
					
				});
			}
		},error: function(jqxhr,textStatus,errorThrown){
			alert(errorThrown);
		}
		
	});*/
}
/*
function checkAuthorize(){
	$.ajax({
		url:"rest/userService/returnModerOrAdmin",
		type:"GET",
		contentType:"application/json",
		dataType:"json",
		success:function(data){
			if(data==true){
				top.location.href="noviPodforum.html";
			}else{
						top.location.href = "noviPodforum.html";
						
			}
			},error:function(jqxhr,textStatus,errorThrown){
				alert(errorThrown);
			}
	});
}
*/

function getFormData($form){
	var unordered_array = $form.serializeArray();
	var ordered_array={};
	
	$.map(unordered_array,function(n,i){
		ordered_array[n['name']]=n['value'];
	});
	return ordered_array;
}
	
/*
function logOutUser(){
	$.ajax({
		async:"false",
		url:"rest/userService/logout",
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
*/
function dodajFilm(){
	$form = $("#noviEvent");
	var data = getFormData($form);
	var s = JSON.stringify(data);
	$.ajax({
		url:"/fp",
		type:"POST",
		data:s,
		contentType:"application/json",
		dataType:"json",
		success:function(data){
			if(data==false){
				toastr["error"]("Registration failed");
				
			}else{
				toastr["success"]("Registration successfull");
				}
			
		},error: function(jqxhr,textStatus,errorThrown){
			alert(errorThrown);
		}
	});
	
}
