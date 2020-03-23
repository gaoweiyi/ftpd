app.controller("managerController",function($scope,$controller,$window,managerService){
	/**
	 * 基本操作
	 */
	
	$scope.init = function(){
		managerService.init(first).success(function(data){
			first = true;
			$scope.fileNodes = data;
		}).error(function(){
			alert("ERROR!");
		});
	}
	$scope.rename = function(){
		var name = $.trim($("#newFileName").val());
		var path = $.trim($("#filePath").val());
		managerService.rename(name,path).success(function(data){
			if(data.message=="123456789"){
				window.location.reload(true);
			}else{
				alert("修改失败");
			}
		});
	}
	
	$scope.reflush = function(fileNodes,serverReload){
		if(serverReload){
			$scope.fileNodes = managerService.reflush();
		}
		$("#rename-modal").hide();
		$scope.fileNodes = data.fileNodes;
	}
	$scope.enterPathOrDownloadFile = function(fileNode){
		var type = fileNode.type;
		if(type==1){
			managerService.enterPath(fileNode).success(function(data){
				$scope.fileNodes = data;
			});
		}else{
			managerService.download(fileNode).success(function (data, status, headers, config) {
				var blob = new Blob([data], {type: "application/octet-stream"});
			    var objectUrl = URL.createObjectURL(blob);
			 //   objectUrl = objectUrl.substr(0,objectUrl.lastIndexOf("/"))+"/"+fileNode.name;
			    location.href=objectUrl;
			}).error(function (data, status, headers, config) {
			    alert("无法下载");
			});
		}
	}
	$scope.previous = function(){
		managerService.previous().success(function(data){
			$scope.fileNodes = data;
		});
	}
	$scope.showRenameModal = function(index){
		var path  = $scope.fileNodes[index].path;
		var name = $scope.fileNodes[index].name;
		$("#newFileName").val(name);
		$("#filePath").val(path);
		$("#rename-modal").show();
	}
	$scope.showUploadModal = function(){
		$("#upload-modal").show();
	}
});