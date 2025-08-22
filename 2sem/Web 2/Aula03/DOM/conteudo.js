let img = document.getElementById('img1')

img.setAttribute('src', 'img/cavalo.jpg')

// ----------------------------------------------------------------------------------------

let p1 = document.getElementById('assunto')
p1.setAttribute('class', 'cor')
p1.style.backgroundColor = 'gray'
p1.style.padding = '10px'

console.log(p1.innerText)
// p1.remove()

let nomes = document.getElementsByTagName('li') // nomes eh um array
console.log('Num de elementos li: ' + nomes.length)


document.write('<table>')
for (let i = 0; i < nomes.length; i++)
{   
    nomes[i].innerText = (i + 1) + '. ' + nomes[i].innerText.toUpperCase()
    nomes[i].style.color = `rgb(${i * 25}, 0, 10)`
    nomes[i].style.backgroundColor = `rgb(${i * 50}, 100, 0)`

    document.write('<tr>')
    document.write('<td>' + nomes[i].innerText + '</td>')
    document.write('</tr>')
}
document.write('</table>')

let dif = document.getElementsByClassName('dif')
console.log('Num de elementos da class dif: ' + dif.length)

let pdif = document.querySelectorAll('p.dif') // todos os elementos p com a classe dif
console.log("Num de elemntos p classe dif: " + pdif.length)

let nome = document.getElementById('in')
console.log(nome.value)





