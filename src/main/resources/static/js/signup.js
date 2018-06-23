class User{
    constructor(username,password){
        this.username = username;
        this.password = password;
    }
}
function onSignUpButtonClicked(){
    let user = new User(document.getElementById("username").value,document.getElementById("password").value);
    fetch("/signup",{
        method: 'POST',
        headers: {
            "Accept":"application/json",
            "content-type":"application/json"
        },
        body: JSON.stringify(user)
    }).then(function(response) {
        if(!response.ok){
            throw new Error(response)
        }
        window.location.replace('\login');
    }).catch(function (error) {
        alert("signup failure");
    })
}
