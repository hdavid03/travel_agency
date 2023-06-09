function editItem() {
    let button = document.getElementById("editButton");
    if (button.innerHTML === "Szerkesztés") {
        Array.from(document.getElementsByTagName("input"))
        .filter(input => input.type == "text")
        .forEach(
            inputText => inputText.disabled = false
        );

        button.innerHTML = "Jóváhagy";
    } else {
    Array.from(document.getElementsByTagName("input"))
    .filter(inputText => inputText.type == "text")
    .forEach(
        inputText => inputText.disabled = true
    );
    button.innerHTML = "Szerkesztés";
    }
}

function updateItem() {
    Array.from(document.getElementsByTagName("input")).forEach(
        inputText => {
            let inputText = document.createElement("inputText");
            inputText.innerHTML = inputText.innerHTML;
            inputText.replaceWith(inputText);
        }
    );
    document.getElementById("saveEdit").submit();
    return false;
}