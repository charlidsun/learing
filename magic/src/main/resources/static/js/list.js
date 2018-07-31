//window.onload = function() {
//    document.getElementById("wiki-search-input").focus();
//};
//点击搜索
$(".result-btn-wiki").click(function (event) {
	event.preventDefault();
	var keyword = $(".wiki-search-input").val();
	if (keyword !== "") {
		//使用ajax请求
		document.write("<form action='/chat/searchChat' method='post' name='form1' style='display:none'>");  
		document.write("<input type='hidden' name='keyword' value="+keyword+">");  
		document.write("</form>");  
		document.form1.submit();  
	}else {
		alert("请输入搜索内容");
	}
});

function linkToList(obj){
	var fakeId = $(obj).children("p").eq(0).text();
	var name = $(obj).children("p").eq(1).text();
	var msg = fakeId +"$"+name;
	
	alert(msg);
	//post传递给后台
	document.write("<form action='/chat/searchArticle' method='post' name='form2' style='display:none'>");  
	document.write("<input type='hidden' name='keyword' value="+msg+">");  
	document.write("</form>");  
	document.form2.submit();  
}


