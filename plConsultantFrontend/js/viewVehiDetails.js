const params = new URLSearchParams(window.location.search)
const vehicleId = params.get("id")
console.log(vehicleId)
const details = document.getElementById("vehicleDetails")
fetch(`http://localhost:8080/api/vehicles/${vehicleId}`)
.then(response => response.json())
.then(vehicle => {
    details.innerHTML = `
    <div id="imageContainer"></div>
    <div id="vehicleInfo">
        <h2>${vehicle.brand} ${vehicle.model}</h2>
        <p><strong>Category :</strong> ${vehicle.category}</p>
        <p><strong>Year :</strong> ${vehicle.year}</p>
        <p><strong>Price : </strong>₹${vehicle.price.toLocaleString("en-IN")}</p>
        <p><strong>Kilometres :</strong> ${vehicle.kmDriven.toLocaleString("en-IN")} km</p>
        <p><strong>Description :</strong>${vehicle.description}</p>
        <button onclick="sendEnquiry(${vehicle.id})">Enquire Now</button>
    </div>
`
    imageLoad(vehicle.id)
})
.catch(error => {
    console.log("Error : " + error)
})
function imageLoad(id){
    fetch(`http://localhost:8080/api/images/vehicle/${id}`)
    .then(response => response.json())
    .then(imgs => {
        const imageContainer =
            document.getElementById("imageContainer")
        if(imgs.length === 0){
            imageContainer.innerHTML =
                "<p>No images available</p>"
            return
        }
        let carousel = `
            <div id="vehicleCarousel">
                <div id="mainImage">
                    <img
                        id="mainVehicleImage"
                        src="http://localhost:8080/uploads/${imgs[0].image}"
                        alt="Vehicle image">
                </div>
            </div>
            <div id="thumbnails">
        `
        imgs.forEach((img, index) => {
            carousel += `
                <img
                    src="http://localhost:8080/uploads/${img.image}"
                    class="thumbnail"
                    onclick="showImage('http://localhost:8080/uploads/${img.image}')"
                >
            `
        })
        carousel += `</div>`
        imageContainer.innerHTML = carousel
    })
    .catch(error => {
        console.log("Image error : " + error)
    })
}
function showImage(image){
    document.getElementById("mainVehicleImage").src = image
}
function sendEnquiry(id){
    window.location.href = `enquire.html?vehicleId=${id}`
}
