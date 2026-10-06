const contactForm = document.getElementById("contactForm")
contactForm.addEventListener("submit", function(event){
    event.preventDefault()
    const name =document.getElementById("name").value
    const phone =document.getElementById("phone").value
    const email =document.getElementById("email").value
    const message =document.getElementById("message").value
    const contact = {
        name: name,
        phone: phone,
        email: email,
        message: message,
        vehicle: null
    }
    fetch("http://localhost:8080/api/enquiries", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(contact)
    })
    .then(response => {
        if(!response.ok){
            throw new Error("Message could not be sent")
        }
        return response.json()
    })
    .then(data => {
        contactForm.reset()
        document.getElementById("successBox").style.display = "flex"
    })
    .catch(error => {
        console.log("Error : " + error)
        alert("Something went wrong")
    })
})
function closeSuccessBox(){
    document.getElementById("successBox").style.display = "none"

}