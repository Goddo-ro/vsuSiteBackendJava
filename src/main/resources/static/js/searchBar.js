const items = document.getElementsByClassName("item-card");
const searchBar = document.getElementById("search");

const selectItems = (search) => {
    for (let i = 0; i < items.length; i++) {
        const item = items[i];
        const title = item.querySelector(".coffee-title").innerHTML;

        if (!title.toLowerCase().includes(search.toLowerCase())) {
            item.style.display = "none";
        } else {
            item.style.display = "block";
        }
    }
}

if (localStorage.getItem("search") !== null) {
    searchBar.value = localStorage.getItem("search");
    selectItems(searchBar.value);
}

searchBar.addEventListener("input", (event) => {
    const search = searchBar.value;
    localStorage.setItem("search", search);

    selectItems(search);
});
