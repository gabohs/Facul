function verClick()
{
    alert("Clicou!")
}

let count = 0

function verMouse()
{
    if (count > 10)
    {
        console.log("Vc Atingiu o limite de movimentos do mouse")
    }
    else
    {
        count++
        console.log("MouseEnter: ", count)
    }
}

