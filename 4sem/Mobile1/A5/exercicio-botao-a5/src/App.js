import "./styles.css";

import Botao from "./components/Botao"

export default function App() {
  return (
    <div className="App">
      <h1>Exercício - Componente Botão</h1>
      <h3>Gabriel H. Schaeffer; 26/08/2026</h3>

      <Botao type="primary" size="small" text="Botao primary" shadow='on'/>
      <Botao type="success" size="medium" text="Botao success" shadow='off'/>
      <Botao type="error" size="large" text="Botao error" shadow='on'/>
      <Botao type="secondary" size="medium" text="Botao secondary"/>
    </div>
  );
}
