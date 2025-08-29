function soma(x, y)
{
    return x + y;
}

document.writeln('<h2> 10 + 5 = ' + soma(10, 5) + '</h2>')

// ------------------------------------------------------------------
// func. anonima (sem nome)

let raiz = function(b) 
{
    return Math.sqrt(b)
}

document.writeln('<h2> Raiz de 9 = ' + raiz(9) + '</h2>')

// ------------------------------------------------------------------
// arrow function

let aleatorio = () => Math.random()
let aleatorioM = () => Math.ceil(Math.random() * 60)

document.writeln('<h2> Aleatorio = ' + aleatorio() + '</h2>')
document.writeln('<h2> Aleatorio Mega = ' + aleatorioM() + '</h2>')

// ------------------------------------------------------------------
// escopo

function foo()
{
    let nome = 'Gabriel' // escopo limitado ao bloco
    var nome2 = 'Ernani'

    if (nome.length == 7)
    {   
        var idade = 18
        document.writeln('<hr><h3> Nome = ' + nome + '</h3>')
    }
    document.writeln('<h4>&nbsp; Idade = ' + idade + '</h4>')
}
foo()

// ------------------------------------------------------------------


