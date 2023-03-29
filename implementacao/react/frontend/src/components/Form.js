import axios from "axios";
import React, {useEffect, useRef} from "react";
import styled from "styled-components";
import {toast} from "react-toastify";

const FormContainer = styled.form`
  display: flex;
  align-items: flex-end;
  gap: 10px;
  flex-wrap: wrap;
  background-color: #fff;
  padding: 20px;
  box-shadow: 0px 0px 5px #ccc;
  border-radius: 5px;
`;

const InputArea = styled.div`
  display: flex;
  flex-direction: column;
`;

const Input = styled.input`
  width: 120px;
  padding: 0 10px;
  border: 1px solid #bbb;
  border-radius: 5px;
  height: 40px;
`;

const Label = styled.label``;

const Button = styled.button`
  padding: 10px;
  cursor: pointer;
  border-radius: 5px;
  border: none;
  background-color: #2c73d2;
  color: white;
  height: 42px;
`;

const Form = ({getUsers, onEdit, setOnEdit}) => {
    const ref = useRef();

    useEffect(() => {
        if (onEdit) {
            const user = ref.current;

            user.nome.value = onEdit.nome;
            user.endereco.value = onEdit.endereco;
            user.profissao.value = onEdit.profissao;
            user.rg.value = onEdit.rg;
            user.cpf.value = onEdit.cpf;
        }
    }, [onEdit]);

    const handleSubmit = async (e) => {
        e.preventDefault();

        const user = ref.current;

        if (
            !user.nome.value ||
            !user.endereco.value ||
            !user.profissao.value ||
            !user.rg.value ||
            !user.cpf.value
        ) {
            return toast.warn("Preencha todos os campos!");
        }

        if (onEdit !== null) {
            await axios
                .put("http://localhost:8080/api/cliente/update", {
                    id: onEdit.id,
                    nome: user.nome.value,
                    rg: user.rg.value,
                    cpf: user.cpf.value,
                    email: onEdit.email,
                    password: onEdit.password,
                    endereco: user.endereco.value,
                    profissao: user.profissao.value,
                    empregadoras: onEdit.empregadoras

                })
                .then(({data}) => toast.success(data))
                .catch(({data}) => toast.error(data));
        } else {
            console.log("entrei aqui")
            await axios
                .post("http://localhost:8080/api/cliente/cadastrar", {
                    nome: user.nome.value,
                    rg: user.rg.value,
                    cpf: user.cpf.value,
                    email: "a4@b.com",
                    password: "123",
                    endereco: user.endereco.value,
                    profissao: user.profissao.value,
                    empregadoras: "casa"
                })
                .then(({data}) => toast.success(data))
                .catch(({data}) => toast.error(data));
        }

        user.nome.value = "";
        user.email.value = "";
        user.fone.value = "";
        user.data_nascimento.value = "";

        setOnEdit(null);
        getUsers();
    };

    return (
        <FormContainer ref={ref} onSubmit={handleSubmit}>
            <InputArea>
                <Label>Nome</Label>
                <Input name="nome"/>
            </InputArea>
            <InputArea>
                <Label>Endereço</Label>
                <Input name="endereco"/>
            </InputArea>
            <InputArea>
                <Label>Profissão</Label>
                <Input name="profissao"/>
            </InputArea>
            <InputArea>
                <Label>RG</Label>
                <Input name="rg"/>
            </InputArea>
            <InputArea>
                <Label>CPF</Label>
                <Input name="cpf"/>
            </InputArea>

            <Button type="submit">SALVAR</Button>
        </FormContainer>
    );
};

export default Form;
