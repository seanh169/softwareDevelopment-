<template>
    <div class="admin-post-page">
        <section class="update form">
            <AdminPostForm :post="loadedPost" @submit="editPost" />
        </section>
    </div>
    
</template>

<script>
import AdminPostForm from '~/components/Admin/AdminPostForm';

export default {
    components: {
        AdminPostForm
    },
    middleware: ['auth', 'check-auth'],
    async asyncData(context){
        try{    
            const singlePost = await context.app.$axios.$get('posts/' + context.params.postId + '.json');
            return { loadedPost: singlePost };
        }catch(e){
            console.log(e);
            context.error(e);
        }
        return {

        }
    },
    methods: {
        async editPost(postData) {
            try{
                await this.$store.dispatch('editPost', {postData: postData, id: this.$route.params.postId});
                this.$router.push('/admin');
            }catch(e){
                console.log(e)
            }
        }
    },
    layout: 'admin'
    
}
</script>

<style scoped>
.update-form {
  width: 90%;
  margin: 20px auto;
}
@media (min-width: 768px) {
  .update-form {
    width: 500px;
  }
}
</style>