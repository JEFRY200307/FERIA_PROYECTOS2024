<template>
   <v-sheet class="ma-auto">
         <v-container class="ma-auto">
         <v-row align="center">
            <v-col align-self="center" class="pa-2 ma-2">
                  <v-form 
                  class="text-start pa-8 mx-auto"
                  @submit.prevent="handleSubmit">
                     <v-img src="@/assets/centroMedicoIcon.png" class="LogoCentro"></v-img>
                     <v-card-text class="textLogin">Código UNI</v-card-text>
                     <v-text-field 
                     hide-details="auto" 
                     v-model="username" 
                     variant="solo" 
                     label="Ingrese su código UNI"></v-text-field>
                     <v-card-text class="textLogin">Contraseña</v-card-text>
                     <v-text-field v-model="password" variant="solo" label="Ingrese su contraseña" type="password"></v-text-field>
                     <v-row class="ma-2 w-100 h-100" align="center" align-content="space-between" justify="center">
                        <v-btn type="submit" class="btnColor mx-2" align="center" rounded="xl" size="large">Iniciar sesión</v-btn>
                        <v-btn to="/" rounded="xl" variant="outlined" align="center" class="mx-2">Regresar</v-btn>
                     </v-row>
                  </v-form>
            </v-col> 
            <v-divider class="my-5 divider" inset vertical></v-divider>
            <v-col class="pa-2 ma-2">
               <v-sheet class="text -center">
                  <v-card-title class="text-center subtitleCard">¿No tienes cuenta?</v-card-title>
                  <v-card-subtitle class="text-center subtitleCard">Contáctanos</v-card-subtitle>
                  <v-list class="text-start">
                     <v-list-item
                     v-for="item in ContactanosData.items"
                     :key="item.text"
                     color="transparent"
                     class="mx-16 pa-0">
                     <v-list-item-title color="transparent" class="text-center">
                        <a :href="item.href" class="spanText">{{ item.text }}</a>
                     </v-list-item-title>   
                     </v-list-item>
                  </v-list>
               </v-sheet>
            </v-col>
         </v-row>
      </v-container>
   </v-sheet>
</template>

<script setup>
import { ref } from 'vue';
import { useRouter } from 'vue-router';
import validUsers from '@/components/variablesJSON/Usuarios.json';
const username = ref('');
const password = ref('');
const router = useRouter();
const handleSubmit = () => {
   const user = validUsers.find(
      (u) => u.username === username.value && u.password === password.value
   );

   if (user) {
      localStorage.setItem('user', JSON.stringify(user)); // Guarda el usuario en el almacenamiento local
      router.push('/'); // Redirige a la página de inicio
   } else {
      alert('Usuario o contraseña incorrectos');
   }
};

const ContactanosData =ref(
   {title: 'Contáctanos',
   items: [
      { text: 'Telefono', href: '#'},
      { text: 'Celulares',href:'#'},
      { text: 'Correo',href:'#'},
      { text: 'Horario de atención',href:'#'}]
   })
</script>


<style scoped>
.subtitleCard{
   font-family: "Montserrat", sans-serif;
   font-optical-sizing: auto;
   font-weight: 700;
   font-style: normal;
   font-size: 24px;
   line-height: 24px;
   text-align: center;
}
.v-card-text.textLogin{
   font-family: "Montserrat", sans-serif;
   font-optical-sizing: auto;
   font-weight: 700;
   font-style: normal;
   font-size: 16px;
   line-height: 24px;
   text-align: left;
}

.divider{
   border: 0.5px solid #E1C48C
}

.spanText{
   text-decoration: none;
   color: black;
   font-family: "Montserrat", sans-serif;
   font-weight: 400;
   line-height: 24px;
   font-size: 16px;
   text-align: center;
}

.LogoCentro{
   width:280px ;
   height: 115px;
   margin: auto;
}
.btnColor{
   background-color: #8E344D;
   color: white;
   font-weight: 700;
   text-transform: none;
}
</style>
