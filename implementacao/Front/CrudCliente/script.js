const modal = document.querySelector('.modal-container')
const tbody = document.querySelector('tbody')
const sNome = document.querySelector('#m-nome')
const sRG = document.querySelector('#m-rg')
const sCPF = document.querySelector('#m-CPF')
const sEndereco = document.querySelector('#m-endereco')
const sProfissao = document.querySelector('#m-profissao')
const btnSalvar = document.querySelector('#btnSalvar')

let itens
let id

function openModal(edit = false, index = 0) {
  modal.classList.add('active')

  modal.onclick = e => {
    if (e.target.className.indexOf('modal-container') !== -1) {
      modal.classList.remove('active')
    }
  }

  if (edit) {
    
    sNome.value = itens[index].nome
    sRG.value = itens[index].rg
    sCPF.value = itens[index].cpf
    sEndereco.value = itens[index].endereco
    sProfissao.value = itens[index].erofissao
    id = index;

  } else {
    sNome.value = ''
    sRG.value = ''
    sCPF.value=''
    sEndereco.value = ''
    sProfissao.value=''
  }
  
}

function editItem(index) {

  openModal(true, index)
}

function deleteItem(index) {
  itens.splice(index, 1)
  setItensBD()
  loadItens()
}

function insertItem(item, index) {
  let tr = document.createElement('tr')

  tr.innerHTML = `
  <td>${item.id}</td>
    <td>${item.nome}</td>
    <td>${item.rg}</td>
    <td>${item.cpf}</td>
     <td>${item.Endereco}</td>
    <td> ${item.Profissao}</td>

    <td class="acao">
      <button onclick="editItem(${index})"><i class='bx bx-edit' ></i></button>
    </td>
    <td class="acao">
      <button onclick="deleteItem(${index})"><i class='bx bx-trash'></i></button>
    </td>
  `
  tbody.appendChild(tr)
}

btnSalvar.onclick = e => {
  
  if (sNome.value == '' || sRG.value == '' || sEndereco.value == '') {
    return
  }

  e.preventDefault();

  if (id !== undefined) {
    itens[id].nome = sNome.value
    itens[id].rg = sRG.value
    itens[id].cpf = sCPF.value
    itens[id].Endereco = sEndereco.value
    itens[id].Profissao = sProfissao.value
  } else {
    itens.push({'nome': sNome.value, 'rg': sRG.value, 'cpf':sCPF.value, 'Endereco': sEndereco.value, 'Profissao':sProfissao.value})
  }

  setItensBD()

  modal.classList.remove('active')
  loadItens()
  id = undefined
}

function loadItens() {
  itens = getItensBD()
  tbody.innerHTML = ''
  itens.forEach((item, index) => {
    insertItem(item, index)
  })

}

const getItensBD = () => JSON.parse(localStorage.getItem('dbfunc')) ?? []
const setItensBD = () => localStorage.setItem('dbfunc', JSON.stringify(itens))

loadItens()
