<template>
  <div class="login">
    <h1>Notification Manager</h1>
    <div class="g-signin2" data-onsuccess="onSignIn" data-theme="dark"></div>
  </div>
</template>

<script>
export default {
  name: 'login',
  data: function() {
    function onSignIn(googleUser) {
      console.log('Google Auth Response', googleUser);
      // We need to register an Observer on Firebase Auth to make sure auth is initialized.
      var unsubscribe = firebase.auth().onAuthStateChanged(function(firebaseUser) {
        unsubscribe();
        // Check if we are already signed-in Firebase with the correct user.
        if (!isUserEqual(googleUser, firebaseUser)) {
          // Build Firebase credential with the Google ID token.
          var credential = firebase.auth.GoogleAuthProvider.credential(
              googleUser.getAuthResponse().id_token);
          // Sign in with credential from the Google user.
          firebase.auth().signInWithCredential(credential).catch(function(error) {
            // Handle Errors here.
            var errorCode = error.code;
            var errorMessage = error.message;
            // The email of the user's account used.
            var email = error.email;
            // The firebase.auth.AuthCredential type that was used.
            var credential = error.credential;
            // ...
          });
        } else {
          console.log('User already signed-in Firebase.');
        }
      });
    }
  }
}
</script>

<style scoped>

</style>
