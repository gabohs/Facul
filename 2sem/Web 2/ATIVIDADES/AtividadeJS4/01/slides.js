const linguagens = [
    { nome: "C++",        img: "img/cpp.png"  },
    { nome: "Java",       img: "img/java.png" },
    { nome: "JavaScript", img: "img/js.png"   },
    { nome: "Python",     img: "img/py.png"   },
    { nome: "Rust",       img: "img/rust.png" },
    { nome: "GoLang",     img: "img/go.png"   },
]

let titSlide   = document.getElementById('titulo')
let imgSlide   = document.getElementById('slide')
let indexSlide = document.getElementById('indexSlide')

let btnVoltar = document.getElementById('btnvoltar')
let btnProx   = document.getElementById('btnprox')

let slideAtual = 0

function atualizaSlide()
{
    titSlide.innerText = linguagens[slideAtual].nome
    imgSlide.src = linguagens[slideAtual].img

    indexSlide.innerText = `${slideAtual + 1} / ${linguagens.length}`
}

function voltar()
{
    slideAtual = (slideAtual - 1 + linguagens.length) % linguagens.length
    atualizaSlide()
}

function avancar()
{
    slideAtual = (slideAtual + 1) % linguagens.length
    atualizaSlide()
}

// chamando a função uma vez p/ n ficar imagem em branco
atualizaSlide()