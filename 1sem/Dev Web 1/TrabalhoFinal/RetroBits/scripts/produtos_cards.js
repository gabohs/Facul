const pRow = document.getElementById("produtos_row");

produtos.forEach(p => {
    const col = document.createElement('div')
    col.className = 'col-4'

    const card = document.createElement('div')
    card.className = 'card p-3'

    const card_img = document.createElement('img')
    card_img.src = p.img
    card_img.alt = 'Imagem do Console'
    card_img.className = 'card-img-top'
    card_img.width = 200
    card_img.height = 200

    const card_body = document.createElement('div')
    card_body.className = 'card-body'

    const card_title = document.createElement('h3')
    card_title.className = 'card-title'
    card_title.textContent = p.titulo
    
    const card_preco = document.createElement('h5')
    card_preco.className = 'card-text'
    card_preco.textContent = `R$ ${p.preco}`
    card_preco.style = 'color: var(--orange);'

    const botao_comprar = document.createElement('a')
    botao_comprar.style = 'font-family: sans-serif;'
    botao_comprar.className = 'btn btn-primary'
    botao_comprar.textContent = 'Comprar'
    botao_comprar.onclick = function(){alert(`${p.titulo} adicionado ao carrinho!`)}

    card_body.append(card_title, card_preco);
    card.append(card_img, card_body, botao_comprar);
    col.append(card);
    pRow.append(col);
})