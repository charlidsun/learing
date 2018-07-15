

//登录提交
function sysLogin(){
	var loginName = $('#username').val();
	var loginPwd = $('#password').val();
	
	if (loginName.length == 0 || loginPwd.length == 0){
		alert("不能为空")
	}else{
		//登录
		$.ajax({
			url : '/login',
			type : 'POST',
			dataType : 'json',
			data : {loginName:loginName,loginPwd:loginPwd},
			success : function(result){
				console.log(result);
				if("success"==result){
					console.log(result);
					//访问跳转controller
					location.href="/login/index";
				}else{
					
				}
			},
			error:function(){
				
			}
		});
	}
}
