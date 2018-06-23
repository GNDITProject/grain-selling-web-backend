class User {
    constructor(username, password) {
        this.username = username;
        this.password = password;
    }
}

function onLoginButtonClicked() {
    let user = new User(document.getElementById("username").value, document.getElementById("password").value);
    console.log(user);
    fetch("/login", {
        method: 'POST',
        headers: {
            "Accept": "application/json",
            "content-type": "application/json"
        },
        body: JSON.stringify(user)
    }).then(function (response) {
            if (!response.ok) {
                throw new Error(response)
            }
            return response.json();
        }
    ).then(function (responseBody) {
        if (responseBody.hasProfile) {
            window.location.replace('/crop-request')
        } else {
            window.location.replace('/create-profile')
        }
    }).catch(function (error) {
        alert("Login failure")
    })
}