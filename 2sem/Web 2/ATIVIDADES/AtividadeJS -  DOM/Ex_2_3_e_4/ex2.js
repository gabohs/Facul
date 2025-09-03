let lista = document.getElementById("lista")

let novoItem = document.createElement("li")
novoItem.className = "list-group-item"

let novoTexto = document.createTextNode("Banco de Dados (Ex. 2)")

novoItem.appendChild(novoTexto)

lista.appendChild(novoItem)