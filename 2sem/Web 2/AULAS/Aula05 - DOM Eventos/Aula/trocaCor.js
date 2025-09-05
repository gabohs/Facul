let clicks = 0
let cFaltando = document.getElementById('cliquesfaltando')

function trocaBg()
{   
    clicks++

    if (clicks > 10)
    {   
        cFaltando.innerText = `Suas trocas de fundo acabaram!` 
        btncor.removeEventListener('click', trocaBg)
    }
    else
    {   
        var randomColor = `rgb(${Math.random() * 255}, ${Math.random() * 255}, ${Math.random() * 255})`
        document.body.style.backgroundColor = randomColor
        cFaltando.innerText = `Você têm ${10 - clicks} trocas de fundo restando`    
    } 
}



