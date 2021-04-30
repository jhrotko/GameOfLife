<template>
  <div v-if="error === undefined">
    <table class="board">
      <tbody>
        <tr v-for="(i, h) in height" :key="i">
          <th v-for="(j, w) in width" :key="j">
            <div class="alive" v-if="cells[h][w] === 1">
              <td>alive</td>
            </div>
            <div class="dead" v-else>
              <td>dead</td>
            </div>
          </th>
        </tr>
      </tbody>
    </table>
  </div>
  <div v-else>
    <p>{{ error }}</p>
  </div>
</template>

<script>
import "./Board.scss";

export default {
  name: "Board",
  props: ["height","width", "aliveCells"],
  data: function () {
    return {
      error: undefined,
      cells: [],
    };
  },
  methods: {
    validateBoard() {
      if (this.height === this.aliveCells.length) {
        this.aliveCells.forEach((cell) => {
          if (
            (cell !== undefined && cell.length == this.width) ||
            cell === undefined
          ) {
            this.error = "Could not load Board. Width and Height don't match.";
          }
        });
      } else {
        this.error = "Could not load Board. Width and Height don't match.";
      }
    },
    prepareBoard() {
      this.cells = Array.from(Array(this.height), () => new Array(this.width));

      this.aliveCells.forEach((alive) => {
        this.cells[alive[0]][alive[1]] = 1;
      });
    },
  },

  beforeMount() {
    // this.validateBoard();
    this.prepareBoard();
  },
  computed: {
    console: () => console,
  },
};
</script>