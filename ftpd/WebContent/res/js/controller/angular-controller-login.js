app.controller("loginController",function($scope,$controller,loginService){
	$controller('managerController',{$scope:$scope});
	$scope.login = function(){
		if($scope.validate()){
		
			$scope.loginInfo.passive = $("input[name='passive']:checked").val();
			loginService.login_default(
					$scope.loginInfo.remoteServerHost,
					$scope.loginInfo.remoteServerPort,
					$scope.loginInfo.username,
					$scope.loginInfo.password,
					$scope.loginInfo.initPath,
					$scope.loginInfo.passive
			).
			success(function(data){
				if(data="\"123456789\""){
					first = false;
					location.href = "manager.html";
				}else{
					alert(data);
				}
			}).
			error(function(){
				alert("系统错误");
			});
		}
	}
});