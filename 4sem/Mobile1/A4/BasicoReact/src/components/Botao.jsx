export default function Botao(p) {
  /*function clicado(texto) { alert(texto); }
    return <div onClick={clicado}>OK</div>; */

  return (
    <div
      style={{ backgroundColor: p.cor, color: "white" }}
      onClick={(e) => {
        if (p.nome.length < 11) alert(p.nome);
        else console.log(p.nome);
      }}
    >
      {p.nome}
    </div>
  );
}
