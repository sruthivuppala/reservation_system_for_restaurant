/**
 * Created by vsrut on 28-01-2016.
 */

(function(){

    describe('Cancel Reservation - ', function(){

        var service, cancelR,

                reservation_ID = "FF0000";

        beforeEach(module('restaurant'));

        beforeEach(inject(function($controller, dataService, $q, $rootScope){
            service = dataService;

            var defer = $q.defer();

            defer.resolve(reservation_ID);

            spyOn(service, 'cancelBooking').and.returnValue(defer.promise);

            cancelR= $controller('CancelReservation', {'dataService': service});

            $rootScope.$apply();
        }));

        it('should be defined',function(){
            expect(cancelR).toBeDefined();
        });

    });

})();