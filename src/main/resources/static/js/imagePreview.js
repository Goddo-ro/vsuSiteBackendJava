const selectedFile = document.getElementById("selectedFile");
const image = document.getElementById("img-preview");

selectedFile.onchange = e => {
    const [file] = selectedFile.files;
    if (file) {
        image.src = URL.createObjectURL(file);
    }
}