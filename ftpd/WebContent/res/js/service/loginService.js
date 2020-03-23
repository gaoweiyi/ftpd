app.service("loginService",function($http){
	
	this.login_default = function(remoteServerHost,remoteServerPort,username,password,initPath,passive){
		var loginInfo = {
				remoteServerHost:$.trim(remoteServerHost),
				remoteServerPort:$.trim(remoteServerPort),
				username:$.trim(username),
				password:$.trim(password),
				initPath:$.trim(initPath),
				passive:$.trim(passive)
		};
		
		return $http.post("../default/login.aspx",loginInfo);
	}
});