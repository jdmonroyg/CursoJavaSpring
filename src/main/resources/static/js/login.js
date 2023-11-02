// Call the dataTables jQuery plugin
$(document).ready(function() {

});

async function iniciarSesion(){
    let datos = {};
    datos.email= document.getElementById('txtEmail').value;
    datos.password= document.getElementById('txtPassword').value;
    if (datos.email.trim()==="" ||
        datos.password.trim()===""){
        return alert("Los campos estan vacios");
    }

    const request = await fetch('api/login', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(datos)
    });
    const response = await request.text();
    if (response && response!==""){
        localStorage.token=response;
        localStorage.email=datos.email;
        window.location.href="usuarios.html";
    } else {
        alert("Los datos son incorrectos");
    }
}



