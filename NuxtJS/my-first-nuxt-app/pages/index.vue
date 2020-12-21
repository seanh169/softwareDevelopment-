<template>
  <div class="container">
    <h1>Hello, I am a nuxt js app</h1><br>
    <!-- <a href="/users">Users</a> -->
    <nuxt-link to="/users">Users</nuxt-link><br>
    <button @click="navigateProducts">Navigate to Products</button>
  </div>
</template>

<script>
export default {

  data() {
    return {

    }
  },
  methods : {
    navigateProducts ()  {
      this.$router.push("/products")
    }
  },
}
</script>

<style>
.container {
  margin: 0 auto;
  min-height: 100vh;
  /* display: flex; */
  justify-content: center;
  align-items: center;
  text-align: center;
}

.title {
  font-family:
    'Quicksand',
    'Source Sans Pro',
    -apple-system,
    BlinkMacSystemFont,
    'Segoe UI',
    Roboto,
    'Helvetica Neue',
    Arial,
    sans-serif;
  display: block;
  font-weight: 300;
  font-size: 100px;
  color: #35495e;
  letter-spacing: 1px;
}

.subtitle {
  font-weight: 300;
  font-size: 42px;
  color: #526488;
  word-spacing: 5px;
  padding-bottom: 15px;
}

.links {
  padding-top: 15px;
}
</style>
