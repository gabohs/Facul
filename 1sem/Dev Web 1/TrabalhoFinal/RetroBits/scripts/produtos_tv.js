const carouselInner = document.getElementById("inCarousel")

produtos.forEach((p, i) => {
    const item = document.createElement('div')
    item.className = "carousel-item" + (i === 0 ? " active" : ""); // só o 1º é active

    const img = document.createElement('img')
    img.className = 'w-100 d-block img-fluid'
    img.src = p.img
    img.alt = 'Imagem do Console'

    item.append(img)
    carouselInner.append(item)
})