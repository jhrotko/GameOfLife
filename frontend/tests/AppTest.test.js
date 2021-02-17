import { render } from "@testing-library/vue"
import App from "@/App";

test('increments value on click', async () => {
    const {getByText} = render(App)

    getByText("Game of Life")
})