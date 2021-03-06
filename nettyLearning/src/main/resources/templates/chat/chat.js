
var socket;
var userId = '';
var headImg = '';
var toUserId = '';
var wbUrl = 'ws://127.0.0.1:9091/ws';

$(function(){
	//首先隐藏聊天的区域
	//$('#frame').hide();
	//获取到页面上的ID
	userId = $('#userId').text();
	//$('#loading')
	console.log(userId);
})	


//websocker
//如果浏览器支持WebSocket
if(window.WebSocket){
	//参数就是与服务器连接的地址
    socket = new WebSocket(wbUrl);
    //客户端收到服务器消息的时候就会执行这个回调方法
    socket.onmessage = function (event) {
        //连接协议，参数1001，初始化，返回信息，返回的是用户的好友列表，包括在线和离线的
        var user = JSON.parse(event.data);
        if (user.msgType == 1001){
        	//用户名
        	$('#profile-img').attr('src',user.user.headImg);
        	headImg = user.user.headImg;
        	$('#profile-name').text(user.user.userName);
        	//上线的人
        	if (user.userList != null && user.userList.length>0){
        		for (var i=0;i<user.userList.length;i++){
        			var lineUser = user.userList[i];
        			var lock = lineUser.lock == 99 ? "online" : "offline";
        			var listHtml = '<li class="contact" data-id="'+lineUser.loginName+'" data-name="'+lineUser.userName+'" data-img="'+lineUser.headImg+'" onclick="chatUser(this)">'
   					 			 + '	<div class="wrap">'
   					 			 + '		<span id="'+lineUser.loginName+'" class="contact-status '+lock+'"></span>'
   					 			 + '		<img src="'+lineUser.headImg+'" alt="" />'
   					 			 + '		<div class="meta">'
   					 			 + '			<p class="name">'+lineUser.userName+'</p>'
   					 			 + '			<p class="preview">'+lineUser.selfIntr+'</p>'
   					 			 + '		</div>'
   					 			 + '	</div>'
   					 			 + '</li>'	
   					$('#onLineList').append(listHtml);
        		}
        	}
        }
        //其他人上线的通知,因为是好友列表，所有不能append
        if (user.msgType == 1002){
        	console.log(user)
        	//找到那个div直接更新状态
        	$("#"+user.user.loginName).removeClass("offline");
        	$("#"+user.user.loginName).attr("class","online");
        }
        //展示聊天记录
        console.log("---")
        console.log(user);
        if (user.msgType == 1003){
        	//将之前的列表清空
        	$('#chatHistory').empty();
        	for (var i=user.chatHistory.length-1;i>=0;i--){
        		var chat = user.chatHistory[i];
        		if (chat.sendUserId != userId){
        			var ht = '<li class="sent">'
        					+'<img src="'+chat.sendUserImg+'" alt="" />'
        					+ '<p>'+chat.content+'</p>'
        					+ '</li>'
        					$('#chatHistory').append(ht);
        		}else{
        			var dt = '<li class="replies">'
        				+'<img src="'+chat.sendUserImg+'" alt="" />'
        				+	'<p>'+chat.content+'.</p>'
        				+'</li>'
        				$('#chatHistory').append(dt);
        		}
        	}
        	//判断，这个人是否是离线，如果离线不允许发消息
        	if ($('#'+toUserId).hasClass('offline')){
        		$('.message-input').hide();
        	}else{
        		$('.message-input').show();
        	}
        }
        if (user.msgType == 1004){
        	console.log(user.chatHistory.receiveUserId);
        	console.log(toUserId);
        	//首先判断当前窗口是否是接受消息的人
        	if (user.chatHistory.loginName != toUserId){
        		//提示用户有新消息了
        		$("#"+user.chatHistory.loginName).removeClass("offline");
            	$("#"+user.chatHistory.loginName).attr("class","busy");
        	}else{
        		//将返回的聊天记录追加到聊天窗口
            	var chat = user.chatHistory;
            	var ht = '<li class="sent">'
    				+'<img src="'+chat.headImg+'" alt="" />'
    				+ '<p>'+chat.selfIntr+'</p>'
    				+ '</li>'
    			$('#chatHistory').append(ht);
        	} 
        }
    }
    //连接建立的回调函数
    socket.onopen = function(event){
    	console.log(event);
    	//连接协议，参数1001，只携带用户ID过去，返回用户的channelID，用户信息，上线人的基本信息
    	var msg = {
        	mgsType:1001,
        	userId:userId,
        	toUserId:'',
        	msg:''
        }
    	var message=JSON.stringify(msg);//将表单中的数据转成json
    	send(message);
    }
    //连接断掉的回调函数
    socket.onclose = function (event) {
        var ta = document.getElementById("responseText");
        ta.value = ta.value +"\n"+"连接关闭";
    }
}else{
	alert("浏览器不支持WebSocket！");
}

//发送数据
function send(message){
    if(!window.WebSocket){
        return;
    }
    //当websocket状态打开
    if(socket.readyState == WebSocket.OPEN){
        socket.send(message);
    }else{
        alert("连接没有开启");
    }
}

//点击在线人员
function chatUser(obj){
	var loginName = $(obj).data("id");
	var userName = $(obj).data("name");
	var headImg = $(obj).data("img");
	var chatUserName = $('#chatUserName').text();
	if (chatUserName != loginName){
		toUserId = loginName;
		$('#chatUserName').text(userName);
		$('#chatHeadImg').attr('src',headImg);
		
		//将这个人ID发送给后台
		//连接协议，参数1003，只携带用户ID过去，返回用户的channelID，用户信息，上线人的基本信息
		var msg = {
	    	mgsType:1003,
	    	userId:userId,
	    	toUserId:loginName,
	    	msg:''
	    }
		var message=JSON.stringify(msg);//将表单中的数据转成json
		send(message);
	}else{
		
	}
	
}



$(".messages").animate({ scrollTop: $(document).height() }, "fast");

$("#profile-img").click(function() {
	$("#status-options").toggleClass("active");
});

$(".expand-button").click(function() {
  $("#profile").toggleClass("expanded");
	$("#contacts").toggleClass("expanded");
});

$("#status-options ul li").click(function() {
	$("#profile-img").removeClass();
	$("#status-online").removeClass("active");
	$("#status-away").removeClass("active");
	$("#status-busy").removeClass("active");
	$("#status-offline").removeClass("active");
	$(this).addClass("active");
	
	if($("#status-online").hasClass("active")) {
		$("#profile-img").addClass("online");
	} else if ($("#status-away").hasClass("active")) {
		$("#profile-img").addClass("away");
	} else if ($("#status-busy").hasClass("active")) {
		$("#profile-img").addClass("busy");
	} else if ($("#status-offline").hasClass("active")) {
		$("#profile-img").addClass("offline");
	} else {
		$("#profile-img").removeClass();
	};
	
	$("#status-options").removeClass("active");
});

//发送新的消息
function newMessage() {
	message = $(".message-input input").val();
	//获取发送人的ID
	if($.trim(message) == '') {
		return false;
	}
	
	//发起请求，1004
	var msg = {
	    	mgsType:1004,
	    	userId:userId,
	    	toUserId:toUserId,
	    	msg:message
	}
	var messageStr=JSON.stringify(msg);//将表单中的数据转成json
	console.log(messageStr);
	send(messageStr);
	
	$('<li class="replies"><img src="'+headImg+'" alt="" /><p>' + message + '</p></li>').appendTo($('.messages ul'));
	$('.message-input input').val(null);
	$('.contact.active .preview').html('<span>You: </span>' + message);
	$(".messages").animate({ scrollTop: $(document).height() }, "fast");
};

$('.submit').click(function() {
  newMessage();
});

$(window).on('keydown', function(e) {
  if (e.which == 13) {
    newMessage();
    return false;
  }
});