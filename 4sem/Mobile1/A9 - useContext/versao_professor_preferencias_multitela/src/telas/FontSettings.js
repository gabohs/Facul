import { useSettings } from '../components/SettingsContext';

function FontSettings() {
  const { fontSize, setFontSize } = useSettings();

  return (
    <section aria-labelledby="page-title">
      <h1 id="page-title">Tamanho da fonte</h1>
      <p>Ajuste o tamanho dos textos em todo o site.</p>
      <div className="setting-control">
        <button
          type="button"
          onClick={() => setFontSize((size) => Math.max(12, size - 2))}
          disabled={fontSize <= 12}
          aria-label="Diminuir tamanho da fonte"
        >
          A−
        </button>
        <output aria-live="polite">{fontSize}px</output>
        <button
          type="button"
          onClick={() => setFontSize((size) => Math.min(28, size + 2))}
          disabled={fontSize >= 28}
          aria-label="Aumentar tamanho da fonte"
        >
          A+
        </button>
      </div>
      <p className="font-preview">Este texto demonstra o tamanho selecionado.</p>
    </section>
  );
}

export default FontSettings;
