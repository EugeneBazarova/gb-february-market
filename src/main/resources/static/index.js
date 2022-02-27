angular.module('app', []).controller('indexController', function ($scope, $http) {
    $scope.loadProducts = function () {
        $http.get('http://localhost:8081/febmarket/api/v1/products/').then(function (response) {
            $scope.productsList = response.data;
        });
    }

    $scope.showProductInfo = function (productId) {
        $http.get('http://localhost:8081/febmarket/api/v1/products/' + productId).then(function (response) {
            alert(response.data.info);
        });
    }

    $scope.deleteProductById = function (productId) {
        $http.delete('http://localhost:8081/febmarket/api/v1/products/' + productId).then(function (response) {
            $scope.loadProducts();
        });
    }

    $scope.addToCart = function (productId) {
        $http.get('http://localhost:8081/febmarket/api/v1/cart/' + productId).then(function (response) {
            $scope.loadCart();
        });
    }

    $scope.loadCart = function () {
        $http.get('http://localhost:8081/febmarket/api/v1/cart/').then(function (response) {
            $scope.cart = response.data;
        });
    }

    //TODO
    $scope.removeOneItem = function (productId){
        $http.delete('http://localhost:8081/febmarket/api/v1/cart/remove/'+ productId).then(function (response) {
            $scope.loadCart();
        });
    }


    $scope.deleteProductFromCart = function (productId){
        $http.delete('http://localhost:8081/febmarket/api/v1/cart/delete/'+ productId).then(function (response) {
            $scope.loadCart();
        });
    }

    $scope.clearCart = function () {
        if (confirm("Удалить все продукты из корзины?")) {
            $http.get('http://localhost:8081/febmarket/api/v1/cart/clear/').then(function (response) {
                $scope.loadCart();
            });
        }
    }

    $scope.loadProducts();
    $scope.loadCart();
});