function editItem() {
    let button = document.getElementById("editButton");
    if (button.innerHTML === "Szerkesztés") {
        Array.from(document.getElementsByTagName("span"))
        .forEach(
            span => {
                let inputText = document.createElement("input");
                inputText.type = "text";
                inputText.value = span.innerHTML;
                span.replaceWith(inputText);
            }
        );

        button.innerHTML = "Mégse";
    } else {
    Array.from(document.getElementsByTagName("input"))
    .filter(inputText => inputText.type == "text")
    .forEach(
        inputText => {
            let span = document.createElement("span");
            span.innerHTML = inputText.value;
            inputText.replaceWith(span);
        }
    );
    button.innerHTML = "Szerkesztés";
    }
}

function updateItem() {
    Array.from(document.getElementsByTagName("input")).forEach(
        inputText => {
            let span = document.createElement("span");
            span.innerHTML = inputText.innerHTML;
            inputText.replaceWith(span);
        }
    );
    document.getElementById("saveEdit").submit();
    return false;
}