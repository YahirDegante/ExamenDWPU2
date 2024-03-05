<template>
  <div>
    <b-modal id="modal-1" v-model="modalShow" title="Editar libro">
      <div>
        <b-form>
          <b-form-group
            id="input-group-1"
            label="Nombre del libro:"
            label-for="input-1"
          >
            <b-form-input
              id="input-1"
              v-model="libro.nombre"
              type="text"
              placeholder="Nombre del libro"
              required
            ></b-form-input>
          </b-form-group>
        </b-form>
        <b-card class="mt-3" header="Form Data Result">
          <pre class="m-0">{{ libro }}</pre>
        </b-card>
      </div>
    </b-modal>
  </div>
</template>

<script>
export default {
  props: {
    modalShow: {
      type: Boolean,
      required: true,
      default: true,
    },
  },
  data() {
    return {
      libro: {
        nombre: "",
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
