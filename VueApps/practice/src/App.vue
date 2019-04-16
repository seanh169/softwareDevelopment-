<template>
  <div id="app">

    <div id="wrapper">
      
      <box color="yellow" />
      <box color="green" />
      <box color="red" />
    </div>
    <!-- <HelloWorld v-if="this.show" msg="Welcome to Your Vue.js App"/> -->
  </div>
</template>

<script>
// import HelloWorld from './components/HelloWorld.vue'
import box from './components/Box.vue';

export default {
  name: 'app',
  data: function(){
    return {
      show: true
    }
  },
  
    
  components: {
    box
  }
}
</script>

<style scoped>

#wrapper {

  -webkit-box-sizing: border-box;
  -moz-box-sizing: border-box;
  box-sizing: border-box;
  display: flex;
  
  /*flex-direction: column;*/
  flex-wrap: wrap;

}
/*#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}*/


</style>
