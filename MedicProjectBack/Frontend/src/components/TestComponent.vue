<template>
   <v-card flat color="white" class="pa-8 rounded-0 align-items-center elevation-0" width="100%" height="100%" image="@/assets/svg.png" > 
      <div class="ma-5">
         <v-card-title class="textTitle text-center">Test de Prevención de la Salud</v-card-title>
         <v-card-subtitle class="text-h5 text-center ma-5 ">Gratis | Sin registro previo | Rápido y accesible</v-card-subtitle>
      </div>
      <v-row class="ma-8 my-14" no-gutters>
         <v-col
         v-for="card in advantagesCards"
         :key="card.title"
         cols="12"
         md="4"
         >
         <v-card
            class="ma-auto h-100 w-100"
            max-width="350"
            outlined
            color= "rgba(255, 255, 255, 0.8)"
         >
            <v-card-title class="text-center mx-auto">
               <v-card class="rounded-circle mx-auto text-center my-3 cardId">{{ card.id }}</v-card>
            </v-card-title>
            <v-card-text class="pa-3 px-7 text-center">{{ card.description }}</v-card-text>
         </v-card>
         </v-col>
      </v-row>
      <v-card-actions class="d-flex justify-center ma-8">
         <v-btn rounded="xl" size="x-large" class="my-5 pa-2 btnColor" @click="scrollToTopAndRedirect('/test')">Comenzar test</v-btn>
      </v-card-actions>
   </v-card>
</template>

<script lang="js" setup>
import { ref } from 'vue'
import { useRouter } from 'vue-router'

const advantagesCards = ref([
   {
   id: '1',
   title: 'Objetivo 1',
   description: 'Especialidad médica que se ocupa del estudio, diagnóstico y tratamiento de las enfermedades del corazón y del aparato circulatorio.',
   },
   {
   id: '2',
   title: 'Objetivo 2',
   description: 'Especialidad médica que se encarga del estudio de la estructura y función de la piel, así como de las enfermedades que la afectan, su diagnóstico, prevención y tratamiento.',
   },
   {
   id: '3',
   title: 'Objetivo 3',
   description: 'Especialidad médica que se encarga del estudio de la estructura y función de la piel, así como de las enfermedades que la afectan, su diagnóstico, prevención y tratamiento.',
   },
])


const router = useRouter()

const scrollToTopAndRedirect = (path) => {
   window.scrollTo(0, 0)
   router.push(path)
}
</script>

<style scoped>
.cardId{
   background-color: #4D112C;
   color: white;
   font-family: "Montserrat", sans-serif;
   font-weight: 900;
   font-size: 50px;
   width: 88px;
   height: 88px;
   line-height: 60.95px;
   border-radius: 50%;
   display: flex;
   justify-content: center;
   align-items: center;
}
.svg-container {
   display: flex;
   align-items: flex-start;
}
.btnColor{
   background-color: #8E344D;
   color: white;
   font-weight: 700;
   text-transform: none;
}
.textSubtitle{
   font-family: "Montserrat", sans-serif;
   font-optical-sizing: auto;
   font-weight: 400;
   font-style: normal;
   font-size: 24  px;
   color: #4D112C;

}
.back {
   position: absolute;
   margin: 0%;
   top: 0;
   left: 0;
   z-index: -1;


}
.textTitle{

   font-family: "Montserrat", sans-serif;
   font-optical-sizing: auto;
   font-weight: 900;
   font-style: normal;
   font-size: 50px;
   color: #4D112C;
   line-height: 60.95px;
}
</style>