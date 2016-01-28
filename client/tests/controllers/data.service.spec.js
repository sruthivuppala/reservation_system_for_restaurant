/**
 * Created by vsrut on 28-01-2016.
 */

(function(){

    describe('Data Service: ', function(){

        var httpBackend,
            dataService;

        beforeEach(module('restaurant'));

        beforeEach(inject(function($injector,$httpBackend){
            dataService = $injector.get('dataService');
            httpBackend = $httpBackend;
        }));

        it('gets all the users', function(){
            httpBackend.expectGET('http://localhost:8080/Restaurant/api/reservations').respond(200,[{},{}]);

            dataService.getReservations().then(function (results) {
                expect(result.length).toEqual(2);
            })
        });

        it('gets a specific customer information', function(){
            httpBackend.expectGET('http://localhost:8080/Restaurant/api/reservations/FF1601').respond(200,[{}]);

            dataService.getReservations().then(function (results) {
                expect(result.length).toEqual(1);
            })
        });

        it('creates a reservation', function(){
            httpBackend.expectPOST('http://localhost:8080/Restaurant/api/reservations',{}).respond(200,[{}]);

            dataService.getReservations().then(function (results) {
                expect(result.length).toEqual(1);
            })
        });

        it('cancels a reservation', function(){
            httpBackend.expectPUT('http://localhost:8080/Restaurant/api/reservations/FF1601').respond(200,[]);

            dataService.getReservations().then(function (results) {
                expect(result.length).toEqual(0);
            })
        });

    });

})();