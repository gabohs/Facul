
function verFoco()
{
    console.log("Evento 'focus'")
}

function verBlur()
{
    console.log("Evento 'blur'")
}

function verChange()
{
    console.log('Input alterado')
}

let charsInput = document.getElementById('charsinput')

function verKeyup()
{   
    console.log("Nova letra digitada ou removida no input")

    nome.value = nome.value.toUpperCase()
    charsInput.innerText = nome.value.length

    if (nome.value.length > 10)
        nome.setAttribute('class', 'invalid')
    else
        nome.setAttribute('class', 'valid')
}

