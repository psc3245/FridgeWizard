const url = "http://localhost:8080/api/auth/";

const login_div = document.querySelector("#login");
const signup_div = document.querySelector("#signup");

const login_user = document.querySelector("#login_user");
const login_pass = document.querySelector("#login_password");
const login_submit = document.querySelector("#login_submit");
const singup_button = document.querySelector("#signup_btn");

const loginForm = document.querySelector("#login_form");

singup_button.onclick = switch_to_signup;

loginForm.addEventListener('submit', async function(event) {
    event.preventDefault();
    
    let user = login_user.value;
    let pass = login_pass.value;
    
    let send_to = url + "login";
    
    let login_request = {
        emailOrUsername: user,
        password: pass
    };
    
    try {
        const res = await fetch(send_to, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            credentials: 'include',
            body: JSON.stringify(login_request)
        });
        
        if (!res.ok) {
            console.error('Request failed with status:', res.status);
            const errorText = await res.text();
            console.error('Error details:', errorText);
            return;
        }
        
        const response = await res.json();
        console.log("Parsed response:", response);
    } catch (error) {
        console.error('Detailed error:', error);
        console.error('Error stack:', error.stack);
    }
});

function switch_to_signup() {
    login_div.style.display = 'none';
    signup_div.style.display = 'block';
}

const signup_email = document.querySelector("#signup_email");
const signup_user = document.querySelector("#signup_user");
const signup_pass = document.querySelector("#signup_password");
const signup_pass_confirm = document.querySelector("#signup_password_confirm");
const signup_submit = document.querySelector("#signup_submit");
const login_button = document.querySelector("#login_btn");

const signupForm = document.querySelector("#signup_form");

login_button.onclick = switch_to_login;

signupForm.addEventListener('submit', async function (event) {
    event.preventDefault();

    let send_to = url + "signup";

    let em = signup_email.value;
    let user = signup_user.value;
    let pass = signup_pass.value;
    let pass_confirm = signup_pass_confirm.value;

    // Verify password matches confirmed password
    if (pass != pass_confirm) {
        throw error;
    }

    let signup_request = {
        email: em,
        username: user,
        password: pass
    }

    console.log(JSON.stringify(signup_request));

    try {
        const res = await fetch(send_to, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            credentials: 'include',
            body: JSON.stringify(signup_request)
        });
        
        if (!res.ok) {
            console.error('Request failed with status:', res.status);
            const errorText = await res.text();
            console.error('Error details:', errorText);
            return;
        }
        
        const response = await res.json();
        console.log("Parsed response:", response);
    } catch (error) {
        console.error('Detailed error:', error);
        console.error('Error stack:', error.stack);
    }

});

function switch_to_login() {
    login_div.style.display = 'block';
    signup_div.style.display = 'none';
}

