import { render } from "@testing-library/vue";
import Board from "@/components/Board";

test("displays a board according to its width and height", () => {
    const {getByRole, getAllByRole, getAllByText} = render(Board, {
        props:
            {
                width: 2,
                height: 2,
                aliveCells: [[0,0], [0,1]]
            }
    })

    expect(getByRole("table"))
    expect(getAllByRole("row").length === 6)
    expect(getAllByRole("columnheader").length === 5)
    expect(getAllByText("alive").length === 2)
})

test("displays error message when an input is invalid", () => {
    const {getByText} = render(Board, {
        props:
            {
                width: 5,
                height: 6,
                aliveCells: [[0,0], [0,1]]
            }
    })

    expect(getByText("Could not load Board. Width and Height don't match."))
})