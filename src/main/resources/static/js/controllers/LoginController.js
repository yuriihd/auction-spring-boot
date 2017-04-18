/**
 * Created by Yurii on 05.04.2017.
 */
app.controller('loginController', ["$http", "$scope", "$location",
    function ($http, $scope,$location) {

        var url = "http://localhost:8060";

        $scope.id = undefined;
        $scope.username = undefined;
        $scope.password = undefined;
        $scope.name = undefined;
        $scope.surname = undefined;
        $scope.email = undefined;


        $scope.canProceed = true;

        $scope.login = function () {
            return $http.post(url + '/login', {username: $scope.username, password: $scope.password}).then(function () {
                $location.path("/allLots");
            }).catch(function (){
                $scope.canProceed = false;
            })
        };

        $scope.signUp = function () {

            return $http.post(url + '/registration',
                {
                    username: $scope.username,
                    password: $scope.password,
                    name: $scope.name,
                    surname: $scope.surname,
                    email:$scope.email,
                })
                .then(function (response) {
                    $location.path("/allLots");
                }).catch(function (response){
                    $scope.canProceed = false;
                })
        };



    }]);