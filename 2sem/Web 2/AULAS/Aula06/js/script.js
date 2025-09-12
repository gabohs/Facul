window.addEventListener('load', registra)

function registra()
{
    // let cadcli = document.getElementById('cadcli')
    // cadcli.addEventListener('submit', validaForm)
    document.getElementById('cadcli').addEventListener('submit', validaForm)

    document.getElementById('nome').addEventListener('input', validaNome)
    document.getElementById('end').addEventListener('input', validaEnd)
    document.getElementById('datanasc').addEventListener('input', validaData)
}

function validaForm(e)
{
    let nome = validaNome()
    let end = validaEnd()
    let data = validaData()

    if ( !nome || !end || !data  )
        e.preventDefault() 
}

function validaNome()
{
    let nome = document.getElementById('nome')
    let helpNome = document.getElementById('helpNome')

    if ( nome.value.length <= 5 || !(nome.value.includes('@')))
    {   
        nome.setAttribute('class', 'form-control is-invalid')
        helpNome.setAttribute('class', 'form-text text-danger')

        return false
    } 
    else
    {   
        nome.setAttribute('class', 'form-control is-valid')
        helpNome.setAttribute('class', 'form-text text-muted visually-hidden')

        return true
    } 
}

function validaEnd()
{
    let end = document.getElementById('end')
    let helpEnd = document.getElementById('helpEnd')

    if (end.value.length <= 5)
    {
        end.setAttribute('class', 'form-control is-invalid')
        helpEnd.setAttribute('class', 'form-text text-danger')

        return false
    }
    else
    {
        end.setAttribute('class', 'form-control is-valid')
        helpEnd.setAttribute('class', 'form-text text-muted visually-hidden')

        return true
    }
}

function validaData()
{
    let data = document.getElementById('datanasc')
    let helpData = document.getElementById('helpData')

    let [year, month, day] = data.value.split('-').map(Number);
    let dataIn = new Date(year, month - 1, day);

    let hj = new Date() 

    if (dataIn > hj)
    {   
        data.setAttribute('class', 'form-control is-invalid')
        helpData.setAttribute('class', 'form-text text-danger')

        return false;
    }
    else
    {   
        data.setAttribute('class', 'form-control is-valid')
        helpData.setAttribute('class', 'form-text text-muted visually-hidden')
        return true;
    } 
}