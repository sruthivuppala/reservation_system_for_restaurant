/**
 * Created by vsrut on 19-01-2016.
 */
(function() {
    'use strict';

angular
    .module('restaurant')
    .controller('OwnerController', OwnerController);

    OwnerController.$inject = ['$location'];

    function OwnerController($location){
    var owner = this;
    owner.loginpage = true;
    owner.loginsuccessful = false;

    owner.verifyOwner = verifyOwner;

        function verifyOwner(){
            if(owner.emailid ==="abcd@123.com" && owner.passwd=="abcd") {
                owner.loginpage = false;
                owner.loginsuccessful = true;
                console.log("success");
            }
            else{

                alert("Login unsuccessful.");
                owner.emailid="";
                owner.passwd="";
            }
        }
    }
})();