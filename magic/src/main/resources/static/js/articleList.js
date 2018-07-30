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


