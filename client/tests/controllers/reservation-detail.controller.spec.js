/**
 * Created by vsrut on 28-01-2016.
 */

(function(){

    describe('Reservation Detail Ctrl - ', function(){

        var service, rDetail,
            detail =[
                {
                    id: "FF001",
                    name: "ABCD"
                }
            ];

        beforeEach(module('restaurant'));

        beforeEach(inject(function($controller, dataService, $q, $rootScope){
            service = dataService;

            var defer = $q.defer();

            defer.resolve(detail);

            spyOn(service, 'getUserById').and.returnValue(defer.promise);

            rDetail = $controller('ReservationDetail', {'dataService': service});

            $rootScope.$apply();
        }));

        it('should be defined',function(){
            expect(rDetail).toBeDefined();
        });

        it('should create a reservation', function(){
            expect(rDetail.detail.length).toEqual(1);
        });

    });

})();