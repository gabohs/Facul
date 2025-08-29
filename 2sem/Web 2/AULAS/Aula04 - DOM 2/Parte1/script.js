let lista1 = document.getElementById('lista1')
console.log(lista1)

let itens = document.getElementsByTagName('li')
console.log(itens.length)

let total = document.getElementById('total')
let precoTotal = 0

for (let i = 0; i < itens.length; i++)
{
    // itens[i].setAttribute('class', 'comprado')
    itens[i].style.color = 'red'

    let texto = itens[i].innerText
    let precoItem = texto.substring(texto.lastIndexOf('-') + 1, itens[i].length)
    precoTotal += parseFloat(precoItem)

    // [nome, preco] = itens[i].textContent.split(" - ")
    // precoTotal += parseFloat(preco)
}

total.innerText += ` ${precoTotal} reais`