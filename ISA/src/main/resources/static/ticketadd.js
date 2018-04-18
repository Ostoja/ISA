window.onload = function(){
	/*$.ajax({
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
				
				$("#navigations").append("<li><a href=\"primljeneZalbe.html\">Primljene zalbe</a></li>")
				$("#logout").append("<li  style=\"margin-right:20px;\"><a href=\"#\" onclick=\"logOutUser()\"><span class=\"glyphicon glyphicon-log-in\"></span> Logout</a></li>");
			}else{
				$("#logout").append("<li  style=\"margin-right:20px;\"><a href=\"login.html\" ><span class=\"glyphicon glyphicon-log-in\"></span> Back to login page</a></li>");
				
				
			}
		},error: function(jqxhr,textStatus,errorThrown){
			alert(errorThrown);
		}
	});
	*/
	$.ajax({
		url:"/projekcije",
		type:"GET",
		contentType:"application/json",
		dataType:"json",
		success:function(data){
			if(data!=null){
				$.each(data,function(index,value){
					$("#projekcija").append("<option>"+value.id+"</option>");
					
				});
			}
		},error: function(jqxhr,textStatus,errorThrown){
			alert(errorThrown);
		}
		
	});

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
						top.location.href = "novaTema.html";
						
			}
			},error:function(jqxhr,textStatus,errorThrown){
				alert(errorThrown);
			}
	});
}
*/

function getFormData1(){
	var data = JSON.stringify({
		"naslov":$("#novaTema input[id=naslov]").val(),
		"tip":$("#novaTema select[id=tip").val(),
		"sadrzaj":$("#novaTema textarea[id=sadrzaj]").val(),
	});
	return data;
}


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

function updateForm(){
	var id = $("#projekcija").val
	$.ajax({
		url:"/segmentipr/"+id,
		type:"GET",
		contentType:"application/json",
		dataType:"json",
		success:function(data){
			if(data!=null){
				$.each(data,function(index,value){
					$("#segmentUsali").append("<option>"+value.id+"</option>");
					
				});
			}
		},error: function(jqxhr,textStatus,errorThrown){
			alert(errorThrown);
		}
		
	});
}

function updateFormSeg(){
	var id = $("#segmentUsali").text
	console.log(id);
	alert(id);
	$.ajax({
		url:"/mestaseg/"+id,
		type:"GET",
		contentType:"application/json",
		dataType:"json",
		success:function(data){
			if(data!=null){
				$.each(data,function(index,value){
					$("#mesto").append("<option>"+value.broj+"</option>");
					
				});
			}
		},error: function(jqxhr,textStatus,errorThrown){
			alert(errorThrown);
		}
		
	});
}

function getFormData($form){
    var unindexed_array = $form.serializeArray();
    var indexed_array = {};
    
    $.map(unindexed_array, function(n, i){
        indexed_array[n['name']] = n['value'];
    });

    return indexed_array;
}

function napraviNovuKartu(){
	$form = $("#novaKarta");
	var data = getFormData($form);
	var s = JSON.stringify(data);
	console.log(s);
	$.ajax({
		url:"/pb/karte",
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