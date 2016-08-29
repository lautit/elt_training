angular
	.module('controllers', [])

angular
	.module('controllers')
	.controller('LoginCtrl', function ($scope, $state, UserService, $ionicLoading) {
		// This method is executed when the user press the "Sign in with Google" button
		$scope.googleSignIn = function () {
			$ionicLoading.show({
				template: 'Logging in...'
			});

			window.plugins.googleplus.login({},
				function (user_data) {

					UserService.setUser({
						userID: user_data.userId,
						name: user_data.displayName,
						email: user_data.email,
						picture: user_data.imageUrl,
						accessToken: user_data.accessToken,
						idToken: user_data.idToken
					});

					$ionicLoading.hide();
					$state.go('app.home');
				},
				function (msg) {
					$ionicLoading.hide();
				}
			);
		};
	});

angular
	.module('controllers')
	.controller('AppCtrl', function ($scope) {

	});

angular
	.module('controllers')
	.controller('HomeCtrl', function ($scope, UserService, $ionicActionSheet, $state, $ionicLoading) {
		$scope.user = UserService.getUser();

		$scope.showLogOutMenu = function () {
			var hideSheet = $ionicActionSheet.show({
				destructiveText: 'Logout',
				titleText: 'Are you sure you want to logout?',
				cancelText: 'Cancel',
				cancel: function () {},
				buttonClicked: function (index) {
					return true;
				},
				destructiveButtonClicked: function () {
					$ionicLoading.show({
						template: 'Logging out...'
					});
					// Google logout
					window.plugins.googleplus.logout(
						function (msg) {
							console.log(msg);
							$ionicLoading.hide();
							$state.go('login');
						},
						function (fail) {
							console.log(fail);
						}
					);
				}
			});
		};
	});
