<template>
	<div class="row">
		<div class="col-sm-12">
			<h3 class="jumbotron text-center">Quotes - Add your favorite Quotes!</h3>
			<h5 class="text-center">Quotes(10 max)</h5>
			<div class="progress">
		 		<div class="progress-bar" role="progressbar" aria-valuenow="70"
		  		aria-valuemin="0" aria-valuemax="100" :style="{width: (quoteCount / maxQuotes)*100+'%'}">
		    			{{quoteCount}} / {{maxQuotes}}
		  		</div>
			</div>



		</div>





	</div>
	

</template>


<script>

	export default {
		props: ['quoteCount', 'maxQuotes']
	}
	
</script>


<style>
	


</style>