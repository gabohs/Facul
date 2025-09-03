let data = new Date()
let hora = data.getHours()

let texto = document.getElementById("texto")
let imagem = document.getElementById("imagem")

if (hora >= 6 && hora <= 12)
{
    texto.innerText = "Bom Dia!"
    imagem.src = "https://www.momentodivino.com.br/img/webp/imagens8/que-deus-abencoe-nosso-dia-5054q8LHJXqfDO.webp"
}
else if (hora > 12 && hora <= 18)
{
    texto.innerText = "Boa Tarde!"
    imagem.src = "https://www.momentodivino.com.br/img/webp/imagens10/linda-e-abencoada-tarde-6425HacKZRcxWu.webp"
}
else
{
    texto.innerText = "Boa Noite!"
    imagem.src = "https://i.pinimg.com/236x/83/10/a0/8310a0268d0fe89ffed24b316d3e3fb0.jpg"
}

let txthoras = document.getElementById("textohoras")

txthoras.innerText = `Hora atual: ${hora}:${data.getMinutes()}`