const params = new URLSearchParams(window.location.search)
const vehicleId = params.get("vehicleId")
console.log(vehicleId)
const enquiryForm = document.getElementById("enquiryForm")
enquiryForm.addEventListener("submit",(e)=>{
    e.preventDefault()
    const name = document.getElementById("name").value 
    const phone = document.getElementById("phone").value 
    const email = document.getElementById("email").value 
    const message = document.getElementById("message").value 
    const enquiry = {
        name:name,
        phone:phone,
        email:email,
        message:message,
        vehicle:{
            id:Number(vehicleId)
        }
    }
    console.log(enquiry)
    fetch("http://localhost:8080/api/enquiries",{
        method:"post",
        headers:{
            "Content-Type":"application/json"
        },
        body:JSON.stringify(enquiry)
    })
    .then(response=>{
        if(!response.ok){
            throw new Error("Error occured")
        }
        return response.json()
    })
    .then(data=>{
        enquiryForm.reset()
       document.getElementById("successBox").style.display = "flex"
    })
    .catch(error=>{
        alert("Something went wrong")
    })
})
function closeSuccessBox(){
    document.getElementById("successBox").style.display = "none"
}
