<template>
  <b-container class="mt-4">
    <b-row class="text-center mb-3">
      <b-col>
        <b-button class="mt-3" size="lg" variant="info" @click="ordenarPorAutor">Ordenar por Autor</b-button>
        <b-button class="mt-3 ml-2" size="lg" variant="info" @click="ordenarPorFecha">Ordenar por Fecha</b-button>
      </b-col>
    </b-row>

    <b-row class="text-center">
      <b-col cols="9">
        <b-card v-for="(libro, id) in libros" :key="id" :title="libro.titulo" tag="article" style="max-width: 20rem"
          class="mb-2" draggable @dragstart="startDrag($event, JSON.stringify(libro))">
          <p>Autor: {{ libro.autor }}</p>
          <p>Fecha de Publicación: {{ formatDate(libro.fechaPublicacion) }}</p>
          <b-card-text>
            Some quick example text to build on the card title and make up the
            bulk of the card's content.
          </b-card-text>

        </b-card>
        <modal :modalId="'Modal'" :accion="accion" :componenteActivo="componenteActivo" />
      </b-col>
      <b-col>
        <b-button class="mt-3" size="lg" variant="info"
          @click="openModal('FormCreateBook', 'Registrar')">Registrar</b-button>
        <div @drop="onDrop($event, 1)" @dragover.prevent @dragenter.prevent>
          <b-button class="mt-3" size="lg" variant="warning" block>Editar</b-button>
        </div>
        <div @drop="onDrop($event, 2, libro)" @dragover.prevent @dragenter.prevent>
          <b-button class="mt-3" size="lg" variant="danger" block @click="confirmarEliminar(libro)">Eliminar</b-button>
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
    formatDate(dateString) {
      const date = new Date(dateString);
      return date.toLocaleDateString('es-ES', { day: 'numeric', month: 'long', year: 'numeric' });
    },
    async obtenerLibros() {
      try {
        const data = await ServiceBook.obtenerLibros();
        this.libros = data.map((libro, index) => {
          return { ...libro, id: index + 1 };
        });
      } catch (error) {
        console.log(error);
      }
    },
    async ordenarPorAutor() {
      try {
        const librosOrdenados = await ServiceBook.getBooksByAutor();
        this.libros = librosOrdenados;
      } catch (error) {
        console.error(error);
      }
    },
    async ordenarPorFecha() {
      try {
        const librosOrdenados = await ServiceBook.getBooksByFecha();
        this.libros = librosOrdenados;
      } catch (error) {
        console.error(error);
      }
    },
    startDrag(evt, item) {
      evt.dataTransfer.dropEffect = "move";
      evt.dataTransfer.effectAllowed = "move";
    },
    async confirmarEliminar(libro) {
      try {
        console.log("Libro a eliminar:", libro);
        const confirmacion = confirm(
          "¿Estás seguro de que deseas eliminar este libro?"
        );
        if (confirmacion) {
          const libroId = libro.id || libro._id;
          console.log("ID del libro a eliminar:", libroId);
          await ServiceBook.confirmarEliminar(libroId);
          alert("Libro eliminado exitosamente");
          this.obtenerLibros();
        }
      } catch (error) {
        console.error("Error al eliminar el libro:", error);
      }
    },

    onDrop(evt, action, libro) {
      if (action === 1) {
        this.openModal("FormCreateBook", "Registrar");
      } else if (action === 2) {
        this.confirmarEliminar(libro);
      }
    },
    openModal(componente, accion) {
      this.componenteActivo = componente;
      this.accion = accion;
      this.$bvModal.show("Modal");
    },
  }
};

</script>

<style></style>
