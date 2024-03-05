<template>
  <div id="app">
    <header class="colapse">
      <!-- <carousel /> -->
    </header>
    <main>
      <content-vue />
    </main>
  </div>
</template>

<script>
import carousel from "./components/Carousel.vue";
import contentVue from "./components/Content.vue"

export default {
  data() {
    return {};
  },
  components: {
    carousel,
    contentVue
  },
};
</script>

<style>
/* .colapse {
  width: 360px;
  height: auto;
} */
</style>