<template>
   <v-dialog v-model="dialog" max-width="500px">
      <v-card>
         <v-card-title class="headline">Estadistics Dialog</v-card-title>
         <v-card-text>
            <!-- Add your estadistics information here -->
            <p>Example estadistics information</p>
         </v-card-text>
         <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn color="primary" text @click="closeDialog">Close</v-btn>
         </v-card-actions>
      </v-card>
   </v-dialog>
</template>

<script setup>
import { ref } from 'vue';

const dialog = ref(true);


const closeDialog = () => {
   dialog.value = false;
};
</script>

<style scoped>
/* Add your custom styles here */
</style>