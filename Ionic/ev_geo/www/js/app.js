(function () {

	// Ionic Starter App

	// angular.module is a global place for creating, registering and retrieving Angular modules
	// 'starter' is the name of this angular module example (also set in a <body> attribute in index.html)
	// the 2nd parameter is an array of 'requires'
	angular
		.module('starter', ['ionic', 'ngCordova']);

	angular
		.module('starter')
		.config(function ($stateProvider, $urlRouterProvider) {

			$stateProvider
				.state('map-canvas', {
					url: '/',
					templateUrl: 'templates/map-canvas.html',
					controller: 'LocationCtrl'
				});

			$urlRouterProvider .otherwise("/");

		});

	angular
		.module('starter')
		.factory('GeoService', function ($ionicPlatform, $cordovaGeolocation) {

			var positionOptions = {
				timeout: 10000,
				enableHighAccuracy: true
			};

			return {
				getPosition: function () {
					return $ionicPlatform.ready()
						.then(function () {
							return $cordovaGeolocation.getCurrentPosition(positionOptions);
						})
				}
			};

		}); // GEOLOCATION SERVICE

	angular
		.module('starter')
		.controller('LocationCtrl', function ($scope, GeoService) {

			function showMap(coords) {
				var mapOptions = {
					center: {
						lat: coords.latitude,
						lng: coords.longitude
					},
					zoom: 8
				};
				
				var map = new google.maps.Map(document.getElementById('map-canvas'), mapOptions);

				//Wait until the map is loaded
				google.maps.event.addListenerOnce(map, 'idle', function () {

					var marker = new google.maps.Marker({
						map: map,
						animation: google.maps.Animation.DROP,
						position: new google.maps.LatLng(coords.latitude, coords.longitude)
					});

					var infoWindow = new google.maps.InfoWindow({
						content: "Here I am!"
					});

					google.maps.event.addListener(marker, 'click', function () {
						infoWindow.open(map, marker);
					});

				});
			}

			GeoService.getPosition()
				.then(function (position) {
					$scope.coords = position.coords;
					showMap(position.coords);
				}, function (err) {
					console.log('getCurrentPosition error: ' + angular.toJson(err));
				});

		}); // LOCATION CONTROLLER

	angular
		.module('starter')
		.run(function ($ionicPlatform) {
			$ionicPlatform.ready(function () {
				if (window.cordova && window.cordova.plugins.Keyboard) {
					// Hide the accessory bar by default (remove this to show the accessory bar above the keyboard
					// for form inputs)
					cordova.plugins.Keyboard.hideKeyboardAccessoryBar(true);

					// Don't remove this line unless you know what you are doing. It stops the viewport
					// from snapping when text inputs are focused. Ionic handles this internally for
					// a much nicer keyboard experience.
					cordova.plugins.Keyboard.disableScroll(true);
				}
				if (window.StatusBar) {
					StatusBar.styleDefault();
				}
			});
		}); // MODULE RUN

}()); // SELF EXECUTING FUNCTION

/*
.controller('GeoCtrl', function ($cordovaGeolocation) {

	var posOptions = {
		timeout: 10000,
		enableHighAccuracy: false
	};
	$cordovaGeolocation
		.getCurrentPosition(posOptions)
		.then(function (position) {
			var lat = position.coords.latitude
			var long = position.coords.longitude
		}, function (err) {
			// error
		});


	var watchOptions = {
		timeout: 3000,
		enableHighAccuracy: false // may cause errors if true
	};

	var watch = $cordovaGeolocation.watchPosition(watchOptions);
	watch.then(
		null,
		function (err) {
			// error
		},
		function (position) {
			var lat = position.coords.latitude
			var long = position.coords.longitude
		});


	watch.clearWatch();
	// OR
	$cordovaGeolocation.clearWatch(watch)
		.then(function (result) {
			// success
		}, function (error) {
			// error
		});
});
*/
