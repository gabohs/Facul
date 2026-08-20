import "./styles.css";

import Botao from "./components/Botao";

export default function App() {
  const x = [1, 2, "r"];
  return (
    <div className="App">
      <h1>Hello {x}</h1>
      <Botao nome="Bom dia" cor="red" />
      <Botao nome="Boa tarde" cor="blue" />
      <Botao nome="Boa noite" cor="green" />
      <Botao nome="Boa madrugada" cor="black" />
    </div>
  );
}
