/**
 * Created by vsrut on 19-01-2016.
 */

(function(){
    'use strict';

    angular
        .module('restaurant')
        .service('dataService',dataService);

    dataService.$inject = ['$http','$q'];
    function dataService($http, $q){

        var self = this;

        self.getReservations = function(){

            var defer = $q.defer();

            $http
                .get('http://localhost:8080/Restaurant/api/reservations')
                .then(function(response){
                    console.log(response.data);
                    defer.resolve(response.data);
                }, function (error) {
                    defer.reject(error.status);
                });

            return defer.promise;
        };

        /*self.getCustomers = function(){
            var defer = $q.defer();

            $http
                .get('http://localhost:8080/Restaurant/api/customers')
                .then(function(response){
                    defer.resolve(response.data);
                }, function (error) {
                    defer.reject(error.status);
                });

            return defer.promise;
        };*/

        self.getUserById = function(id){
            var defer = $q.defer();

            $http
                .get('http://localhost:8080/Restaurant/api/customers/'+id)
                .then(function(response){
                    defer.resolve(response.data);
                }, function (error) {
                    defer.reject(error.status);
                });

            return defer.promise;
        };

        /*self.getCustomerById = function(id){
            var defer = $q.defer();

            $http
                .get('http://localhost:8080/Restaurant/api/customers/'+id)
                .then(function(response){
                    defer.resolve(response.data);
                }, function (error) {
                    defer.reject(error.status);
                });

            return defer.promise;
        };*/
        self.addBooking = function (viewR) {
            var defer = $q.defer();

            $http
                .post('http://localhost:8080/Restaurant/api/datainsert',viewR)
                .then(function(response){
                    defer.resolve(response.data);
                }, function (error) {
                    defer.reject(error.status);
                });
            return defer.promise;
        };

        self.cancelBooking = function (id) {
            var defer = $q.defer();

            $http
                .put('http://localhost:8080/Restaurant/api/reservations/'+id)
                .then(function(response){
                    defer.resolve(response.data);
                }, function (error) {
                    defer.reject(error.status);
                });
            return defer.promise;
        };
    }

})();
