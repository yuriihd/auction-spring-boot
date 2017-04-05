/**
 * Created by Yurii on 05.04.2017.
 */
var app = angular.module("Auction",[]);
app.controller('loginController', ["$http", "$scope", "$location",
    function ($http, $scope) {

        var url = "http://localhost:8070";

        $scope.username = undefined;
        $scope.password = undefined;
        $scope.fullName = undefined;


        $scope.login = function () {
            return $http.post(url + '/login', {username: $scope.username, password: $scope.password}).then(function () {
                $location.path("#/problems");
            }).catch(function (){
                $scope.canProceed = false;
            })
        };

        $scope.signUp = function () {
            confirm("Ok");
            return $http.post(url + '/registration',
                {
                    username: $scope.username,
                    password: $scope.password,
                    name: $scope.fullName,
                })
                .then(function (response) {
                    $location.path("#/problems");
                }).catch(function (response){
                    $scope.canProceed = false;
                })
        };



    }]);