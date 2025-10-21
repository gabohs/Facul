function calculaIMC(peso, altura)
{
    return peso / (altura * altura);
}

function getSexo(s)
{   
    let sexoVal = null;
    for (let i = 0; i < s.length; i++)
    {   
        if (s[i].checked)
        {
            sexoVal = s[i].value
            break;
        } 
    }

    return sexoVal;
}

function validaSexo(s)
{
    if (getSexo(s) == null)
    {
        s.forEach(sexo => sexo.setAttribute('class', 'form-check-input is-invalid'))
        return false;
    }
    
    s.forEach(sexo => sexo.setAttribute('class', 'form-check-input is-valid'))
    return true;
}

function validaAltura(a)
{
    if (a.value == '' || isNaN(a.value) )
    {
        a.setAttribute('class', 'form-control is-invalid')
        return false;
    }
    
    a.setAttribute('class', 'form-control is-valid')
    return true;
}

function validaPeso(p)
{
    if (p.value == '' || isNaN(p.value))
    {   
        p.setAttribute('class', 'form-control is-invalid')
        return false;
    }
        
    p.setAttribute('class', 'form-control is-valid')
    return true;
}

function verificaForm(sexo, altura, peso, termos)
{     
    let s = validaSexo(sexo)
    let a = validaAltura(altura)
    let p = validaPeso(peso)
    
    return (s && a && p && termos.checked)
}

function exibeResultados(e, sexoV, pesoV, alturaV)
{   
    e.preventDefault()

    let imc = calculaIMC(pesoV, alturaV)

    let r = document.getElementById('resultado')
    let rImg = document.getElementById('rImg')
    let rCl = document.getElementById('rClassificacao')
    let imcVal = document.getElementById('imcVal')

    let sources = [
        ['../img/f1.png', '../img/f2.png', '../img/f3.png'],
        ['../img/m1.png', '../img/m2.png', '../img/m3.png']
    ]

    r.classList.remove('invisible')

    let index = 0;
    if (imc < 18)
    {
        rCl.innerText = "Normal"
    }
    else if (imc <= 28)
    {
        index = 1;
        rCl.innerText = "Sobrepeso"
    }
    else
    {
        index = 2;
        rCl.innerText = "Obesidade"
    }

    rImg.src = sources[sexoV][index]

    imcVal.innerText = `IMC: ${imc.toFixed(2)}`
}

window.addEventListener('load', main)
function main()
{   
    let sexo = document.getElementsByName('sex')
    
    let altura = document.getElementById('btnAltura')
    let peso = document.getElementById('btnPeso')

    let termos = document.getElementById('termos')
    let submit = document.getElementById('btnSubmit')

    sexo.forEach(s => s.addEventListener('input', () => 
    {
        validaSexo(sexo)
        submit.disabled = !verificaForm(sexo, altura, peso, termos)
    }))

    altura.addEventListener('input', () => 
    {
        validaAltura(altura)
        submit.disabled = !verificaForm(sexo, altura, peso, termos)
    })

    peso.addEventListener('input', () => 
    {
        validaPeso(peso)
        submit.disabled = !verificaForm(sexo, altura, peso, termos)
    })

    termos.addEventListener('change', () => 
    {
        submit.disabled = !verificaForm(sexo, altura, peso, termos)
    })

    submit.addEventListener('click', (e) => 
    {
        exibeResultados(e, getSexo(sexo), peso.value, altura.value)
    })   
}