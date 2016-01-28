/**
 * Created by vsrut on 28-01-2016.
 */

(function(){

    describe('Create Reservation - ', function(){

        var service, createR;

        beforeEach(module('restaurant'));

        beforeEach(inject(function($controller, dataService, $q, $rootScope){
            service = dataService;

            var defer = $q.defer();

            defer.resolve();

            spyOn(service, 'addBooking').and.returnValue(defer.promise);

            createR= $controller('CreateReservation', {'dataService': service});

            $rootScope.$apply();
        }));

        it('should be defined',function(){
            expect(createR).toBeDefined();
        });

    });

})();