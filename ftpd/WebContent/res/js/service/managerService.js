app.service("managerService",function($http){
	
	this.init = function(first){
		if(first){
			return this.reflush();
		}
		return $http.get("../default/init.aspx");
	}
	this.rename = function(name,path){
		return $http.get("../manager/rename.aspx?name="+name+"&path="+path);
	}
	this.download = function(fileNode){
		return $http({
			url:"../manager/download.aspx",
			method:"post",
			data:fileNode,
			headers: {
			   "Content-type": "application/json"
			},
			responseType: "arraybuffer"
		});
	}
	this.reflush = function(){
		return $http.get("../manager/reflush.aspx");
	}
	this.enterPath = function(fileNode){
		return $http.post("../manager/enterPath.aspx",fileNode);
	}
	this.previous = function(){
		return $http.get("../manager/previous.aspx");
	}
});