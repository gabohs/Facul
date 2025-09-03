function adicionarDisciplina() 
{
    let lista = document.getElementById("lista")

    let elementoTexto = prompt("Novo elemento da lista:")

    let newLi = document.createElement("li")
    newLi.className = "list-group-item"

    newLi.appendChild( document.createTextNode(elementoTexto) )
    lista.appendChild(newLi)

    atualizaInput()
}