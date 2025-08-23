document.write("<p>Absoluto de -10 = " + Math.abs(-10)     + "</p>")
document.write("<p>Ceil de 5.001   = " + Math.ceil(5.001)  + "</p>")
document.write("<p>Floor de 4.999  = " + Math.floor(4.999) + "</p>")
document.write("<p>Round de 4.499  = " + Math.round(4.499) + "</p>")
document.writeln("<p>Round de 4.5  = " + Math.round(4.5)   + "</p>")


// for (let i = 0; i <h1 100; i++)
// {
//     let aleatorio = Math.ceil( Math.random() * 60 )
//     document.write("<p>Num aleatório = " + aleatorio + "</p>")
// }

let s = "IFRS Erechim"
document.write("<h1>" + s + "</h1>")

document.write("<h2>Primeira letra: "     + s[0] + "</h2>") // pode-se usar s.charAt(0) tbm 
document.write("<h2>Localização do 'e': " + s.indexOf("E") + "</h2>") // se o carácter n existir, retorna -1
document.write("<h2>Localização do 'e': " + s.lastIndexOf("e") + "</h2>") // começa de trás p frente
document.writeln("<h2>Parte da string: "  + s.substring(0, 6) + "</h2>")

document.writeln("<br>") 

// --------------------------------------------------------------------------------------------------------

document.write("<h1>Usando Datas</h1>")

document.write("<p> Data internamente (ms): "    + Date.now()                             + "</p>") 
document.write("<p> Data internamente (seg): "   + Date.now() / 1000                      + "</p>") 
document.write("<p> Data internamente (min): "   + Date.now() / 1000 / 60                 + "</p>") 
document.write("<p> Data internamente (horas): " + Date.now() / 1000 / 60 / 60            + "</p>") 
document.write("<p> Data internamente (dias): "  + Date.now() / 1000 / 60 / 60 / 24       + "</p>") 
document.write("<p> Data internamente (anos): "  + Date.now() / 1000 / 60 / 60 / 24 / 365 + "</p>") 

let hj = new Date()
let nasc = new Date("2007-03-21 17:15:00")

let idade = (hj - nasc) / 1000 / 60/ 60/ 24 / 365;

// hj.setDate(hj.getDate() + 7) // eh possível alterar a data do objeto Date. Nesse caso, vamos p p msm dia na semana q vem

document.write("<h2>HOJE:</h2>")

document.write("<p> Dia (semana): " + hj.getDay()         + "</p>")
document.write("<p> Dia (mes):    " + hj.getDate()        + "</p>")
document.write("<p> Mes:          " + (hj.getMonth() + 1) + "</p>") // contagem começa do 0
document.write("<p> Ano:          " + hj.getFullYear()    + "</p>") 
document.write("<p> Hora:         " + hj.getHours()       + "</p>") 
document.write("<p> Minutos:      " + hj.getMinutes()     + "</p>") 

document.write("<p> Data completa: " + hj.toDateString() + "</p>") 
document.write("<p> Minha idade agora: " + idade + " anos</p>") 
document.write("<p> Minha idade quando executei esse código na aula pela 1a vez: 18.414264129027142 anos</p>") 

