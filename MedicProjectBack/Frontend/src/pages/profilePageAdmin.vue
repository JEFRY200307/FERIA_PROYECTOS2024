<template>
   <v-div>
   <!--Dialogs -->
   <estadisticsDialog 
   v-if="estadistics"  
   transition="fade-transition"
   />
   <DialogComplete 
   v-if="showSecondDialog" 
   @close-all-dialogs="closeAllDialogs"
   transition="fade-transition"/>
   <v-row class="justify-center">
   <v-col cols="10" class="my-8">
      <!--Principal-->
   <v-card class="mx-16 pa-5 elevation-5" >
      <v-row class="justify-center fill-height">

         <!-- Información del usuario -->
         <v-col cols="4">
            <UsuarioInfo
            :rol="userinfo.rol"
            :UsrName="userinfo.name"
            :UsrLastname="userinfo.lastname"
            :UsrEmail="userinfo.email"
            :UsrPhone="userinfo.phone"
            :UsrCountry="userinfo.country"
            :UsrCity="userinfo.city"
            :UsrImg="userinfo.img"
            />
         </v-col>


         <!-- Historial de citas  -->
         <v-col class="pa-0 py-3">
            <v-card-title class="font-weight-black text-h5 color-title">
            Historial de citas
            </v-card-title>
         <!-- add:function to load -->
            <v-text-field class="pa-0 mx-5 my-5"
               :loading="loading"
               append-inner-icon="mdi-magnify"
               density="compact"
               label="Buscar alumnos"
               variant="solo"
               hide-details
               single-line
               @click:append-inner="onClick">
            </v-text-field>

            <v-sheet
            class="overflow-y-auto"
            max-height="35rem"
            > 
            <v-row
            no-gutters>
            <v-col
               class="pa-2"   
               v-for="cita in citasDetail"
               :key="cita.id"
               cols="12"
               md="6">
                     <AlumnoCard
                     :codigoAlumno="cita.codigoAlumno"
                     :nombreAlumno="cita.nombreAlumno"
                     :correo="cita.correo"
                     class="ma-2 elevation-5 flex-grow-1"
                     @showEstadistics="estadistics = !estadistics"
                     @sancionar="sancionarDialog"
                     />
               </v-col>
            </v-row>
            </v-sheet>

         </v-col>
      </v-row>
   </v-card>
   </v-col>
   </v-row>
</v-div>
</template>



<style scoped>
.color-title{
   color: #4D112C;
}
.v-card-subtitle.color-subtitle{
   color: #8E344D;
}
/* Add your custom styles here */
</style>
<script setup>
import AlumnoCard from '@/components/AdminComponents/CitaAlumnos.vue';
import UsuarioInfo from '@/components/UsuarioInfo.vue';
import estadisticsDialog from '@/components/AdminComponents/estadisticaDialog.vue';
import { ref } from 'vue';


const estadistics=ref(false);



const userinfo = ref({
   rol: 'Administrador',
   name: 'Edward Javier',
   lastname: 'Oliva Lluen',
   img: "./src/assets/profile.png",
   email: 'example@gmail.com',
   phone: '1234567890',
   country: 'Perú',
   city: 'Lima',
});


const citasDetail =ref([
   {
      id:1,
      codigoAlumno: '20230170J',
      nombreAlumno: 'Juan Perez',
      correo: 'edward.oliva.l@uni.pe',
      citasAgendas:245,
      citasCanceladas:25,
      citasAsistidas:220,
      citasNoAsistidas:25,
   },
   {
      id: 2,
      codigoAlumno: '654321',
      nombreAlumno: 'Maria Lopez',
      correo: 'maria@example.com',
   },
   {
      id: 3,
      codigoAlumno: '987654',
      nombreAlumno: 'Pedro Ramirez',
      correo: 'pedro@example.com',
   },
   {
      id: 4,
      codigoAlumno: '456789',
      nombreAlumno: 'Ana Martinez',
      correo: 'ana@example.com',
   },
   {
      id: 5,
      codigoAlumno: '789123',
      nombreAlumno: 'Carlos Sanchez',
      correo: 'carlos@example.com',
   },
   {
      id: 6,
      codigoAlumno: '321654',
      nombreAlumno: 'Sofia Rodriguez',
      correo: 'sofia@example.com',
   },
   {
      id: 7,
      codigoAlumno: '159753',
      nombreAlumno: 'Luisa Gomez',
      correo: 'luisa@example.com',
   },
   {
      id: 8,
      codigoAlumno: '753159',
      nombreAlumno: 'Diego Torres',
      correo: 'diego@example.com',
   },
   {
      id: 9,
      codigoAlumno: '852741',
      nombreAlumno: 'Laura Ramirez',
      correo: 'laura@example.com',
   }
])



</script>