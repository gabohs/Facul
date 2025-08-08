let nome = prompt('Digite seu nome:')
let idade = parseInt(prompt('Digite sua idade:'))

document.write('<h1 class=nome> Nome: ' + nome + '</h1>')
// consolexx.log('Idade: ' + idade)
document.write('<p class=idade> Idade: ' + idade + "</p>")

let alunos = ['Paula', 'Maria', 'Julia']
let notas = [5, 10, 7]

let alunos2 = new Array('Junior', 'Pedro', 'Luis')  

// console.table(alunos2)
// alunos2.sort()
// console.table(alunos2)
// alunos2.reverse()
// console.table(alunos2)

document.write('ALUNOS:')

document.write('<ul>')

for (let i = 0; i < alunos.length; i++)
{
    document.write('<li>' + alunos[i] + '</li>')
}

document.write('</ul>')

// -------------------------------------------------------------

document.write('<table>')

document.write('<tr>')

document.write('<th> ALUNOS </th>')
document.write('<th> NOTAS </th>')

document.write('</tr>')

for (let i = 0; i < alunos.length; i++)
{   
    document.write('<tr>')
    document.write('<td>' + alunos[i] + '</td>')
    document.write('<td>' + notas[i] + '</td>')
    document.write('</tr>') 
}

document.write('</table>')
