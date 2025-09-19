window.addEventListener('load', () => 
{
    let verifica = document.getElementById('verifica')
    let input = document.getElementById('nome')

    verifica.addEventListener('click', () => 
    {
        verNome(input.value)
    })  

    let teste = document.getElementById('testeBubbling')
    teste.addEventListener('click', clickTeste)

    document.getElementById('btntest').addEventListener('click', testeBubBtn)

    // let body = document.getElementById('bd1')
    // body.addEventListener('click', clickBody)

    let lista1 = document.getElementById('lista1')
    lista1.addEventListener('click', riscaItem)

    let a = document.getElementById('a')
    a.addEventListener('click', (event) => 
    {
        let conf = confirm('Deseja realmente sair?')
        if (!conf)
            event.preventDefault()
    })
})

function verNome(nome)
{
    alert(`${nome} clicou no botão`)
}

// testando bubbling de eventos:
function testeBubBtn()
{
    alert('Clique no botao #btntest')
}

function clickTeste()
{
    alert('click na div #testeBubbling')
}

// quando ocorrer um clique no botão, será registado um evento de click nos outros elementos
// mais externos à ele, ate mesmo no body.
function clickBody()
{
    alert('click na body')
}

// ------------------------------------------------------------

// risca item da lista ao clicar
function riscaItem_Ruim(event)
{
    if ( event.target.getAttribute('class').includes('riscado') )
    {
        // event.target.setAttribute('class', 'list-group-item')
        event.target.classList.remove('riscado')
    }
    else
    {
        // event.target.setAttribute('class', 'list-group-item riscado')
        event.target.classList.add('riscado')
    }
}

function riscaItem(event)
{
    console.log(event.target.innerText)
    event.target.classList.toggle('riscado')
}

function removeItem(event)
{
    event.target.remove()
}