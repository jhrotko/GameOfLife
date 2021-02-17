<template>
    <table>
      <tbody>
      <tr v-for="h in height" :key="h">
        <th v-for="w in width" :key="w">
        </th>
      </tr>
      </tbody>
    </table>
</template>

<script>

export default {
  name: "Board",
  props: ["width", "height"]
}

</script>

<style scoped>

</style>