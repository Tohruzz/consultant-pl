const loginForm = document.getElementById("loginForm")
loginForm.addEventListener("submit", function(event){
    event.preventDefault()
    const username =document.getElementById("username").value
    const password = document.getElementById("password").value
    const errorMessage =document.getElementById("errorMessage")
    if(username === "admin" && password === "12345"){
        window.location.href = "admin.html"
    }else{
        errorMessage.style.display = "block"
    }

})