// fazer uma função que retorna um numero de 1 ate um limite máximo

let rand = (uLim) => 
{
    return Math.ceil(Math.random() * uLim)
} 

document.writeln('<hr><h2> Exercicio = ' + rand(10) + '</h2>')