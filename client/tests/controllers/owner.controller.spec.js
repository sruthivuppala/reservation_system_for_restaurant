/**
 * Created by vsrut on 28-01-2016.
 */

(function(){

    describe('Owner Controller - ', function(){

        beforeEach(module('restaurant'));

        beforeEach(inject(function($controller){
            owner = $controller('OwnerController');
        }));

        it('should be defined', function(){
            console.log(owner);
            expect(owner).toBeDefined();
        });

        it('authenticate the administrator', function(){
            owner.emailid = "abcd@123.com";
            owner.passwd = "abcd";
            owner.verifyOwner();

            expect(owner.loginsuccessful).toEqual(true);
        });
    });

})();