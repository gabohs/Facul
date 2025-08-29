let lCarnes = document.getElementById('listacarnes')

let nItens = parseInt(prompt("Quantas carnes a lista vai ter: "))

let precoTotal = 0
for (let i = 0; i < nItens; i++)
{
    let novaCarne = prompt("Nome da Carne e preco separados por -:")

    let [nome, preco] = novaCarne.trim().split(" - ")

    let item = document.createElement('li')
    let itemTexto = document.createTextNode(`${nome} - R$ ${preco}`)

    precoTotal += parseFloat(preco)

    item.appendChild(itemTexto)
    lCarnes.appendChild(item)
}

// let precoP = document.getElementById('precotexto')
// precoP.innerText += ` Preco total: ${precoTotal} reais`

let precoP = document.createElement('p')
precoP.innerText = ` Preco total: ${precoTotal.toFixed(2)} reais`

lCarnes.after(precoP)
