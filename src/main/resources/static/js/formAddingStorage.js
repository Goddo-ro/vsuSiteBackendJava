const title = document.getElementById("title");
const price = document.getElementById("price");
const description = document.getElementById("description");

if (localStorage.getItem("title") !== null) {
    title.value = localStorage.getItem("title");
}

if (localStorage.getItem("price") !== null) {
    price.value = localStorage.getItem("price");
}

if (localStorage.getItem("description") !== null) {
    description.value = localStorage.getItem("description");
}

title.addEventListener("input", (e) => {
    localStorage.setItem("title", title.value);
})

price.addEventListener("input", (e) => {
    localStorage.setItem("price", price.value);
})

description.addEventListener("input", (e) => {
   localStorage.setItem("description", description.value);
});