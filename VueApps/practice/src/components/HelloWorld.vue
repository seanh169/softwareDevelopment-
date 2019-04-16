<template>
  <div>
    <h1>{{msg}}</h1>
    <button class="btn btn-primary" v-on:click="togglebut">Toggle Loading</button><br>
    <!-- <span v-if="toggle == true">HEY</span><br> -->
    <transition name="fade">
    <span v-if="!toggle" class="loading"></span>
    </transition>
  </div>
</template>

<script>
export default {
  name: 'HelloWorld',
  data(){
    return {
      toggle: true
    };
  },
  props: {
    msg: String
  },
  methods: {
    // var vm = this;
    togglebut: function(){

      this.toggle = !this.toggle;
    
     
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
* {
  box-sizing: border-box;
}
.fade-enter-active, .fade-leave-active {
  transition: opacity .5s;
}
.fade-enter, .fade-leave-to /* .fade-leave-active below version 2.1.8 */ {
  opacity: 0;
}
.loading {
  height: 0;
  width: 0;
  padding: 15px;
  border: 6px solid #ccc;
  border-right-color: #888;
  border-radius: 22px;
  -webkit-animation: rotate 1s infinite linear;
  /* left, top and position just for the demo! */
  position: absolute;
  left: 49.3%;
  top: 25%;
}

@-webkit-keyframes rotate {
  /* 100% keyframe for  clockwise. 
     use 0% instead for anticlockwise */
  100% {
    -webkit-transform: rotate(360deg);
  }
}

</style>
