window.addEventListener('load', () =>
{
    let btn1 = document.getElementById('btn1')
    btn1.addEventListener('click', verClick)
    btn1.addEventListener('mouseenter', verMouse)

    // ----------------------------------------------------------

    let btncor = document.getElementById('btncor')
    btncor.addEventListener('click', trocaBg)

    // ----------------------------------------------------------

    let nome = document.getElementById('nome')
    nome.addEventListener('focus', verFoco)
    nome.addEventListener('blur', verBlur)
    nome.addEventListener('change', verChange)
    nome.addEventListener('keyup', verKeyup)
})  


    
