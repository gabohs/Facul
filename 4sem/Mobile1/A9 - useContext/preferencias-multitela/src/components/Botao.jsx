import { useContext } from 'react'
import Contexto from '../contexto/Contexto.jsx'

export default function Botao({ children, funcao, ativo }) 
{
    const { config } = useContext(Contexto)

    const estilo_fixo = {
        color: 'inherit',
        borderRadius: '8px',
        padding: '10px',
        fontSize: 'inherit'
    }

    return (
        <button
            onClick={funcao}
            style={{
            ...estilo_fixo,
            backgroundColor: config.cor_destaque
            }}
        >
            {children}
        </button>
    )
}