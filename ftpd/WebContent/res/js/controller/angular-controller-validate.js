/*
 * 前台登录验证
 * */
app.controller("validateController",function($scope,$controller){
	$controller('loginController',{$scope:$scope});
	$scope.validate = function(){
		var flag = true;
		if($scope.validateBlank()){
			if($scope.validateHost($scope.loginInfo.remoteServerHost)==false){
				$scope.loginInfo.remoteServerHost = "";
				$("#host").prop("placeholder","请输入正确的地址");
				flag = false;
			}
//			if($scope.validatePath($scope.loginInfo.initPath)==false){
//				$scope.loginInfo.initPath = "";
//				$("#initPath").prop("placeholder","请输入正确的路径");
//				flag = false;
//			}
		}
		return flag;
	}
	$scope.validateHost = function(host){
		var p = /^(?=^.{3,255}$)[a-zA-Z0-9][-a-zA-Z0-9]{0,62}(\.[a-zA-Z0-9][-a-zA-Z0-9]{0,62})+$/;
		return p.test($.trim(host));
	}
	$scope.validatePath = function(path){
		if($.trim(path)=="" || $.trim(path)==undefined ||$.trim(path)==null){
			return true;
		}
		var p = /[a-zA-Z]:(\\([0-9a-zA-Z]+))+|(\/([0-9a-zA-Z]+))+/;
		return p.test($.trim(path));
	}
	$scope.validateBlank = function(){
		var host = $scope.loginInfo.remoteServerHost;
		var port = $scope.loginInfo.remoteServerPort;
		var username = $scope.loginInfo.username;
		var password =  $scope.loginInfo.password;
		var initPath = $scope.loginInfo.initPath;
		host = $.trim(host);
		port = $.trim(port);
		username = $.trim(username);
		password = $.trim(password);
		var flag = true;
		if(host==null || host==undefined || host==""){
			$scope.loginInfo.remoteServerHost ="";
			$("#host").prop("placeholder","请输入地址");
			flag = false;
		}
		if(port==null || port==undefined || port==""){
			$scope.loginInfo.remoteServerPort = 21;
			flag = false;
		}
		if(username==null || username==undefined || username==""){
			 $scope.loginInfo.username = "";
			$("#username").prop("placeholder","请输入用户名");
			flag = false;
		}
		if(password==null || password==undefined || password==""){
			$scope.loginInfo.password = "";
			$("#password").prop("placeholder","请输入密码");
			flag = false;
		}
		return flag;
	}
});