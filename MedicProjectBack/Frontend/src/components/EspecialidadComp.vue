<template>
   <v-container>
      <v-row no-gutters class="justify-space-between">
         <v-col
         v-for="especialidad in especialidades"
         :key="especialidad.id"
         cols="5"
         class="ma-auto"
         >
            <v-card class="my-2 pa-2" elevation="5">
               <v-row no-gutters justify="center">
                  <v-col cols="7">
                     <v-card-title class="text-h6 font-weight-bold ">{{ especialidad.nombre }}</v-card-title>
                     <v-card-text class="font-weight-bold">{{ especialidad.doctor }}</v-card-text>
                  </v-col>
                  <v-col align-self="center">
                     <v-btn class="btnVerHorario text-capitalize" rounded="xl"> Ver horario</v-btn>
                  </v-col>
               </v-row>
               <v-divider class=""></v-divider>
               <v-card-text class="px-5 py-2">{{ especialidad.correo }}</v-card-text>
            </v-card>
         </v-col>
      </v-row>
   </v-container>
</template>

<script lang="js" setup>

import { ref } from 'vue';

const especialidades = ref([
   { id: '1', nombre: 'Psicología', doctor: 'Dr. Marco Santa Cruz', correo: 'examplelargo@gmail.com'},
   { id: '2', nombre: 'Psicología', doctor: 'Dr. Marco Santa Cruz', correo: 'example@gmail.com'},
   { id: '3', nombre: 'Psicología', doctor: 'Dr. Marco Santa Cruz', correo: 'example@gmail.com'},
   { id: '4', nombre: 'Psicología', doctor: 'Dr. Marco Santa Cruz', correo: 'example@gmail.com'},
   { id: '5', nombre: 'Psicología', doctor: 'Dr. Marco Santa Cruz', correo: 'example@gmail.com'},
   { id: '6', nombre: 'Psicología', doctor: 'Dr. Marco Santa Cruz', correo: 'example@gmail.com'},
   { id: '7', nombre: 'Psicología', doctor: 'Dr. Marco Santa Cruz', correo: 'example@gmail.com'},
   { id: '8', nombre: 'Psicología', doctor: 'Dr. Marco Santa Cruz', correo: 'example@gmail.com'},
   { id: '9', nombre: 'Psicología', doctor: 'Dr. Marco Santa Cruz', correo: 'example@gmail.com'},
   { id: '10', nombre: 'Psicología',doctor: 'Dr. Marco Santa Cruz', correo: 'example@gmail.com'},
   { id: '11', nombre: 'Psicología',doctor: 'Dr. Marco Santa Cruz', correo: 'example@gmail.com'},
   { id: '12', nombre: 'Psicología',doctor: 'Dr. Marco Santa Cruz', correo: 'example@gmail.com'},
])
</script>

<style scoped>
.v-card-title {
   color: #E1C48C;
}



.v-btn.btnVerHorario {
   font-family: "Montserrat", sans-serif;
   font-weight: 700;
   background-color: #8E344D;
   color: white;
}
</style>