function getNombreArticles() {
    console.log("ajax");
    var requeteGetArticles = new XMLHttpRequest();
    requeteGetArticles.open("GET", "nombrearticlesws/total");
    requeteGetArticles.response = "text";
    requeteGetArticles.onload = function () {
        console.log("Nombre de nouveaux articles :" + this.response);
        var spanNBarticles = document.querySelector("span#nombrearticles");
        spanNBarticles.textContent = this.response;
    }
    requeteGetArticles.send();

}
window.onload = function() {
    getNombreArticles();
}