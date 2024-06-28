<template>
  <v-app class="myfont">
    <v-toolbar v-if="$route.path !== '/login'" app>
    <NavBar />
    </v-toolbar>
    <v-main>
        <router-view class="ma-auto" v-slot="{ Component }">
          <Transition>
            <component :is="Component" />
          </Transition>
        </router-view>
      <AppFooter v-if="$route.path !== '/login'" />
    </v-main>
  </v-app>
</template>

<script setup>
  import NavBar from '@/components/NavBar.vue';
  import AppFooter from '@/components/AppFooter.vue';
</script>

<style>

@import url('https://fonts.googleapis.com/css2?family=Montserrat:ital,wght@0,100..900;1,100..900&display=swap');

.body{
  background-color: white;
  font-family: 'Montserrat', sans-serif;
}

.v-enter-active,
.v-leave-active {
  transition: opacity 0.8s ease;
}

.v-enter-from,
.v-leave-to {
  opacity: 0;
  }
</style>