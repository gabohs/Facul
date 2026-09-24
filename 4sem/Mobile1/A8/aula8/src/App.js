import "./styles.css";

import { useEffect, useState } from "react";

export default function App() {
  const [v, setV] = useState(0);
  const [load, setLoad] = useState(0);

  useEffect(() => {
    const itemSalvo = localStorage.getItem("contador") || "0";
    setLoad(itemSalvo);
  }, [])

  useEffect(() => {
    const numero = parseInt(load, 10);
    setV(isNaN(numero) ? 0 : numero);
  }, [load])


  return (
    <div className="App">

      <button 
        onClick={() => {
          setV(v + 1);
        }}
      >
        Clique
      </button>

      <h1>
        {v}
      </h1>

      <h1>Valor carregado no storage: {load}</h1>

      <button onClick={() => {
        localStorage.setItem("contador", v);
      }}
      >
        Salvar
      </button>

    </div>
  );
}
