<template>
      <v-card class="pa-5 rounded-xl">
            <v-row no-gutters>
               <v-col cols="3" class="pa-2 text-center">
                  <p class="font-weight-bold text-h4 text-break pa-0">{{ dayNumber }}</p>
                  <p class="font-weight-bold text-h6 text-break pa-0 text-uppercase">{{ monthShort }}</p>
               </v-col>
               <v-col class="ma-2 pa-0">
                  <v-card-text class="pa-0 font-weight-bold text-category"> {{ category }}</v-card-text>
                  <v-card-text class="pa-0 font-weight-regular">{{ DoctorName }}</v-card-text>
                  <v-card-text class="pa-0"> <v-icon icon="mdi-information" size="x-small" :color=iconColor ></v-icon> {{ hour }} </v-card-text>
               </v-col>
            </v-row>
            <v-row no-gutters align="center">
            <v-btn class="btnAgendar" 
            block
            v-if="showButton"
            @click ="$emit('cancelarCita')"
            >Cancelar cita</v-btn>
            </v-row>
         </v-card>
   </template>

   <style scoped>
   .btnAgendar{
      background-color: #8E344D;
      color: white;
   }
   .text-category{
      color: #E1C48C;
   }
   </style>

<script setup>

import { computed } from 'vue';

defineEmits(['cancelarCita']);

const props = defineProps(['day', 'category', 'DoctorName','iconColor','hour','cita']);

const dayNumber = computed(() => {
   return props.day.split(' ')[0];
});

const monthShort = computed(() => {
   const month = props.day.split(' ')[1];
   return month.substring(0, 3);
});

const showButton = computed(() => {
   return props.cita;
});




</script>