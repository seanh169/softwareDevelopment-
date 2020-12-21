<template>
    <h1>Single User :  {{ $route.params.id }} </h1>
</template>

<script>
    export default {
        validate (data) {
            return !isNaN(parseFloat(data.params.id)) && isFinite(data.params.id);
        },
        layout: 'users'
    }
</script>

<style scoped>
    

    



</style>