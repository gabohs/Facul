import { useSettings } from '../components/SettingsContext';

function ResetSettings() {
  const { resetSettings } = useSettings();

  return (
    <section aria-labelledby="page-title">
      <h1 id="page-title">Configurações padrão</h1>
      <p>Restaure o tamanho da fonte, a cor de efeito e o tema originais.</p>
      <button className="reset-button" type="button" onClick={resetSettings}>
        Restaurar configurações
      </button>
    </section>
  );
}

export default ResetSettings;
