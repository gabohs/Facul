function criarAlerta(mensagem)
{   
    let controlesLista = document.getElementById('controlesLista')

    let alerta = document.createElement('div')
    alerta.className = 'alert alert-danger d-flex justify-content-between align-items-center mt-4'
    alerta.id = 'alerta'
    alerta.role = 'alert'
    alerta.innerText = mensagem

    let botaoClose = document.createElement('button')
    botaoClose.id = 'fechaAlerta'
    botaoClose.className = 'btn-close'
    botaoClose.ariaLabel = 'Close'

    alerta.appendChild(botaoClose)

    if (!document.getElementById('alerta')) // adiciona o alerta apenas se nao existir um alerta ainda
    {   
        controlesLista.appendChild(alerta)  
        document.getElementById('fechaAlerta').addEventListener('click', removerAlerta)
    }      
}

function removerAlerta()
{
    document.getElementById('alerta').remove()
}

