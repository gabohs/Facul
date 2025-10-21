function calculaIMC(peso, altura)
{
    return peso / (altura * altura);
}

function getSexo($s)
{
    let sexoVal = null
    $s.each(function() 
    {
        if( $(this).is(':checked') )
            sexoVal = $(this).val()
    } )

    return sexoVal;
}

function validaSexo($s)
{
    if (getSexo($s) == null )
    {
        $s.addClass('is-invalid').removeClass('is-valid')
        return false;
    }

    $s.addClass('is-valid').removeClass('is-invalid')
    return true;
}

function validaAltura($a)
{
    if ($a.val() == '' || isNaN($a.val()))
    {
        $a.addClass('is-invalid').removeClass('is-valid')
        return false;
    }

    $a.addClass('is-valid').removeClass('is-invalid')
    return true;
}

function validaPeso($p)
{
    if ($p.val() == '' || isNaN($p.val()))
    {
        $p.addClass('is-invalid').removeClass('is-valid')
        return false;
    }

    $p.addClass('is-valid').removeClass('is-invalid')
    return true;
}

function verificaForm($sexo, $altura, $peso, $termos)
{
    let s = validaSexo($sexo)
    let a = validaAltura($altura)
    let p = validaPeso($peso)
    
    return (s && a && p && $termos.is(':checked'))
}

function exibeResultados(e, sexoV, pesoV, alturaV)
{
    e.preventDefault()

    let imc = calculaIMC(pesoV, alturaV)

    let sources = [
        ['../img/f1.png', '../img/f2.png', '../img/f3.png'],
        ['../img/m1.png', '../img/m2.png', '../img/m3.png']
    ]

    $("#resultado").removeClass('invisible')

    let index = 0;

    if (imc < 18)
    {
        $("#rClassificacao").text("Normal")
    }
    else if (imc <= 28)
    {
        index = 1;
        $("#rClassificacao").text("Sobrepeso")
    }
    else
    {
        index = 2;
        $("#rClassificacao").text("Obesidade")
    }

    $("#rImg").attr('src', sources[sexoV][index])
    $("#imcVal").text(`IMC: ${imc.toFixed(2)}`)
}

$(document).ready(() => 
{
    let $sexo = $('[name="sex"]');
    let $altura = $('#btnAltura');
    let $peso = $('#btnPeso');
    let $termos = $('#termos');
    let $submit = $('#btnSubmit');

    $sexo.on('input', () =>
    {
        validaSexo($sexo);
        $submit.prop('disabled', !verificaForm($sexo, $altura, $peso, $termos));
    });

    $altura.on('input', () => 
    {
        validaAltura($altura);
        $submit.prop('disabled', !verificaForm($sexo, $altura, $peso, $termos));
    });

    $peso.on('input', () => 
    {
        validaPeso($peso);
        $submit.prop('disabled', !verificaForm($sexo, $altura, $peso, $termos));
    });

    $termos.on('change', () => 
    {
        $submit.prop('disabled', !verificaForm($sexo, $altura, $peso, $termos));
    })

    $submit.on('click', (e) => 
    {
        exibeResultados(e, getSexo($sexo), $peso.val(), $altura.val());
    });
})