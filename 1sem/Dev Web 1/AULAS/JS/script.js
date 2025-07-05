var acesso = false

let dia = 26
let hora = 20

if (hora >= 18)
{
    document.write("<h1>Boa noite</h1>")
}
else
{
    document.write("<h1>Bom dia</h1>")
}

let nome, idade
nome = prompt("Digite seu nome")
idade = parseInt(prompt("Informe sua idade"))

if (idade >= 18)
{   
    acesso = true;
}
else
{   
    document.write("<img src=img/proibido.jpg class=proibido>")
    document.write("<h2> Desculpe, site apenas para maiores de idade! </h2>")
}

if (acesso)
{
    document.write("<h2> Bem Vindo " + nome + "</h2>")  

    document.write("<p>Hello, World!</p>");

    document.write("<p>Hoje eh dia " + dia + "</p>") 
    document.write("<p> Amanha sera dia " + (dia + 1) + "</p>")

    let cars = ["Fiat", "Volvo", "BMW"] 
    
    document.write("<h3>Carros:</h3>")
    
    document.write("<table>")

    for (let i = 0; i < cars.length; i++)
    {
        document.write("<tr>")

        document.write("<td>" + (i + 1) + "</td>")
        document.write("<td>" + cars[i] + "</td>")

        document.write("</tr>")
    }

    document.write("</table>")
}




