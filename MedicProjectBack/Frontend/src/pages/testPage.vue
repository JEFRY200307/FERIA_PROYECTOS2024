<template>

   <div>
   <v-sheet class="custom-sheet pa-5" align="center">
      <div class="contenido">
         <v-card-title 
      class="font-weight-black text-h2 mt-5 pb-0" 
      style="color: #4D112C;"
      >Test de Prevención de la Salud</v-card-title>
      <v-sheet class="ma-16 sheet-table"
      max-width="1000"
      >
         <v-card-text>
            <span class="font-weight-bold">INDICACIONES: </span>   
            Realiza el test con honestidad respondiendo a las preguntas planteadas, en paralelo suma el puntaje obtenido en cada pregunta hasta terminar el test y obtener un resultado final.
            <p class="font-weight-bold text-h5 my-3" style="color: #8E344D;">¡Comencemos!</p>
         </v-card-text>
         <TestTable />
      </v-sheet>
      </div>
   </v-sheet>
   </div>
</template>

<style scoped>
.contenido{
   position: relative;
   z-index: 1; 
   padding: 16px; 
}
.custom-sheet {
   position: relative;
   background: white;
   overflow: hidden; 
}

.custom-sheet::before {
   content: "";
   position: absolute;
   top: 0;
   left: 0;
   right: 0;
   height: 25%; 
   background: url("@/assets/svg.png") no-repeat center center; 
   background-size: cover; 
}
.sheet-table{
   background-color: rgba(255, 255, 255, 0.8);
}
</style>

<script setup>
import TestTable from '@/components/TestTable.vue';
</script>