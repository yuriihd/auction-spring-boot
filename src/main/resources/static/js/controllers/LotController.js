/**
 * Created by Yurii on 02.04.2017.
 */



app.controller('lotController', function ($rootScope, $scope, $location,$http) {

        var url = 'http://localhost:8060';

        $scope.lots=[];

        $scope.name = undefined;
        $scope.topic = undefined;
        $scope.description = undefined;
        $scope.price = undefined;
        $scope.endDate = undefined;

        $scope.canProceed = true;

        $http.get(url+'/lots').success(function (data) {
        $scope.lots=data;
        })


        // $scope.removeTask = function (id) {
        //     problemService.removeTask(id)
        // };


        $scope.addLot = function () {

            return $http.post(url+'/addLot',
                {
                name: $scope.name,
                topic: $scope.topic,
                description : $scope.description,
                price : $scope.price,
                endDate : $scope.endDate
                })
                .then(function (response) {
                $location.path("/myLots");
            }).catch(function (response) {
                $scope.canProceed = false;
            })
        };



    $scope.search = function (searchable) {

        $http.get(url+'/lots/'+searchable).success(function (data) {
            $scope.lots=data;
        })

    };





    });

