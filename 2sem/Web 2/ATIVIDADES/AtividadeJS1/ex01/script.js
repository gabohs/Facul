function converteCelsius(tF)
{
    return (tF - 32) * 5 / 9
}

let tF = 0
do 
{
    tF = prompt("Informe a temperatura em Fahrenheit:")
} while (isNaN(tF))

let tC = converteCelsius(tF)

const temperaturaTexto = document.getElementById('temperatura')
temperaturaTexto.innerText = `${tC.toFixed(1)} °C`

const mensagem = document.getElementById('mensagem')

if (tC <= 12)
{
    mensagem.innerText = 'Está frio! 🥶'
    mensagem.style.backgroundColor = '#CAF7F9'
}
else if (tC <= 24)
{   
    mensagem.innerText = 'Está agradável! 🙂'
    mensagem.style.backgroundColor = '#656572ff'
}
else 
{
    mensagem.innerText = 'Está quente! 🥵'
    mensagem.style.backgroundColor = '#cc241d'
}