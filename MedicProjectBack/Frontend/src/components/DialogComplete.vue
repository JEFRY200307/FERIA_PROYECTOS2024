<template>
      <v-dialog
      v-model="dialog"
      max-width="500"
      persistent
      transition="fade-transition"
      >
         <v-card
         class="rounded-lg pa-auto"
         transition="fade-transition">
            <v-row>
               <v-col align-self="start">
                  <v-card-title class="font-weight-bold"> Registro cancelado </v-card-title>
               </v-col> 
               <v-col cols="2" align-self="end">
               <v-btn icon="mdi-close-box" variant="text" align-self="end" style="color: #8E344D;"
               @click="closeAllDialogs"></v-btn>
            </v-col>   
            </v-row>
            <v-divider style="color: #8E344D;" :thickness="2" class="border-opacity-100" ></v-divider>
            
            <v-card-text class="pa-5 font-weight-regular">
               Tu cita se ha cancelado correctamente.
            </v-card-text>
               
            <v-row align="center ma-1">
               <v-btn
               class="rounded-xl font-weight-bold mx-auto my-4"
               style="background: #8E344D;
               color: white;"
               text="Aceptar"
               size="large"
               
               @click="closeAllDialogs"
               ></v-btn>
            </v-row>
         
         </v-card>
      </v-dialog>
</template>


<script setup>
import { ref } from 'vue';

const dialog = ref(true);
const emit = defineEmits(['close-all-dialogs']);

function closeAllDialogs() {
   emit('close-all-dialogs');
}
</script>
