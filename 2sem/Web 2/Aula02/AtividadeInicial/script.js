/* ATIVIDADE
Ler idade através de um prompt. 
Se idade < 18  -> mostrar imagem 'proibido'
Se idade >= 18 -> mostrar imagem 'permitido'
 */

let idade; 

console.log(idade)

let imagem = document.getElementById("imagem")
let texto = document.getElementById("texto")

do 
{
    idade = prompt("Digite sua idade");
} while (idade < 0 || idade == '' || isNaN(idade))

if (idade >= 18)
{   
    texto.innerHTML = "ENTRADA PERMITIDA"
    imagem.src = "img/lebronOK.jpg"
}