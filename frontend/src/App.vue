<template>
  <div id="app">
    <h1>Game of Life</h1>
    <Board
      v-bind:height="4"
      v-bind:width="4"
      v-bind:aliveCells="[
        [0, 0],
        [0, 1],
		[2,3]]"
    />
  </div>
</template>

<script>
import "./App.scss"
import Board from "@/components/organism/Board.vue";

export default {
  name: "App",
  components: {
    Board,
  },
};
</script>
