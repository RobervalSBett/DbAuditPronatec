/* global angular */

angular.module('filters',[])
.filter('cpf', function (){
    return function (input){
        input = input.replace(/(\.|\/|\-)/g,"");
        return input.replace(/(\d{3})(\d{3})(\d{3})(\d{2})/g,"\$1.\$2.\$3\-\$4");
    };
})

.filter('cnpj', function (){
    return function (input){
            var str = input + '';
            str = str.replace(/\D/g, '');
            str = str.replace(/^(\d{2})(\d{3})(\d{3})(\d{4})(\d{2})/, '$1.$2.$3/$4-$5');
            /*str = str.replace(/^(\d{2})(\d)/, '$1.$2');
            str = str.replace(/^(\d{2})\.(\d{3})(\d)/, '$1.$2.$3');
            str = str.replace(/\.(\d{3})(\d)/, '.$1/$2');
            str = str.replace(/(\d{4})(\d)/, '$1-$2');*/
            return str;
        };
    })

.filter('cep', function (){
    return function (input){
        input = input.replace(/(\.|\/|\-)/g,"");
        return input.replace(/(\d{5})(\d{3})/g,"\$1-\$2");
    };
})

.filter('fone', function (){
    return function (input){
    var str = input + '';
    str = str.replace(/\D/g, '');
    
    if (str.length === 15) {
      str = str.replace(/^(\d{2})(\d{5})(\d{4})/, '($1) $2-$3');
    } else {
      str = str.replace(/^(\d{2})(\d{4})(\d{4})/, '($1) $2-$3');
    } 
    /*
    if (str.length === 11) {
      str = str.replace(/^(\d{2})(\d{5})(\d{4})/, '($1) $2-$3');
    } else {
      str = str.replace(/^(\d{2})(\d{4})(\d{4})/, '($1) $2-$3');
    }
    
    */
    return str;
    };
});