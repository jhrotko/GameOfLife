<template>
  <div v-if="error === undefined">
    <table>
    <tbody>
    <tr v-for="h in height" :key="h">
      <th v-for="w in width" :key="w">
        <div v-if="h < aliveCells.length && w < aliveCells[h].length && aliveCells[h][w] === 1">
          <div class="alive">alive</div>
        </div>
      </th>
    </tr>
    </tbody>
  </table>
  </div>
  <div v-else>
    <p>{{error}}</p>
  </div>
</template>

<script>

export default {
  name: "Board",
  props: ["width", "height", "aliveCells"],
  data: function() {
return {
      error: undefined
    };
},
  methods: {
    validateBoard() {
      if(this.height === this.aliveCells.length) {
        this.aliveCells.forEach(cell => {
          if((cell !== undefined && cell.length !== this.width) || cell === undefined) {
            this.error = "Could not load Board. Width and Height don't match."
          }
        })
      } else {
        this.error = "Could not load Board. Width and Height don't match."
      }
    }
  },
  beforeMount() {
    this.validateBoard()
  },
  computed: {
    console: () => console
  }
}

</script>

<style scoped>
  .alive {
    background-color: aqua;
  }
</style>