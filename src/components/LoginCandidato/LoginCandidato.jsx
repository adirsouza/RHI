import React from 'react'
import { FaUser, FaLock } from 'react-icons/fa';
import { useState } from 'react';
import "./LoginCandidato";  



const LoginCandidato = () => {
const [] = useState()
    const [username, setUsername] = useState("");
        const [Password, setPassword] = useState("");

    
     const handleSubmit = (event) => {
        event.preventDefault();
        
        //lert("registrando as informações:" + username +" -" + Password);
    }  
 return (
    <div className="container">
        <form onSubmit={handleSubmit}>
            <h1>Login Candidato</h1>
            <div className="input-field">
            <input 
            type="number" 
            placeholder="Matricula"
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
        </form>

        <div>
		<form action="#" method="post" id="formulario" class="row g-3">
			<h1>Cadastre seu currículo abaixo:</h1>
			<div class="col-md-12">
				<label for="cargoPretendido" class="form-label">Cargo
					Pretendido:</label> <input type="text" name="cargoPretendido"
					class="form-control" id="cargoPretendido" />
			</div>
			<div class="col-md-12">
				<label for="profissao" class="form-label">Profissão*:</label> <input
					type="text" name="profissao" class="form-control" id="profissao"
					required />
			</div>
			<div class="col-md-12">
				<label for="nomeCompleto" class="form-label">Nome Completo*:</label>
				<input type="text" class="form-control" name="nomeCompleto"
					id="nome" required />
			</div>
			<div class="col-md-4">
				<label for="dataNascimento" class="form-label">Data de
					nascimento*:</label> <input type="date" class="form-control"
					name="dataNascimento" id="dataNascimento" required />
			</div>
			<div class="col-md-4">
				<label for="sexo" class="form-label">Sexo:</label> <select
					name="sexo" class="form-select" id="sexo">
					<option value="selecaoOpcaoSexo"></option>
					<option value="feminino">Feminino</option>
					<option value="masculino">Masculino</option>
				</select>
			</div>
			<div class="col-md-4">
				<label for="estadoCivil" class="form-label">Estado Civil:</label> <select
					name="estadoCivil" class="form-select" id="estadoCivil">
					<option value="selecaoOpcaoEstadoCivil"></option>
					<option value="solteiro">Solteiro</option>
					<option value="casado">Casado</option>
					<option value="divorciado">Divorciado</option>
				</select>
			</div>
			<div class="col-md-3">
				<label for="identidade" class="form-label">Identidade:</label> <input
					type="text" name="identidade" class="form-control" id="identidade" />
			</div>
			<div class="col-md-3">
				<label for="cpf" class="form-label">CPF*:</label> <input type="text"
					class="form-control" name="cpf" id="cpf" required />
			</div>
			<div class="col-md-3">
				<label for="veiculo" class="form-label">Possui veículo:</label> <select
					name="veiculo" class="form-select" id="veiculo">
					<option value="selecaoOpcaoVeiculo"></option>
					<option value="simVeiculo">sim</option>
					<option value="naoVeiculo">não</option>
				</select>
			</div>
			<div class="col-md-3">
				<label for="habilitacao" class="form-label">Habilitação:</label> <select
					name="habilitacao" class="form-select" id="habilitacao">
					<option value="selecaoOpcaoHabilitacao"></option>
					<option value="aHabilitacao">A</option>
					<option value="bHabilitacao">B</option>
					<option value="abHabilitacao">AB</option>
					<option value="cHabilitacao">C</option>
					<option value="dHabilitacao">D</option>
				</select>
			</div>
			<div class="col-md-3">
				<label for="telefoneFixo1" class="form-label">Telefone Fixo
					1:</label> <input type="tel" class="form-control" name="telefoneFixo1"
					id="telefoneFixo1" />
			</div>
			<div class="col-md-3">
				<label for="telefoneFixo2" class="form-label">Telefone Fixo
					2:</label> <input type="tel" class="form-control" name="telefoneFixo2"
					id="telefoneFixo2" />
			</div>
			<div class="col-md-3">
				<label for="celular" class="form-label">Celular*:</label> <input
					type="tel" class="form-control" name="celular" id="celular"
					required />
			</div>
			<div class="col-md-3">
				<label for="contato" class="form-label">Contato:</label> <input
					type="text" class="form-control" name="contato" id="contato" />
			</div>
			<div class="col-md-12">
				<label for="email" class="form-label">E-mail*:</label> <input
					type="email" class="form-control" name="email" id="email" required />
			</div>
			<div class="col-md-3">
				<label for="cep" class="form-label">CEP*:</label> <input type="text"
					class="form-control" name="cep" id="cep"
					onblur="pesquisacep(this.value);" required />
			</div>
			<div class="col-md-6">
				<label for="logradouro" class="form-label">Logradouro*:</label> <input
					type="text" class="form-control" name="logradouro" id="logradouro"
					required />
			</div>
			<div class="col-md-3">
				<label for="numerocasa" class="form-label">Número*:</label> <input
					type="text" class="form-control" name="numerocasa" id="numerocasa"
					required />
			</div>
			<div class="col-md-3">
				<label for="complemento" class="form-label">Complemento:</label> <input
					type="text" class="form-control" name="complemento"
					id="complemento" />
			</div>
			<div class="col-md-3">
				<label for="bairro" class="form-label">Bairro*:</label> <input
					type="text" class="form-control" name="bairro" id="bairro" required />
			</div>
			<div class="col-md-3">
				<label for="cidade" class="form-label">Cidade*:</label> <input
					type="text" class="form-control" name="cidade" id="cidade" required />
			</div>
			<div class="col-md-3">
				<label for="estado" class="form-label">Estado:</label> <input
					type="text" class="form-control" name="estado" id="estado" />
			</div>
			<div class="form-row text-center">
				<button type="submit" class="btn btn-primary">Enviar</button>
			</div>

		</form>

	</div>

        
    </div>
    
    
  )
};

export default LoginCandidato;
