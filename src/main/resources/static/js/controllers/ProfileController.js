/**
 * Created by Yurii on 02.04.2017.
 */



app.controller('profileController', function ($rootScope, $scope, $location,$http) {

    var url = 'http://localhost:8060/users';

    $scope.user = undefined;


    $http.get(url+'/user').success(function (data) {
        $scope.user=data;
    })


});

