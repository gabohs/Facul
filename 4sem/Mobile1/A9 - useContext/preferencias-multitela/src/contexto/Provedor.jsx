import { useState } from 'react'
import Contexto from './Contexto.jsx'

const config_padrao = { 
    tamanho_fonte: 14, 
    cor_destaque: '#81a1c1', 
    tema: 'claro' 
}

export default function Provedor({ children }) 
{
    const [config, setConfig] = useState(config_padrao)
    const [tela, setTela] = useState('inicial')

    function alterar(campo, valor) 
    {
      setConfig({ ...config, [campo]: valor })
    }

    function resetar(campo) 
    {
      alterar(campo, config_padrao[campo])
    }

    function resetar_tudo() 
    {
      setConfig(config_padrao)
    }

    const valor = { config, alterar, resetar, resetar_tudo, tela, setTela }

    return (
      <Contexto.Provider value={valor}>
        {children}
      </Contexto.Provider>
    )
}