<template>
  <div>
    <p>Game of Life</p>
    <Board v-bind:width="2" v-bind:height="2" v-bind:aliveCells="[[0,0], [0,1]]"/>
  </div>
</template>

<script>
import Board from "@/components/Board.vue"

export default {
  name: 'App',
  components: {
    Board
  }
}

</script>


<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  /* -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px; */
}
</style>
