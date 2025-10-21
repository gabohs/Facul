window.addEventListener('load', main)

function getCor()
{
    let radios = document.getElementsByName('cor')

    let corSelected = null
    for (let i = 0; i < radios.length; i++)
    {
        if (radios[i].checked)
        {
            corSelected = radios[i].value
            break
        }
    }
    
    return corSelected;
}

function validaCor(radioIndex)
{
    radioIndex.classList.remove('is-valid', 'is-invalid')

    if (getCor() != null)
    {
        radioIndex.classList.add('is-valid')
    }
    else
    {
        radioIndex.classList.add('is-invalid')
    }
}

function mudaImagem()
{
    let img = document.getElementById('img')
    let img_src = ['img/preto.webp', 'img/azul_escuro.webp']

    img.setAttribute('src', img_src[ getCor() ])
}

function validaQuant()
{
    let quant = document.getElementById('quant')

    quant.classList.remove('is-valid', 'is-invalid')

    if (isNaN(quant.value) || quant.value == '' || quant.value == 0)
    {   
        quant.classList.add('is-invalid')
        return false;
    }
        
    quant.classList.add('is-valid')
    return true;
}

function mostraValor()
{
    let valIn = document.getElementById('valor')
    let quant = document.getElementById('quant')

    if (validaQuant())
    {
        valIn.value = `R$ ${1109 * quant.value}`
    }
    else
    {
        valIn.value = 'Por favor informe uma quantidade válida!'
    }
}

function atualizaPrevisaoEntrega()
{
    let prevP = document.getElementById('prev')

    let hj = new Date()

    let previsao = new Date
    previsao.setDate(hj.getDate() + 10)

    prevP.innerText = `Previsão de entrega: ${previsao.toLocaleDateString()}`
}

function comprar()
{   
    let resultadoCompra = document.getElementById('result')

    if (validaQuant())
    {
        resultadoCompra.innerText = "Compra efetuada com sucesso!"
    }
    else
    {
        resultadoCompra.innerText = "Informe uma quantidade válida!"
    }
}

function main()
{   
    document.getElementsByName('cor').forEach(c => 
    {
        c.addEventListener('input', () => 
        {   
            validaCor(c)
            mudaImagem()
        })
    })

    document.getElementById('quant').addEventListener('input', mostraValor)

    atualizaPrevisaoEntrega()

    document.getElementById('comprar').addEventListener('click', () => 
    {   
        atualizaPrevisaoEntrega()
        comprar()
    })
}   