let btnInserir = document.getElementById('btninserir')
let inInserir = document.getElementById('inInserir')

function verificaInput()
{
    if (inInserir.value != '')
        return true

    return false
}

function inserirNaLista()
{   
    let lista = document.getElementById("lista")

    let inputValido = verificaInput()   

    if (inputValido)
    {
        let newLi = document.createElement("li")
        newLi.className = "list-group-item"

        newLi.appendChild( document.createTextNode(inInserir.value) )
        lista.appendChild(newLi)

        if (document.getElementById('alerta')) 
            removerAlerta()
    }
    else
    {
        criarAlerta('Escreva algo no input!')
    }
}