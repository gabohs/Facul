// ATIVIDADE 2:

let lerNota = (index) =>
{   
    let nota;
    do
    {   
        nota = parseFloat(prompt(`Digite a Nota ${index + 1}`))
    } while ( isNaN(nota) || nota < 0 || nota > 10 )

    return nota
}

let notas = []

for (let i = 0; i < 4; i++)
{
    notas[i] = lerNota(i)
}   

// ATIVIDADE 3:

function calculaMedia(valores)
{
    var soma = 0;
    for (let i = 0; i < valores.length; i++)
    {
        soma += valores[i]
    }
    
    return (soma / valores.length).toFixed(1)
}

let linha2 = document.getElementById('linha2')

for (let i = 0; i < notas.length; i++)
{
    linha2.innerHTML += `<td>${notas[i]}</td>`
}

let media = calculaMedia(notas)
linha2.innerHTML += `<td>${ media }</td>`

let resultado = ""
const imagem = document.createElement('img')
imagem.className = 'imagem'

if (media < 1.8)
{
    resultado = "REPROVADO!"
    imagem.src = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRFcgQrsfeYiodqNrrLGtTpaVEkNnfswjh1oQ&s"
}
else if (media < 7.0)
{
    resultado = "EM EXAME!"
    imagem.src = "https://cdn-icons-png.flaticon.com/512/2299/2299283.png"
}
else
{
    resultado = "APROVADO!"
    imagem.src = "https://cdn-icons-png.flaticon.com/512/4157/4157080.png"
}
    
linha2.innerHTML += `<td>${resultado}</td>`
linha2.innerHTML += `<td>${imagem.outerHTML}</td>`

