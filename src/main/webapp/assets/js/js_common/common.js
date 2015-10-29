var feedback = {
	init : function(userId) {

		$("#feedback_btn").click(function() {
			$("#feedback_pop [name^=step_]").hide();
			$("#feedback_pop [name='step_1']").show();
			$("#feedback_pop").show();
		});

		$("#feedback_pop .content").focus(function() {
			var content = $(this).val();
			if(!content || content == $(this).attr("tips")){
				$("#feedback_pop .content").val("");
			}
		});
		$("#feedback_pop .content").focusout(function() {
			var content = $(this).val();
			if(!content || content == $(this).attr("tips")){
				$("#feedback_pop .content").val($(this).attr("tips"));
			}
		});

		$(".pop .close").click(function() {
			$("#feedback_pop [name^=step_]").hide();
			$("#feedback_pop").hide();
		});

		$("#feedback_pop .submit").click(function() {
			var content = $("#feedback_pop .content").val();
			if(!content || content == $("#feedback_pop .content").attr("tips")){
				$("#feedback_pop .content").val($("#feedback_pop .content").attr("tips"));
				return;
			}
			
			
			$("#feedback_pop [name^=step_]").hide();
			var username = $("#feedback_pop .input_1[name='uname']").val();
			var password = $("#feedback_pop .input_1[name='upassword']").val();
			username = encodeURI(username);
			$.ajax({
				url : "/mycenter/feedback/submitFeedback",
				data : {
					username : username,
					password : password,
					content : content
				},
				cache : !1,
				async : !0,
				type : "POST",
				dataType : "json",
				beforeSend : function() {
					$("#feedback_pop [name=step_3]").show();
				},
				success : function(response) {
					
					$("#feedback_pop [name^=step_]").hide();
					if (response && response.success && "success" == response.success) {
						
						$("#feedback_pop [name='step_4']").show();
						
					} else if (response && response.success && "no_login" == response.success) {

						$("#feedback_pop [name='step_2']").show();
						$("#feedback_pop [name=step_2]").find(".tip").show();
					} else {

						$("#feedback_pop [name=step_5]").show();
					}
				},
				error : function() {
					$("#feedback_pop [name^=step_]").hide();
					$("#feedback_pop [name=step_5]").show();
				}
			});
		});

	}
};
var topNavi = {
	init : function() {
		topNavi.testLogin(function() {
			topNavi.getReplyCount();
			}, function() {
		});
	},
	initListener : function(buildingId,buildingAlias) {
		$("#header .searchBar .inputBar INPUT").val($("#header .searchBar .inputBar INPUT").attr("tips"));
		$("#header .searchBar .inputBar INPUT").focus(function() {
			if ("restaurant inputTips" == $(this).attr("class")) {
				$(this).val("");
				$(this).attr("class", "restaurant");
			}
		});
		
		$("#search_menu").click(function() {
			var menuName = $("#header .searchBar .inputBar INPUT").val();
			if (menuName && menuName != $("#header .searchBar .inputBar INPUT").attr("tips")) {
				document.getElementById("search_menu_form").submit();
			}
		});
		
		$(".searchArea .icon").click(function(){
			var menuName = $(".searchArea input").val();
			if (menuName) {
				document.getElementById("search_menu_form_bottom").submit();
			}
		});

		// 初始化导航条的按钮
		$("#navi_mycenter").click(function(){
			topNavi.testLogin(
				function() {
					window.location.href = "/mycenter/order?naviFlag=mycenter&flag=today";
				},
				function() {
					var popup = Boxy.ask("登录以后您才可以使用“催餐”功能查看催餐电话，是否现在登陆？",["登录","取消"],function(val){
	            		 if("登录" == val){
	            			 window.location.href="http://demo.cookwaimai.com/login/toLogin?login_flag=toMycenter_today";
	            		 }else {
	            			 popup.hide();
	            		 }
	            		 
	            	},{title:"温馨提示"});
				},true);
	  });

		// 点击显示收藏，再次点击关闭
		$("#changeLocation").toggle(function() {

			$("#locationPop").show();
		}, function() {

			$("#locationPop").hide();
		});

		// 用户点击了个人中心以后
		$("#mycenter").click(function() {
			topNavi.testLogin(function() {
						window.location.href = "/mycenter/order?naviFlag=mycenter&flag=today";
					},
					function() {
						var popup = Boxy.ask("登录以后您才可以进入“个人中心”，是否现在登陆？",["登录","取消"],function(val){
		            		 if("登录" == val){
		            			 window.location.href="http://demo.cookwaimai.com/login/toLogin?login_flag=to_restaurants&building_alias="+(buildingAlias ? buildingAlias : "");
		            		 }else {
		            			 popup.hide();
		            		 }
		            		 
		            	},{title:"温馨提示"});
					},true);
	  });
		// 点击收藏夹以后查询用户的收藏,再点击就关闭
		$("#favorite").click(function() {
			$("#myMessages").hide();
			
			$("#myFavourite").is(":hidden") ? topNavi.getMyFavoriteRest() : $("#myFavourite").slideUp(300);

		});
		
		// 点击了收藏的餐馆以后，跳转到这个餐馆
		$("#myFavourite").find("div[class='fe-li']").live("click",function() {
			var alias = $(this).attr("val");
			if (!alias) {
				return;
			} else {
				window.location.href = "/restaurant/toRestaurantDetail/"+alias;
			}
		});

		// 点击我的信息以后
		$("#message").click(function() {
			$("#myFavourite").hide();
			topNavi.testLogin(function() {
				$("#myMessages").is(":hidden") ? $("#myMessages").slideDown(300) : $("#myMessages").slideUp(300);
			},
			function() {
				$("#myFavourite").hide();
				var popup = Boxy.ask("登录以后，才可以查看“我的信息”，是否现在登陆？",["登录","取消"],function(val){
            		 if("登录" == val){
            			 window.location.href="http://demo.cookwaimai.com/login/toLogin?login_flag=toMycenter_comment";
            		 }else {
            			 popup.hide();
            		 }
            		 
            	},{title:"温馨提示"});
			});
		});
		// 用户点击了我的评论回复以后
		$("#myMessages").find(".fe-li[val='comment']").click(function() {
			window.location.href = "/mycenter/comment?flag=comment";
		});
		// 用户点击了我的反馈的回复以后
		$("#myMessages").find(".fe-li[val='feedback']").click(function() {
			window.location.href = "/mycenter/feedback?flag=feedback";
		});
	},
	testLogin : function(callback_login, callback_noLogin,flag_mask) {
		var mask = null;
		$.ajax({
			type : "POST",
			dataType: 'json',
			contentType: "application/x-www-form-urlencoded;charset=utf-8",
			url : "/common/testLogin",
			cache: false,
			beforeSend:function(){
				if(flag_mask){
					mask = new Boxy("<img class='boxy-image' src='http://demo.cookwaimai.com/assets/images/common/loading.gif'/>");
				}
			 },
			success : function(response) {
				if(mask){
					 mask.hide();
				 }
				if (response && response.success && "success" == response.success) {
					callback_login();
				} else if (response && response.success && "no_login" == response.success) {
					callback_noLogin();
				} else {
					window.location.href = "http://demo.cookwaimai.com";
				}
			},
			error:function(){
	        	 if(mask){
					 mask.hide();
				 }
	         }
		});
	},
	
	getReplyCount : function() {
		$.ajax({
			type : "POST",
			dataType: 'json',
			contentType: "application/x-www-form-urlencoded;charset=utf-8",
			url : "/common/listMyMessage",
			cache: false,
			success : function(response) {
				if (response && response.data) {
					var count_comment = response.data.count_comment;
					var count_feedback = response.data.count_feedback;
					$("#message").html("我的信息(" + (count_comment + count_feedback) + ")");
					topNavi.showMessages(count_comment, count_feedback);
				}
			},
			error : function() {
				$("#message").html("我的信息(0)");
			}
		});
	},
	showMessages : function(count_comment, count_feedback) {
		
		$("#myMessages").find(".fe-li[val='comment']").find("a").html(
				count_comment);
		$("#myMessages").find(".fe-li[val='feedback']").find("a").html(
				count_feedback);
		
		if(!count_comment && !count_feedback){
			$("#myMessages").find(".fe-li[val='feedback']").hide();
			$("#myMessages").find(".fe-li[val='comment']").html("<EM>暂无动态</EM>");
		}else {
			if (!count_comment) {
				$("#myMessages").find(".fe-li[val='comment']").hide();
			}
			if (!count_feedback) {
				$("#myMessages").find(".fe-li[val='feedback']").hide();
			}
			$("#myMessages").fadeIn(1500, function() {
				window.setTimeout(function() {
					$("#myMessages").fadeOut(1000);
				}, 3000);
			});
		}
	},
	
	getMyFavoriteRest : function(){
		$.ajax({
	    	type : "POST",
			dataType: 'json',
			contentType: "application/x-www-form-urlencoded;charset=utf-8",
			url : "/common/getFavoriteRest",
			cache: false,
	        success: function(response) {
	        	if (response && response.dataList && response.dataList.length > 0) {
                    var favRestHtml = "";
                    for (var i = 0; i < response.dataList.length; i++) {
                        favRestHtml += "<div val=" + response.dataList[i].alias + " class='fe-li'> <EM>" + response.dataList[i].name + "</EM></div>";
                    }
                    $("#myFavourite").find("div[class='fe-list']").html(favRestHtml);
                } else {
                	$("#myFavourite").find("div[class='fe-li']").html("<EM>您在本区域暂无收藏</EM>");
                }
                $("#myFavourite").slideDown(300);
	        }
	    });
	},
	
	activeNavi : function(flag) {
		var naviArr = $("#header .topNav .nfirst");
		if (flag) {
			for ( var i = 0; i < naviArr.length; i++) {
				if (flag == $(naviArr[i]).attr("val")) {
					$(naviArr[i]).attr("class", "navItem nactive");
					return;
				}
			}
			$(naviArr[0]).attr("class", "navItem nactive");
		} else {
			$(naviArr[0]).attr("class", "navItem nactive");
		}
	}
};
//
//var reply = {
//	initListener : function() {
//		// 点击关闭按钮
//		$(".pop .close").click(function() {
//			$("#feedback_pop").hide();
//		});
//		// 点击输入框以后
//		$("#feedback_pop .content").focus(function() {
//			if ("" == $.trim($(this).val()) || "请输入您的回复信息" == $(this).val()) {
//				$(this).val("");
//			}
//
//		});
//		$("#feedback_pop .content").focusout(function() {
//			if ("" == $.trim($(this).val())) {
//				$(this).val("请输入您的回复信息");
//			}
//		});
//	},
//	id : 0
//};