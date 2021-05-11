module.exports = {
	preset: '@vue/cli-plugin-unit-jest',
	transform: {
		'^.+\\.vue$': 'vue-jest'
	},
	testMatch: [
		"./**/*.test.js"
	]
}
