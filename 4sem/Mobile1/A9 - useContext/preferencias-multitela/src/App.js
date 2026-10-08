import { useContext } from 'react'

import Contexto from './contexto/Contexto.jsx'
import Provedor from './contexto/Provedor.jsx'
import Botao from './components/Botao.jsx'
import Nav from './components/Nav.jsx'

const cores = ['#5e81ac', '#a3be8c', '#8fbcbb', '#bf616a', '#b48ead']

const temas = {
    claro: { fundo: '#eceff4', texto: '#4c566a' },
    escuro: { fundo: '#2e3440', texto: '#d8dee9' }
}

function TelaInicial() 
{ 
  const { resetar, resetar_tudo } = useContext(Contexto)

  return (
      <div>
        <h2>Início</h2>
        <p>Resetar configurações:</p>
        <div style={{ display: 'flex', gap: '20px', flexWrap: 'wrap' }}>
          <Botao funcao={resetar_tudo}>Resetar tudo</Botao>
          <Botao funcao={() => resetar('tamanho_fonte')}>Resetar fonte</Botao>
          <Botao funcao={() => resetar('cor_destaque')}>Resetar cor</Botao>
          <Botao funcao={() => resetar('tema')}>Resetar tema</Botao>
        </div>
      </div>
  )
}

function TelaFonte() 
{
    const { config, alterar } = useContext(Contexto)
    const tamanho = config.tamanho_fonte

    return (
      <div>
        <h2>Tamanho da fonte</h2>
        <div style={{ display: 'flex', gap: '15px' }}>
          <p>{tamanho}px</p>
        
          <Botao funcao={() => alterar('tamanho_fonte', Math.max(10, tamanho - 2))}>-</Botao>
          <Botao funcao={() => alterar('tamanho_fonte', Math.min(40, tamanho + 2))}>+</Botao>
        </div>
      </div>
    )
  }

function TelaCor() 
{
    const { config, alterar } = useContext(Contexto)

    return (
      <div>
        <h2>Cor de destaque</h2>
        <div style={{ display: 'flex', gap: '10px' }}>
          {cores.map(cor => (
            <div
              key={cor}
              onClick={() => alterar('cor_destaque', cor)}
              style={{
                backgroundColor: cor,
                width: '40px',
                height: '40px',
                borderRadius: '10px',
                cursor: 'pointer',
                border: cor === config.cor_destaque ? '3px solid currentColor' : '3px solid transparent'
              }}
            />
          ))}
        </div>
      </div>
    )
}

function TelaTema() 
{
    const { config, alterar } = useContext(Contexto)
    const novo_tema = config.tema === 'claro' ? 'escuro' : 'claro'

    return (
      <div>
        <h2>Tema</h2>
        <p>Atual: {config.tema}</p>
        <Botao funcao={() => alterar('tema', novo_tema)}>Mudar para {novo_tema}</Botao>
      </div>
    )
}

const telas = { 
    inicial: TelaInicial, 
    fonte: TelaFonte, 
    cor: TelaCor, 
    tema: TelaTema 
}

function Site() 
{
    const { config, tela } = useContext(Contexto)
    const Tela = telas[tela] 

    return (
      <div style={{
        minHeight: '100vh',
        padding: '20px',
        boxSizing: 'border-box',
        
        fontSize: `${config.tamanho_fonte}px`,
        backgroundColor: temas[config.tema].fundo,
        color: temas[config.tema].texto,
      }}>
        <h1 style={{textAlign: 'center'}}>App de preferências multitela</h1>
        <Nav />
        <Tela />
      </div>
    )
}

export default function App() 
{
    return (
        <Provedor>
          <Site />
        </Provedor>
    )
}