let currentDateTime = new Date().toISOString().slice(0, 16);
document.getElementById("departureTime").min = currentDateTime;
document.getElementById("arrivalTime").min = currentDateTime;

const checkMaxNumber = () => {
    let min = document.getElementById("minimumTraveller").value;
    let itemMax = document.getElementById("maximumTraveller");
    itemMax.value = (itemMax.value < min) ? min : itemMax.value;
}

const checkMinNumber = () => {
    let itemMin = document.getElementById("minimumTraveller");
    itemMin.value = (itemMin.value < "2") ? "2" : itemMin.value;
}

const checkArrivalTime = () => {
    let departureTimeItem = document.getElementById("departureTime");
    let arrivalTimeItem = document.getElementById("arrivalTime");
    if (departureTimeItem.value > arrivalTimeItem.value) {
        let date = new Date(departureTimeItem.value);
        date.setDate(date.getDate() + 1);
        arrivalTimeItem.value = date.toISOString().slice(0, 16);
    }
}