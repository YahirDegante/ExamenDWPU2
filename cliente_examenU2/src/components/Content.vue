<template>
  <b-container class="mt-4">
    <b-row class="text-center">
      <b-col cols="9">
        <b-card
          v-for="(libro, id) in libros"
          :key="id"
          :title="libro.titulo"
          tag="article"
          style="max-width: 20rem"
          class="mb-2"
          draggable
          @dragstart="startDrag($event, JSON.stringify(libro))"
        >
          <b-card-text>
            Some quick example text to build on the card title and make up the
            bulk of the card's content.
          </b-card-text>
        </b-card>
        <modal
          :modalId="'Modal'"
          :accion="accion"
          :componenteActivo="componenteActivo"
        />
      </b-col>
      <b-col>
        <b-button
          class="mt-3"
          size="lg"
          variant="info"
          @click="openModal('FormCreateBook', 'Registrar')"
          >Registrar</b-button
        >
        <div @drop="onDrop($event, 1)" @dragover.prevent @dragenter.prevent>
          <b-button class="mt-3" size="lg" variant="warning" block
            >Editar</b-button
          >
        </div>
        <div @drop="onDrop($event, 2)" @dragover.prevent @dragenter.prevent>
          <b-button class="mt-3" size="lg" variant="danger">Eliminar</b-button>
        </div>
      </b-col>
    </b-row>
  </b-container>
</template>

<script>
import Modal from "./Modal.vue";
import FormCreateBook from "./FormCreateBook.vue";
import FormEditBook from "./FormEditBook.vue";

import ServiceBook from "../services/ServiceBook";

export default {
  data() {
    return {
      libro: {},
      libros: [],
      accion: "Formulario",
      componenteActivo: null,
    };
  },
  components: {
    Modal,
    FormCreateBook,
    FormEditBook,
  },
  mounted() {
    this.obtenerLibros();
  },
  methods: {
    async obtenerLibros() {
      try {
        const data = await ServiceBook.obtenerLibros();
        this.libros = data;
      } catch (error) {
        console.log(error);
      }
    },
    startDrag(evt, item) {
      evt.dataTransfer.dropEffect = "move";
      evt.dataTransfer.effectAllowed = "move";
    },
    onDrop(evt, action) {
      if (action === 1) {
        this.openModal("FormCreateBook");
      } else if (action == 2) {
        alert("delete");
      }
    },
    openModal(componente, accion) {
      this.componenteActivo = componente;
      this.accion = accion;
      this.$bvModal.show("Modal");
    },
  },
};
</script>

<style></style>
