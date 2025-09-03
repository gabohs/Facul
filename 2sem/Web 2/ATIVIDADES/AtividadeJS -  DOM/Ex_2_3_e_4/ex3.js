function atualizaInput()
{
    let in1 = document.getElementById("in1")
    let in2 = document.getElementById("in2")

    let itens = document.querySelectorAll("#lista li")

    in1.value = itens[0].innerText
    in2.value = itens[itens.length - 1].innerText
}

atualizaInput()