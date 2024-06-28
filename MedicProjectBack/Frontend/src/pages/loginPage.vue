<template> 
<div>
      <v-img src="@/assets/fondoLogin.png" class="h-screen" cover>
         <v-container class="pa-2">
            <v-row no-gutters class="h-screen">
               <v-col align-self="center">
                  <LoginForm />
               </v-col>
            </v-row>
         </v-container>
      </v-img>
</div>
</template>
<style scoped>
.BgImg {
   width: 1440px;
   height: 1024px;
}

</style>

<script setup>
import LoginForm from '@/components/LoginForm.vue';

</script>