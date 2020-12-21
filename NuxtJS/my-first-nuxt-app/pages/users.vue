<template>
    <div>
    <!-- <h3>Users Page</h3> -->
    
        <input type="text" v-model="userId">
        <button @click="onLoadUser">Load User</button>
        <nuxt-child />
        <!-- </input>  -->

    </div>

</template>

<script>
    export default {
        data() {
            return {
                userId: ''
            }
        },
        methods: {
            onLoadUser() {
                this.$router.push('/users/' + this.userId)
            }
        },
        layout: 'users'
    }
</script>