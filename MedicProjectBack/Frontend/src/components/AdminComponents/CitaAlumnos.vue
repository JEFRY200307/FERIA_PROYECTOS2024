<template>
      <v-card class="pa-5 rounded-xl">
            <v-row no-gutters>
               <v-col cols="6" class="pa-0 my-auto text-start justify-center">
                  <p class="font-weight-bold text-break pa-0 text-category">{{ codigoAlumno }}</p>
                  <p class="font-weight-bold text-break pa-0">{{ nombreAlumno }}</p>
                  <p class="text-caption pa-0">{{ correo }}</p>
               </v-col>
               <v-col cols="6" class="pa-0">
                  <v-btn rounded="lg" 
                  class="ma-2 pa-2 font-weight-bold text-capitalize btn-estadistica"
                  block
                  @click="$emit('showEstadistics')">Ver estadísticas</v-btn>
                  <v-btn rounded="lg" 
                  class="ma-2 pa-2 btn-sancionar font-weight-bold text-capitalize" 
                  block
                  @click="$emit('sancionar')"
                  >Sancionar</v-btn>
               </v-col>
            </v-row>
         </v-card>
   </template>

   <style scoped>
   v-btn{
      font-family: 'Montserrat', sans-serif;
      
   }
   .btn-estadistica{
      background-color: #E1C48C;
      color: #4D112C;
      font-family: 'Montserrat', sans-serif;
   }
   .btn-sancionar{
      background-color: #8E344D;
      color: white;
      font-family: 'Montserrat', sans-serif;
   }
   .text-category{
      color: #E1C48C;
   }
   </style>

<script setup>


defineEmits(['showEstadistics', 'sancionar']);

defineProps(['codigoAlumno', 'nombreAlumno', 'correo']);





</script>