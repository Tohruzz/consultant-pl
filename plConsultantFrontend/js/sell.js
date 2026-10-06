const sellForm = document.getElementById("sellForm")
sellForm.addEventListener("submit",(e)=>{
    e.preventDefault()
    const name = document.getElementById("name").value 
    const phone = document.getElementById("phone").value 
    const brand = document.getElementById("brand").value 
    const model = document.getElementById("model").value 
    const year = document.getElementById("year").value 
    const price = document.getElementById("price").value 
    const description = document.getElementById("description").value 
    const sellReq = {
        name:name,
        phone:phone,
        brand:brand,
        model:model,
        year:Number(year),
        price:Number(price),
        description:description

    }
    console.log(sellReq);
    fetch("http://localhost:8080/api/sellReq",{
        method:"post",
        headers:{
            "Content-Type" : "application/json"
        },
        body:JSON.stringify(sellReq)
    })
    .then(response=>{
        if(!response.ok){
            throw new Error("Error occured")
        }
        return response.json()
    })
    .then(data=>{
        document.getElementById("successBox").style.display = "flex"
        sellForm.reset()
    })
    .catch(error=>{
        alert("Something went wrong")
    })
})
function closeSuccessBox(){
    document.getElementById("successBox").style.display = "none"
}