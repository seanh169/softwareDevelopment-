<template>

	<div id="wrapp">
	<div :id="color">
		<span>{{color}}</span>



	</div>	
	</div>	





</template>
	



<script>
	
export default {
	name: 'box',
	props: {
		color: String
	}

}




</script>
<style scoped>

  #wrapp {
  	padding: 10px;
  }
	#green {
		background-color: green;
		width: 200px;
		height: 100px;

		/*display: inline-flex;*/
	}
	#yellow{
		background-color: yellow;
		width: 200px;
		height: 100px;
		/*display: inline-flex;*/
	}
	#red{
		background-color: red;
		width: 200px;
		height: 100px;
		/*display: inline-flex;*/
	}





</style>