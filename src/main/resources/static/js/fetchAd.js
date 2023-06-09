setInterval(fetchData, 6000);

function fetchData() {
    fetch("/advertisement/randomAd")
        .then(response => response.text())
        .then(html => {
            let adItem = document.getElementById("ad");
            adItem.classList.remove("show");
            adItem.classList.add("hide");
            wait2s().then(() => {
                adItem.innerHTML = html;
                adItem.classList.remove("hide");
                adItem.classList.add("show");
            }).catch(_ => 
                console.warn("Error while fetching advertisement"));
        })
        .catch(_ => {
            console.error("Error while fetching advertisement");
        });
}

function sleep(ms) {
    return new Promise(resolve => setTimeout(resolve, ms));
}
  
async function wait2s() {
  await sleep(2000);
}
