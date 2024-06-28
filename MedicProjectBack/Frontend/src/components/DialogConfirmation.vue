<template>
   <v-dialog
   max-width="500"
   persistent
   v-model="dialog"
   transition="fade-transition">
         <v-card
         class="rounded-lg"
         >
         <v-row>
            <v-col align-self="start">
               <v-card-title class="font-weight-bold">Confirmar acción </v-card-title>
            </v-col>
            <v-col cols="2" align-self="end">
               <v-btn icon="mdi-close-box" variant="text" align-self="end" style="color: #8E344D;"
               @click="closeDialog"></v-btn>
            </v-col>   
         </v-row>
            <v-divider style="color: #8E344D;" :thickness="2" class="border-opacity-100" ></v-divider>
         <v-card-text class="pa-5 font-weight-regular">
            Tu cita quedará cancelada.
            <br>
            ¿Estás seguro de cancelar tu cita?
         </v-card-text>
         <v-row align="center ma-1">
            <v-col>
            <v-btn
               text="Sí"
               @click="openConfirmationDialog"
               block
               class="rounded-xl font-weight-bold"
               size="large"
               style="background: #8E344D;
               color: white;"
            ></v-btn>
         </v-col>
         <v-col>
            <v-btn
               block
               text="No"
               @click="closeDialog"
               class="rounded-xl font-weight-bold"
               size="large"
               style="background: #8E344D;
               color: white;"
            ></v-btn>
         </v-col>
         </v-row>
         </v-card>

   </v-dialog>

</template>


<script setup>
import { ref, watch } from 'vue';

const dialog = ref(true);

watch(() => dialog.value, (newValue) => {
  if (!newValue) emit('close-first-dialog');
});


const emit = defineEmits(['dialog2', 'dialog', 'close-all-dialogs']);

function openConfirmationDialog() {
  emit('open-confimation-dialog');
}
function closeDialog() {
  emit('close-dialog');
}
</script>