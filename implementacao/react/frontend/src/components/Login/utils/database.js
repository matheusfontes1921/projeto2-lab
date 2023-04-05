import axios from "axios";

export const database = [
    {
        username: "admin",
        password: "adm123",

    },
    {
        username: "andre_sathler",
        password: "andre123",
    },
    {
        username: "lucas_santos",
        password: "lucas123",
    },
    {
        username: "matheus_fontes",
        password: "cruzeiro123",
    },

];

const back = axios.create({
    baseURL: "http://localhost:8080/",
    headers: {'Content-Type': 'application/json'}
})

export const login = (email, password) => {
    back.post("api/cliente/login", {
        email,
        password
    });
}