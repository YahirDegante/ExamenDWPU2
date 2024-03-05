<template>
  <b-form>
    <b-form-group
      id="input-group-1"
      label="Titulo del libro:"
      label-for="input-1"
      class="mb-3"
    >
      <b-form-input
        id="input-1"
        v-model="libro.titulo"
        type="text"
        placeholder="Titulo del libro"
        required
      ></b-form-input>
    </b-form-group>

    <b-form-group
      id="input-group-2"
      label="Autor del libro:"
      label-for="input-2"
      class="mb-3"
    >
      <b-form-input
        id="input-2"
        v-model="libro.autor"
        type="text"
        placeholder="Autor del libro"
        required
      ></b-form-input>
    </b-form-group>

    <b-form-group
      id="input-group-3"
      label="Fecha de publicación:"
      label-for="input-3"
      class="mb-3"
    >
      <b-form-input
        id="input-3"
        v-model="libro.fechaPublicacion"
        type="date"
        placeholder="Fecha de publicación"
        required
      ></b-form-input>
    </b-form-group>
    <b-button @click="onSubmit" type="submit" variant="primary"
      >Submit</b-button
    >
  </b-form>
</template>

<script>
import ServiceBook from "../services/ServiceBook";
export default {
  data() {
    return {
      libro: {
        titulo: "",
        autor: "",
        fechaPublicacion: "",
      },
    };
  },
  methods: {
    async onSubmit(event) {
      try {
        const response = await ServiceBook.registrarLibro(this.libro);
        console.log(response);
      } catch (error) {
        console.error(error);
      }
    },
    onReset(event) {
      event.preventDefault();
      // Reset our form values
      this.form.nombre = "";
      this.$nextTick(() => {
        this.show = true;
      });
    },
  },
};
</script>
