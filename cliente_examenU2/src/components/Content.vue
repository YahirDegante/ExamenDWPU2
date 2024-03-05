<template>
  <b-container class="mt-4">
    <b-row class="text-center">
      <b-col cols="9">
        <b-card
          title="Card Title"
          img-src="https://picsum.photos/600/300/?image=25"
          img-alt="Image"
          img-top
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

        <edit-book :modalShow="modalShow"/>
      </b-col>
      <b-col>
        <b-button class="mt-3" size="lg" variant="info" block
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
import actionsButtons from "./ActionsButtons.vue";
import EditBook from "./EditBook.vue";

export default {
  data() {
    return {
      libro: {},
      modalShow: false,
    };
  },
  components: {
    actionsButtons,
    EditBook,
  },
  methods: {
    startDrag(evt, item) {
      evt.dataTransfer.dropEffect = "move";
      evt.dataTransfer.effectAllowed = "move";
    },
    onDrop(evt, action) {
      if (action === 1) {
        this.modalShow = !this.modalShow;
      } else if (action == 2) {
        alert("delete");
      }
    },
  },
};
</script>

<style>
</style>