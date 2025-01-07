const url = "http://localhost:8080/api/auth/";

const login_div = document.querySelector("#login");
const signup_div = document.querySelector("#signup");

const login_user = document.querySelector("#login_user");
const login_pass = document.querySelector("#login_password");
const login_submit = document.querySelector("#login_submit");

const loginForm = document.querySelector("#login_form");

// document.addEventListener('DOMContentLoaded', function() {
//     console.log("DOM loaded");  // Check if this message is logged
//     const url = "http://localhost:8080/api/auth/";

//     const loginForm = document.querySelector("#login_form");
//     if (loginForm) {
//         loginForm.addEventListener('submit', async function(event) {
//             event.preventDefault();
//             console.log("Form submitted");
//             let user = document.querySelector("#login_user").value;
//             let pass = document.querySelector("#login_password").value;
//             console.log("Credentials collected:", { user });
//             console.log("Sending request to:", url + "login");
//             try {
//                 const res = await fetch(url + "login", {
//                     method: 'POST',
//                     headers: { 'Content-Type': 'application/json' },
//                     body: JSON.stringify({ emailOrUsername: user, password: pass })
//                 });
//                 if (!res.ok) {
//                     console.error('Request failed with status:', res.status);
//                     return;
//                 }
//                 const response = await res.json();
//                 console.log("Parsed response:", response);
//             } catch (error) {
//                 console.error('Error:', error);
//             }
//         });
//     } else {
//         console.error('Login form not found!');
//     }
// });


loginForm.addEventListener('submit', async function(event) {
    event.preventDefault();
    console.log("Form submitted");
    
    let user = login_user.value;
    let pass = login_pass.value;
    console.log("Credentials collected:", { user });
    
    let send_to = url + "login";
    console.log("Sending request to:", send_to);
    
    let login_request = {
        emailOrUsername: user,
        password: pass
    };
    
    try {
        console.log("Starting fetch request");
        const res = await fetch(send_to, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            credentials: 'include',
            body: JSON.stringify(login_request)
        });
        console.log("Fetch response received:", res.status);
        
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

console.log("Login form element:", loginForm);