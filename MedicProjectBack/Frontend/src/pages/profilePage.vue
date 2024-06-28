<template>
   <v-div>
   <!--Dialogs -->
   <DialogConfirmation 
   v-if="showFirstDialog"  
   @open-confimation-dialog="openConfirmationDialog" 
   @close-dialog="closeDialog"
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
         <v-col>
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


         <!-- Próximas citas -->
         <v-col class="pa-0 py-3">
            <v-card-title class="font-weight-black text-h5 color-title">
            Próximas citas
            </v-card-title>
            <v-card-subtitle opacity="1" class="font-weight-bold mb-4 color-subtitle">
               Podrás cancelar hasta 3h antes de tu cita
            </v-card-subtitle>

            <!-- FIX: max-height -->

            <v-sheet
            class="overflow-y-auto my-2"
            max-height="35rem"
            >  
               <v-col
               class="pa-0"
               v-for="cita in citasDetail"
               :key="cita.id">
                     <CitaCard
                        v-if="cita.cita"
                        :day="cita.day"
                        :hour="cita.hour"
                        :DoctorName="cita.doctor"
                        :category="cita.category"
                        :iconColor="cita.isAv"
                        :cita="cita.cita"
                        class="ma-5 elevation-5"
                        @cancelarCita="openFirstDialog"
                     />
               </v-col>
            </v-sheet>
         </v-col>

         <!-- Historial de citas  -->
         <v-col class="pa-0 py-3">
            <v-card-title class="font-weight-black text-h5 color-title">
            Historial de citas
            </v-card-title>
            <v-sheet
            class="overflow-y-auto my-2"
            max-height="35rem"
            >  
               <v-col
               class="pa-0"
               v-for="cita in citasDetail"
               :key="cita.id">
                     <CitaCard
                     v-if="!cita.cita"
                     :day="cita.day"
                     :hour="cita.hour"
                     :DoctorName="cita.doctor"
                     :category="cita.category"
                     :isAvailable="cita.isAv"
                     :cita="cita.cita"
                     class="ma-5 elevation-5"
                     />
               </v-col>
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
import CitaCard from '@/components/CitaCard.vue';
import UsuarioInfo from '@/components/UsuarioInfo.vue';
import { ref } from 'vue';

const showFirstDialog = ref(false);
const showSecondDialog = ref(false);

function openFirstDialog() {
   showFirstDialog.value = true;
}

function openConfirmationDialog() {
   showFirstDialog.value = false;
   showSecondDialog.value = true;
}

function closeAllDialogs() {
   showFirstDialog.value = false;
   showSecondDialog.value = false;
   
}
function closeDialog() {
  showFirstDialog.value = false;
}

const userinfo = ref({
   rol:'Alumno',
   name: 'Juan',
   lastname: 'Perez',
   img: "./src/assets/profile.png",
   email: 'example@gmail.com',
   phone: '1234567890',
   country: 'Perú',
   city: 'Lima',
});


const citasDetail =ref([
   {
      id:1,
      day: '27 Mayo',
      hour: '10:00 am',
      doctor: 'Dr. Juan Perez',
      category: 'Cardiología',
      color: "success",
      cita: true
   },
   {
      id:2,
      day: '28 Mayo',
      hour: '11:00 am',
      doctor: 'Dr. Juan Perez',
      category: 'Cardiología',
      color: 'error',
      cita: false

   },
   {
      id:3,
      day: '29 Mayo',
      hour: '12:00 am',
      doctor: 'Dr. Juan Perez',
      category: 'Cardiología',
      color: 'success',
      cita: true
   },
   {
      id:4,
      day: '30 Mayo',
      hour: '01:00 pm',
      doctor: 'Dr. Juan Perez',
      category: 'Cardiología',
      color: 'success',
      cita: false
   },
   {
      id:5,
      day: '31 Mayo',
      hour: '02:00 pm',
      doctor: 'Dr. Juan Perez',
      category: 'Cardiología',
      color: 'error',
      cita: true
   },
   {
      id:6,
      day: '01 Junio',
      hour: '03:00 pm',
      doctor: 'Dr. Juan Perez',
      category: 'Cardiología',
      color: 'success',
      cita: true
   }
])



</script>