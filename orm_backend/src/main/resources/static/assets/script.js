var editable = {
    // (A) PROPERTIES
    selected: null, // current selected cell
    value: "", // current selected cell value

    // (B) "CONVERT" TO EDITABLE CELL
    edit: cell => {
        // (B1) REMOVE "DOUBLE CLICK TO EDIT"
        cell.ondblclick = "";

        // (B2) EDITABLE CONTENT
        cell.contentEditable = true;
        cell.focus();

        // (B3) "MARK" CURRENT SELECTED CELL
        cell.classList.add("edit");
        editable.selected = cell;
        editable.value = cell.innerHTML;

        // (B4) PRESS ENTER/ESC OR CLICK OUTSIDE TO END EDIT
        window.addEventListener("click", editable.close);
        cell.onkeydown = evt => {
            if (evt.key == "Enter" || evt.key == "Escape") {
                editable.close(evt.key == "Enter" ? true : false);
                return false;
            }
        };
    },

    // (C) END "EDIT MODE"
    close: evt => {
        if (evt.target != editable.selected) {
            // (C1) CANCEL - RESTORE PREVIOUS VALUE
            if (evt === false) {
                editable.selected.innerHTML = editable.value;
            }

            // (C2) REMOVE "EDITABLE"
            window.getSelection().removeAllRanges();
            editable.selected.contentEditable = false;

            // (C3) RESTORE CLICK LISTENERS
            window.removeEventListener("click", editable.close);
            let cell = editable.selected;
            cell.onkeydown = "";
            cell.ondblclick = () => editable.edit(cell);

            // (C4) "UNMARK" CURRENT SELECTED CELL
            editable.selected.classList.remove("edit");
            editable.selected = null;
            editable.value = "";

            // (C5) DO WHATEVER YOU NEED
            if (evt !== false) {
                console.log(cell.innerHTML);
                // check value?
                // send value to server?
                // update calculations in table?
            }
        }
    }
};

// (D) INITIALIZE - DOUBLE CLICK TO EDIT CELL
window.addEventListener("DOMContentLoaded", () => {
    for (let cell of document.querySelectorAll(".editable td")) {
        cell.ondblclick = () => editable.edit(cell);
    }
});