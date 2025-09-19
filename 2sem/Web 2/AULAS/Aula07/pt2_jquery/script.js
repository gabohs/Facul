// $(seletor).action()

$(document).ready( () => 
{
    $('p').attr('class', 'dif') // atribuindo classe 'p' à todos os elementos 'p'
    $('#btnjquery').click(clickjquery)

    $('p').click(function(event)
    {   
        console.log(event.target.innerText)
    })
})

function clickjquery()
{   
    
    alert('Clique jQuery')
}
