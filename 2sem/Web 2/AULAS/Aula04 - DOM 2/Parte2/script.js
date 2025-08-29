function clean(node) 
{
    for (var n = 0; n < node.childNodes.length; n++) 
    {
        var child = node.childNodes[n];
        //types 1: element, 8:comentário, 3:texto
        if ( child.nodeType === 8 || (child.nodeType === 3 && !/\S/.test(child.nodeValue) )) 
        {
            node.removeChild(child);
            n--;
        } 
        else if (child.nodeType === 1) 
        {
            clean(child);
        }
    }
}

// -----------------------------------------------------------------------

let lista2li = document.querySelectorAll('#lista2 li')

for (let i = 0; i < lista2li.length; i++)
{
    // lista2li[i].remove()
}

// -----------------------------------------------------------------------

// let input = document.getElementById('in')
// let valor = input.value

// -----------------------------------------------------------------------

let newp = document.createElement('p')
let newpText = document.createTextNode('Lista:')
newp.appendChild(newpText)

let l1 = document.getElementById('l1')
l1.after(newp)

// -----------------------------------------------------------------------

let lista2 = document.getElementById('lista2')

let newItem = document.createElement('li')
let newText = document.createTextNode('Água') 

newItem.appendChild(newText)
lista2.appendChild(newItem)

// -----------------------------------------------------------------------

for (let i = 0; i < lista2.childElementCount; i++)
{   
    console.log(lista2.childNodes[i].innerText)
}

console.log("-----------------")
clean(lista2)

for (let i = 0; i < lista2.childElementCount; i++)
{   
    console.log(lista2.childNodes[i].innerText)
}
