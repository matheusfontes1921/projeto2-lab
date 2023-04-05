import React from "react";
import { useState } from "react";
import Card from "../Card/Card";
import './LoginForm.css'
import { database, login } from '../utils/database';

const LoginForm = () => {
    const[username, setUsername] = useState("");
    const[password, setPassword] = useState("");
    const [errorMessage, setErrorMessage] = useState({})

    const errors = {
        username: "Usuário inválido",
        password: "Senha inválida",
        noUsername: "Coloque seu usuário",
        noPassword: "Coloque sua senha",
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
        if(!username) {
            setErrorMessage({name:"noUsername", message: errors.noUsername});
            return;
        }
        if(!password) {
            setErrorMessage({name:"noPassword", message: errors.noPassword});
            return;
        }
        const currentUser = await login(username, password);

        if (currentUser) {
            if (currentUser.password != password) {
                //senha incorreta
                setErrorMessage({name: "password", message: errors.password})
            } else {
                setErrorMessage({});
            }
        } else {
            //não existe o nome de usuário
            setErrorMessage({name: "username", message: errors.username})
        }
    };

    const renderErrorMessage = (name) => 
    name === errorMessage.name && (
        <p className="error_msg">{errorMessage.message}</p>
    )

    return(
        <Card> 
            <h1 className="title">Entrar</h1>
            <p className="subtitle">Por favor, entre com o seu nome de usuário e senha</p>
            <form onSubmit={handleSubmit}>
                <div className="inputs_container">
                    <input type="text" placeholder="Username" value={username} onChange={(e)=>setUsername(e.target.value)}/>
                    {renderErrorMessage("username")}
                    {renderErrorMessage("noUsername")}
                    <input type="password" placeholder="password" value = {password} onChange={(e) => setPassword(e.target.value)} />
                    {renderErrorMessage("password")}
                    {renderErrorMessage("noPassword")}
                </div>
                <input type="submit" value="Log In" className="login_button"/>
            </form>
            <div className="link_container">
                <a href="" className="small">
                    Esqueceu a senha?
                </a>
            </div>
        </Card>
    )
}

export default LoginForm;