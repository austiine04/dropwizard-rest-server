var app = angular.module('restaurant', []);

app.service('MenuItemsService', function ($http) {

    return {
        get: function () {
            return $http.get('/api/menu_items');
        },

        create: function (menuItem) {
            return $http.post('/api/menu_items', menuItem);
        }
    }
});

app.controller('MenuItemsController', function ($scope, MenuItemsService) {

    MenuItemsService.get().then(function (response) {
        $scope.menuItems = response.data;
    });

    $scope.createItem = function () {
        $scope.menuItems.push($scope.item);
        MenuItemsService.create($scope.item);
    };

});