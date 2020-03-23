var first = false;
function getScope(controllerName){
	var appElement = document.querySelector('[ng-controller='+controllerName+']');
	var $scope = angular.element(appElement).scope(); 
	return $scope;
}