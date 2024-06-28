<template>
   <div>
      <v-row no-gutters>
         <HorarioCalendar class="w-100"/>
      </v-row>
      <v-row>
         <v-col cols="7">
            <EspecialidadComp class="ma-2"/>
         </v-col>
         <v-divider vertical class="my-5"></v-divider>
         <v-col>
            <CitaForm class="ma-5"/>
         </v-col>
      </v-row>
   </div>
</template>

<script lang="js" setup>
   import EspecialidadComp from '@/components/EspecialidadComp.vue';
   import HorarioCalendar from '@/components/HorarioCalendar.vue';

</script>
