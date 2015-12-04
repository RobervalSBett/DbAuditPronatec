angular.module('app').directive('ngCpfValidator',function (){
    return {
        restrict:'A',
        require:'ngModel',
        link:function($scope, $element, $attrs, ngModel){
           $scope.$watch($attrs.ngModel, function(value){
            if (value){
               if (value.match(/(\d{3})(\d{3})(\d{3})(\d{2})/g))                
            }
            else{
             //setar invalido   
            }                 
           })           
        }        
    }
})