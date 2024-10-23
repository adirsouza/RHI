import React from 'react'
import { FaUser, FaLock } from 'react-icons/fa';
import { useState } from 'react';
import "./login.css";  



const Login = () => {
const [] = useState()
    const [username, setUsername] = useState("");
        const [Password, setPassword] = useState("");

    
     const handleSubmit = (event) => {
        event.preventDefault();
        
        alert("registrando as informações:" + username +" -" + Password);
    }  
 return (
    <div className="container">
        <form onSubmit={handleSubmit}>
            <h1>LOGIN</h1>
            <div className="input-field">
            <input 
            type="number" 
            placeholder="CPF"
            onChange={(e) => setUsername(e.target.value)} 
             />
            <FaUser className='icon' />
            </div>
            <div className="input-field">
            <input 
            type="Password"
            placeholder="Senha"
            onChange={(e) => setPassword(e.target.value)}
             />
            <FaLock className='icon' /> 
            </div> 

            <div className="recall-forget">
                <label htmlFor=''>
                    <input type="checkbox" />
                    Lembre de mim
                </label>
                <a href='#'>Esqueceu a Senha?</a>
            </div>
            <button>Entrar</button>             
            <div className="signup-link">
                <p> Não tem uma Conta?<a href='#' > Registrar</a> 
                </p>
            </div>
        </form>
    </div>
  )
};

export default Login;
