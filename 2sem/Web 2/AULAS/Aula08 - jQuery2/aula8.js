function addProd()
{   
    if ( $('#prodIn').val() == '')
        return;

    $("#lista li:last").after(`<li class=list-group-item> ${ $('#prodIn').val() } </li>`)
}

function limpaProd()
{
    $("#lista li").each( (index, element) => 
    {
        if (index > 2)
            $(element).remove()
    })
}

function marca(e)
{
    $(e.target).toggleClass('riscado')
}

function statusInput()
{
    $('#lenInput').text(`Tamanho: ${ $('#prodIn').val().length }`)

    if ( $("#prodIn").val().length == 0 )
    {
        $("#adiciona").prop('disabled', true)

        $("#prodIn").removeClass('is-valid')
        $("#prodIn").addClass('is-invalid')
    } 
    else
    {   
        $("#adiciona").prop('disabled', false)

        $("#prodIn").removeClass('is-invalid')
        $("#prodIn").addClass('is-valid')
    }   
}

$(document).ready(() => 
{
    // $("#prod li:odd").attr('class', 'list-group-item produto')
    // $("#lista").css('user-select', 'none')
    // $("#lista li").eq(1).css('color', 'red')

    $("#adiciona").click(addProd)   
    $("#limpar").click(limpaProd)

    $("#lista").click(marca)
    $("#prodIn").on('input', statusInput)

    $("#lista li").each( function(index, val) 
    {   
        console.log(`${index}: ${$(this).text()}`)
    })

    $(".cpfMask").mask('000.000.000-00', {clearIfNotMatch: true})
    $(".placaMask").mask('SSS-0A00')

})