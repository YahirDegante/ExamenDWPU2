<template>
  <b-modal :id="modalId" :title="accion" @show="onShowModal">
    <component :is="componenteActivo" v-bind="$props"></component>
  </b-modal>
</template>

<script>
import FormCreateBook from './FormCreateBook.vue';
import FormEditBook from './FormEditBook.vue';

export default {
  props: ['modalId', 'accion', 'componenteActivo'],
  methods: {
    onShowModal() {
      this.$emit('show-modal');
    },
  },
  components: {
    FormCreateBook,
    FormEditBook
  }
}
</script>
