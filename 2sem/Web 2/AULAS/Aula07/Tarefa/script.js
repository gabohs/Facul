window.addEventListener('load', () => 
{
    let lista = document.getElementById('lista')
    lista.addEventListener('click', selecionaItem)
})

function selecionaItem(e)
{
    e.target.classList.toggle('active') 
}