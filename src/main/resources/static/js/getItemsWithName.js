const getItemsWithName = (id) => {
    fetch(`/${id}/names`).then(
        response => response.text())
        .then(
            html => {
                let item = document.getElementById(`${id}`);
                if (item.options.length != 0) {
                    let selectedIndex = item.selectedIndex;
                    item.innerHTML = html;
                    item.selectedIndex = selectedIndex;
                } else {
                    item.innerHTML = html;
                }
        })
        .catch(_ => console.warn(`Items by id:${id} are not loaded`));
}