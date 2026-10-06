fetch("http://localhost:8080/api/vehicles")
.then(response=> response.json())
.then(vehicles =>{
    let container = document.getElementById("container")
    vehicles.forEach(v=>{
        fetch(`http://localhost:8080/api/images/vehicle/${v.id}`)
        .then(response => response.json())
       .then(images => {

    console.log("Vehicle:", v.id, v.brand, v.model)
    console.log("Images:", images)

    let img = ""

    if(images.length > 0){
        img = `
            <img
                src="http://localhost:8080/uploads/${encodeURIComponent(images[0].image)}"
                alt="${v.brand} ${v.model}"
            >
        `
    }
    else{
        img = `<p>No image available</p>`
    }

    let card = document.createElement("div")

    card.innerHTML = `
        ${img}
        <h2>${v.brand} ${v.model}</h2>
        <p>Category : ${v.category}</p>
        <p>Price : Rs ${v.price.toLocaleString("en-IN")}</p>
        <button onclick="viewVehicle(${v.id})">
            View Vehicle
        </button>
    `

    container.appendChild(card)
})
        .catch(error =>{
            console.log("Error occurred "+ error)
            
        })
        
    })
    
})
function viewVehicle(id){
            console.log("button clickd");
            window.location.href = `viewVehiDetails.html?id=${id}`
            
}