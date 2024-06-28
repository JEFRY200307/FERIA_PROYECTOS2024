<template>
   <v-container >   
      <v-img :src="UsrImg" class="img-profile mt-5 "></v-img>
      <v-card-title class="text-center font-weight-black ma-0 pa-0"> {{ rol }} </v-card-title>  
      <v-card-title class="text-center font-weight-black"> {{ UsrName }} </v-card-title>  
      <v-card-title class="text-center font-weight-black ma-0 pa-0"> {{ UsrLastname }} </v-card-title>  
      <v-card-text class="ma-auto text-start">
         <v-card-text class="font-weight-black pb-0">Información personal</v-card-text>
         <v-card-text class="font-weight-bold pb-0">Correo institucional</v-card-text>
         <v-card-text class="pt-0 pb-0"> {{ UsrEmail }}</v-card-text>
         <v-card-text class="font-weight-bold pb-0">Numero telefónico</v-card-text>
         <v-card-text class="pt-0 pb-0">{{ UsrPhone }}</v-card-text>
         <v-card-text class="font-weight-bold pb-0">País</v-card-text>
         <v-card-text class="pt-0 pb-0">{{ UsrCountry }}</v-card-text>
         <v-card-text class="font-weight-bold pb-0">Ciudad</v-card-text>
         <v-card-text class="pt-0 pb-0">{{ UsrCity }}</v-card-text>
      </v-card-text>
   </v-container>

</template>

<style scoped>
   .img-profile{
      width: 218px;
      height: 218px;
      gap: 0px;
      border-radius: 45px;
      opacity: 0px;
      margin:auto
   }


</style>

<script setup>

defineProps(['rol','UsrName', 'UsrLastname', 'UsrEmail', 'UsrPhone', 'UsrCountry', 'UsrCity', 'UsrImg']);


</script>