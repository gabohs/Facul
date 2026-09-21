/*
EXERCICIO EaD

Complemente sua atividade de botões realizada no dia 02/09, onde criamos um único estado no App que é compartilhado com todos os diversos botões da tela.

A tela deve possuir uma visualização de um número e diversos botões (baseados em um mesmo componente). Cada botão deve receber suas informações do App e possuir textos e funcionalidades únicas, por exemplo: Incrementar, Decrementar, Resetar, Aleatório, +100, -50, etc.

O objetivo é fazer com que o controle e organização dos dados sejam centralizados em um componente, que repassa apenas um acesso controlado/limitado a cada componente que precisa interagir com os outros.
*/

import { useState } from "react"

import "./styles.css";

import Botao from "./Botao"

export default function App() {
  const [num, setNum] = useState(0); 

  return (
    <div className="App">
      <h1>EaD 09/09/2026</h1>
      <h3>Aluno: Gabriel H. Schaeffer</h3>

      <h1 class="contador">{num}</h1>

      <div style={{display: 'flex', flexDirection: 'row', justifyContent: 'center',flexWrap: 'wrap'}}>

        <Botao type="success" size="medium" text="+1 " shadow='on' numero={num} funcao={
          () => setNum(num + 1)
        }/>

        <Botao type="error" size="medium" text="-1" shadow='off' numero={num} funcao={
          () => setNum(num - 1)
        }/>

        <Botao type="primary" size="medium" text="Reset" shadow='off' numero={num} funcao={
          () => setNum(0)
        }/>

        <Botao type="primary" size="medium" text="Aleatório" shadow='off' numero={num} funcao={
          () => setNum(Math.floor(Math.random() * 500))
        }/>


        <Botao type="secondary" size="medium" text="+100" shadow='off' numero={num} funcao={
          () => setNum(num + 100)
        }/>

        <Botao type="secondary" size="medium" text="-100" shadow='off' numero={num} funcao={
          () => setNum(num - 100)
        }/>

        <Botao type="primary" size="medium" text="+num" shadow='off' numero={num} funcao={
          () => setNum(num + num)
        }/>

        <Botao type="primary" size="medium" text="-num" shadow='off' numero={num} funcao={
          () => setNum(num - num)
        }/>

        <Botao type="secondary" size="medium" text="num*2" shadow='off' numero={num} funcao={
          () => setNum(num * 2)
        }/>

        <Botao type="secondary" size="medium" text="num^2" shadow='off' numero={num} funcao={
          () => setNum(num * num)
        }/>

        <Botao type="primary" size="medium" text="num!" shadow='off' numero={num} funcao={
            () => {
              let fatorial = 1;

              for (let i = 1; i <= num; i++)
                fatorial *= i;
              
              setNum(fatorial);
            }
        }/>

        <Botao type="primary" size="medium" text="Collatz" shadow='off' numero={num} funcao={
          () => {
            if (num <= 0)
            {
              alert("O numero deve ser maior que 0");
              return;
            }

            let n = 0;
            if (num % 2 == 0)
              n = num / 2;
            else
              n = 3 * num + 1;

            setNum(n);
          }
        }/>

      </div>
      
    </div>
  );
}