import { useSettings } from '../components/SettingsContext';

const ACCENT_COLORS = [
  { name: 'Azul', value: '#1976d2' },
  { name: 'Verde', value: '#2e7d32' },
  { name: 'Roxo', value: '#7b1fa2' },
  { name: 'Coral', value: '#d84343' },
];

function ColorSettings() {
  const { accentColor, setAccentColor } = useSettings();

  return (
    <section aria-labelledby="page-title">
      <h1 id="page-title">Cor de efeito</h1>
      <p>Escolha a cor de destaque usada em todo o site.</p>
      <div className="color-options" role="group" aria-label="Cores de destaque">
        {ACCENT_COLORS.map((color) => (
          <button
            className="color-option"
            type="button"
            key={color.value}
            onClick={() => setAccentColor(color.value)}
            aria-pressed={accentColor === color.value}
          >
            <span className="color-swatch" style={{ backgroundColor: color.value }} />
            {color.name}
          </button>
        ))}
      </div>
      <p className="accent-preview">Exemplo de texto com a cor de destaque.</p>
    </section>
  );
}

export default ColorSettings;
