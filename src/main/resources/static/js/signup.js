class User{
    constructor(username,password){
        this.username = username;
        this.password = password;
    }
}
function onSignUpButtonClicked(){
    let user = new User(document.getElementById("username").value,document.getElementById("password").value);
    console.log(user.username);
    console.log(user.password);
}
