/**
 * Created by vsrut on 28-01-2016.
 */

(function(){

    describe('View Reservations Ctrl - ', function(){

        var service, viewR,
            reservations =[
                {
                    id: "FF001",
                    name: "ABCD"
                },
                {
                    id: "FF002",
                    name: "ABCD"
                }
            ];

        beforeEach(module('restaurant'));

        beforeEach(inject(function($controller, dataService, $q, $rootScope){
            service = dataService;

            var defer = $q.defer();

            defer.resolve(reservations);

            spyOn(service, 'getReservations').and.returnValue(defer.promise);

            viewR = $controller('ViewReservation', {'dataService': service});

            $rootScope.$apply();
        }));

        it('should be defined',function(){
            expect(viewR).toBeDefined();
        });

        it('should create a reservation', function(){
           expect(viewR.reservations.length).toEqual(2);
        });

    });

})();