const imageInput = document.getElementById("image");
const image = document.getElementById("img-preview");

imageInput.onchange = e => {
    const [file] = imageInput.files;
    if (file) {
        image.src = URL.createObjectURL(file);
    }
}