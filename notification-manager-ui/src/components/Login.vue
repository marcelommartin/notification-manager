<template>
  <div class="login">          
      <!-- Google sign-in holder -->            
      <div class="g-signin2" data-onsuccess="onSignIn"></div>
  </div>
</template>

<script>
export default {
  name: 'login',
  methods: {    
    onSignIn: function (googleUser) {
      var profile = googleUser.getBasicProfile();
      console.log('ID: ' + profile.getId()); // Do not send to your backend! Use an ID token instead.
      console.log('Name: ' + profile.getName());
      console.log('Image URL: ' + profile.getImageUrl());
      console.log('Email: ' + profile.getEmail()); // This is null if the 'email' scope is not present.
      var id_token = googleUser.getAuthResponse().id_token;
      console.log("ID Token: " + id_token);
    }    
  }
}
</script>

<style scoped>
h1, h2 {
  font-weight: normal;
}

ul {
  list-style-type: none;
  padding: 0;
}

li {
  display: inline-block;
  margin: 0 10px;
}

a {
  color: #42b983;
}
</style>
