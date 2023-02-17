const items = document.getElementsByClassName("item-card");
const searchBar = document.getElementById("search");

searchBar.addEventListener("input", (event) => {
    const search = searchBar.value;

    for (let i = 0; i < items.length; i++) {
        const item = items[i];
        const title = item.querySelector(".coffee-title").innerHTML;

        if (!title.toLowerCase().includes(search.toLowerCase())) {
            item.style.display = "none";
        } else {
            item.style.display = "block";
        }
    }
});