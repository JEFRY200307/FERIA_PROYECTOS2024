<template>

  <v-footer
    class="NewFooter"
    app
    bottom
    absolute
  >
  <v-row align="start" no-gutters>
    <v-col
    v-for="data in footerData"
    :key="data.id"
    cols="12"
    md="4"
    align-self="start">
    <v-sheet class="pa-5 ma-5 ml-14">
      <h2 class="titleColor">{{ data.title }}</h2>
      <v-list color="black">
        <v-list-item
        v-for="item in data.items"
        :key="item.text"
        color="transparent"
        >
        <v-list-item-title color="transparent">
          <a class="AStyle" :href="item.href">{{ item.text }}</a>
        </v-list-item-title>
        </v-list-item>
      </v-list>
    </v-sheet>
    </v-col>
  </v-row>
  </v-footer>    
  
</template>


<script setup>

import { ref } from 'vue'

const footerData = ref([
  { id:'1',
    title: 'Conócenos',
    items: [
      { text: 'Información breve', href: '#'},
      { text: 'Dirección',href: '#'},]
  },
  { id:'2',
    title: 'Contáctanos',
    items: [
      { text: 'Telefono', href: '#'},
      { text: 'Celulares',href:'#'},
      { text: 'Correo',href:'#'},
      { text: 'Horario de atención',href:'#'}],
  },
  { id:'3',
    title: 'Síguenos',
      items: [
      { text: 'Facebook', href: '#' },
      { text: 'Instagram', href: '#' },
      { text: 'YouTube', href: '#' },]
  }
])

</script>


<style scoped>
.v-footer.NewFooter{
  background-color: #171717;
}

.titleColor{
  color: white;
}

.listColor{
  background-color: #171717;
}

.v-sheet{
  background-color: transparent;
}

.v-list, .v-list-item {
  background-color: transparent;
}


.AStyle{
  color: white;
  text-decoration: none;
}
</style>