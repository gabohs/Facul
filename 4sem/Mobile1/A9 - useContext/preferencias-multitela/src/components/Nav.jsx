import { useContext } from 'react'
import Contexto from '../contexto/Contexto.jsx'

const itens_nav = [
    { tela: 'inicial', texto: 'Início' },
    { tela: 'fonte', texto: 'Fonte' },
    { tela: 'cor', texto: 'Cor' },
    { tela: 'tema', texto: 'Tema' }
]

export default function Nav() 
{
    const { config, tela, setTela } = useContext(Contexto)

    const estilo_fixo = {
        color: 'inherit',
        textDecoration: 'none',
        borderRadius: '10px',
        padding: '10px',
        cursor: 'pointer'
    }

    function ir_para(evento, destino) 
    {
        evento.preventDefault() 
        setTela(destino)
    }
  
    return (
        <nav style={{ 
            display: 'flex', 
            gap: '10px', 
            marginBottom: '30px',

            justifyContent: 'center',
            alignItems: 'center'

        }}>
            {itens_nav.map(item => (
                <a
                key={item.tela}
                href="#"
                onClick={(evento) => ir_para(evento, item.tela)}
                style={{
                    ...estilo_fixo,
                    backgroundColor: tela === item.tela ? config.cor_destaque : 'transparent'
                }}
                >
                {item.texto}
                </a>
            ))}
        </nav>
    )
}