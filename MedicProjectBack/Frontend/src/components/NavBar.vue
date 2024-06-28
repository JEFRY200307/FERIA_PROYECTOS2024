<template>
   <v-app-bar class="barColor" height="9px" app >
      <v-app-bar-nav-icon></v-app-bar-nav-icon>
      <v-toolbar-title class="titleBar">Centro Médico UNI</v-toolbar-title>
      <v-spacer></v-spacer>
      <v-btn to="/" class="txtBtnNav" @click="scrollToTop('/')" exact  >Inicio</v-btn>
      <v-btn to="/test" class="txtBtnNav" @click="scrollToTop('/test')" exact >Test</v-btn>
      <v-btn to="/horarios" class="txtBtnNav" @click="scrollToTop('/horarios')" exact >Horarios</v-btn>

      <!--Si está logeado-->
      <v-btn v-if="rol == 'user'" to="/horarios" class="txtBtnNav">
         Agendar cita
      </v-btn>

      <v-btn v-if="rol == 'admin'" to="/horarios" class="txtBtnNav">
         Editar horarios
      </v-btn>
      

      <!--Menu from avatar-->
      <v-menu v-if="user" size="32">
         <template v-slot:activator="{props}">
            <v-btn v-bind="props"
            size="large" 
            class="ma-3 mr-5" 
            append-icon="mdi-chevron-down">
               <template v-slot:prepend>
                  <v-avatar>
                     <img src='/src/assets/profile.png' alt="User" style="display: block; margin: 0 auto; width: 100%; height: 100%;">
                  </v-avatar>
               </template>
            </v-btn>
         </template>

         <v-list class="pa-0 mt-2">
            <v-list-item  class="pa-0">
               <v-btn flat block @click="toProfile">Perfil</v-btn>
            </v-list-item >
            <v-divider color="#8E344D" :thickness="5" class="border-opacity-100 pa-0 ma-0"></v-divider>
            <v-list-item class="pa-0">
               <v-btn flat block v-ripple.center  @click="logout">Cerrar Sesión</v-btn>
            </v-list-item>
         </v-list>
      </v-menu>

      <!--Si no está logeado-->
      <v-btn v-else rounded="xl" size="large" class="ma-3 btnColor" @click="$router.push('/login')">Iniciar Sesión</v-btn>
      </v-app-bar>
      </template>

   <script setup>
      import { ref } from 'vue';
      import { useRoute, useRouter} from 'vue-router';
      const router = useRouter();
      const $route = useRoute(); 
      const user = ref(JSON.parse(localStorage.getItem('user')));
      const rol = ref(user.value?.rol);
      const scrollToTop = (route) => {
      if ($route.path === route) {
         window.scrollTo({ 
            top: 0,
            behavior: 'smooth'
         });
      } else {
         window.scrollTo({top:0,behavior: 'smooth'});
      }
   };


      const logout = () => {
         localStorage.removeItem('user');
         user.value = null;
         router.push('/');
      };

      const toProfile = () => {
         if(rol.value == 'user'){
            router.push('/profile');
            window.scrollTo(
               {top:0,behavior: 'smooth'}
            );
         }else if(rol.value == 'admin'){
            router.push('/adminProfile');
            window.scrollTo(
               {top:0,behavior: 'smooth'}
            );
         }else{
            router.push('/doctorProfile');
            window.scrollTo(
               {top:0,behavior: 'smooth'}
            );
         }
      };
   </script>




<style scoped>

.v-btn[to] {
   scroll-behavior: smooth;
}

/* Add custom styles here */
.v-app-bar.barColor {
   background-color: #FFFFFF;
   color: black;
   font-family: "Montserrat", sans-serif;
   font-optical-sizing: auto;
   font-weight: 700;
}

.v-toolbar-title.titleBar {
   font-family: "Montserrat", sans-serif;
   font-optical-sizing: auto;
   font-weight: 900;
   font-style: normal;

}

.btnColor{
   background-color: #8E344D;
   color: white;
   font-weight: 700;
   text-transform: none;
}

.txtBtnNav{
   font-weight: 700;
   text-transform: none;
}
v-btn{
  background-color: #f5f5f5 !important; /* Color de fondo para el botón activo */
  color: #000000 !important; /* Color del texto para el botón activo */
}
</style>