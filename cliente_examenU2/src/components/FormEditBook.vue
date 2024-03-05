<template>
  <div>
    <b-form>
      <b-form-group
        id="input-group-1"
        label="Nombre del libro:"
        label-for="input-1"
        class="mb-3"
      >
        <b-form-input
          id="input-1"
          v-model="libro.nombre"
          type="text"
          placeholder="Nombre del libro"
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
          v-model="libro.fecha"
          type="date"
          placeholder="Fecha de publicación"
          required
        ></b-form-input>
      </b-form-group>
    </b-form>
  </div>
</template>

<script>
export default {
  data() {
    return {
      libro: {
        nombre: "",
        autor: "",
        fecha: "",
      },
    };
  },
  methods: {
    onSubmit(event) {
      event.preventDefault();
      alert(JSON.stringify(this.libro));
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
