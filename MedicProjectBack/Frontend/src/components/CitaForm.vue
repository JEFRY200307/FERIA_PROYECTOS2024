<template>
   <v-card class="cita-form-card pa-5">
      <v-card-title class="title-cita-form ma-6">Configura tu Cita</v-card-title>
      <v-card-text>
         <v-form class="mx-8">
            <v-card-text class="title-field">Especialidad</v-card-text>
            <v-text-field variant="solo" > Psicología</v-text-field>

            <v-card-text class="title-field">Fecha de atención</v-card-text>
            <v-date-input 
            variant="solo" 
            readonly="true"
            prepend-icon=""
            v-model="dateSelected"
            @input="logDate"
            ></v-date-input>

            <v-card-text class="title-field">Médico</v-card-text>
            <v-combobox  
            variant="solo"
            :items="availableDoctors"
            item-text="name"
            item-value="name"
            v-model="selectedName"
            @change="onNameChange"
            :disabled="!dateSelected"
            ></v-combobox>

            <v-card-text class="title-field">Horario</v-card-text>
            <v-combobox 
            variant="solo"           
            :items="availableHours"
            v-model="selectedHorario"
            :disabled="!selectedName || !dateSelected || !isDoctorAvailable"
            @change="onNameChange"
            ></v-combobox>
         </v-form>
      </v-card-text>
      <v-card-text class="mx-auto text-center mb-5" >
         Al presionar “Agendar cita”, usted está accediendo a nuestros Términos de Servicio y Políticas Privadas
      </v-card-text>
      <v-card-actions align="center">
         <v-btn class="btnColor mx-auto" >Agendar Cita</v-btn>
      </v-card-actions>
      </v-card>
</template>

<style scoped>
.btnColor{
   font-family: 'Montserrat', sans-serif;
   font-weight: 700;
   background-color: #8E344D;
   color: white;
}
.title-field{
   font-family: 'Montserrat', sans-serif;
   font-size: 16px;
   font-weight: 700;
   line-height: 24px;
   color: #000000;
   text-align: start;
   padding: 0;
   margin-bottom: 1rem;
}

.cita-form-card{
   background-color: #E1C48C;
   border-radius: 45px;
}
.title-cita-form{
   font-family: 'Montserrat', sans-serif;
   font-size: 24px;
   font-weight: 900;
   line-height: 60.95px;
   text-align: center;
   color:#4D112C;
}
</style>


<script lang="js" setup>
import { ref, computed, onMounted } from 'vue';



const dateSelected = ref(null);
const selectedName = ref(null);
const selectedHorario = ref(null);


const jsonData = ref([]);


onMounted(async () => {
   try {
      const response = await fetch('/src/components/variablesJSON/HorarioMedicos.json'); 
      jsonData.value = await response.json();
   } catch (error) {
      console.error('Error al cargar los datos JSON:', error);
   }
});




const availableDoctors = computed(() => {
   if (!dateSelected.value) return [];
   const selectedDay = dateSelected.value.getDay();
   const dayName = ['Sunday', 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday'][selectedDay];
   return jsonData.value
      .filter(doctor => doctor.horarios.some(schedule => schedule.day === dayName))
      .map(doctor => doctor.name);
});

const availableHours = computed(() => {
   if (!selectedName.value || !dateSelected.value) return [];
   const doctor = jsonData.value.find(doc => doc.name === selectedName.value);
   if (!doctor) return [];

   const selectedDay = dateSelected.value.getDay();
   const dayName = ['Sunday', 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday'][selectedDay];
   
   const doctorSchedule = doctor.horarios.find(schedule => schedule.day === dayName);
   return doctorSchedule ? doctorSchedule.hours : [];
});

const isDoctorAvailable = computed(() => {
   if (!selectedName.value || !dateSelected.value) return false;
   const selectedDay = dateSelected.value.getDay();
   const dayName = ['Sunday', 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday'][selectedDay];
   const doctor = jsonData.value.find(doc => doc.name === selectedName.value);
   if (!doctor) return false;
   const doctorSchedule = doctor.horarios.find(schedule => schedule.day === dayName);
   return !!doctorSchedule;
});

function onNameChange() {
   selectedHorario.value = null;
}

</script>