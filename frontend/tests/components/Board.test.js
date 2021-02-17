import {render} from "@testing-library/vue";
import Board from "@/components/Board";

test("displays a board according to its width and height", () => {
    const {getByRole, getAllByRole} = render(Board, {
        props:
            {
                width: 5,
                height: 6
            }
    })

    expect(getByRole("table"))
    expect(getAllByRole("row").length === 6)
    expect(getAllByRole("columnheader").length === 5)
})