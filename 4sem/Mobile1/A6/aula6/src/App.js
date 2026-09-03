import "./styles.css";

import Botao from "./Botao"

export default function App() {
  return (
    <div className="App">
      <h1>Aula 6</h1>

      <Botao type="primary" size="large" text="Botao " shadow='on'/>
      <Botao type="success" size="medium" text="Outro botao" shadow='off'/>
    </div>
  );
}