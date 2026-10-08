import { useSettings } from '../components/SettingsContext';

function ThemeSettings() {
  const { theme, setTheme } = useSettings();

  return (
    <section aria-labelledby="page-title">
      <h1 id="page-title">Tema</h1>
      <p>Altere a aparência de todas as telas.</p>
      <div className="setting-control">
        <button
          type="button"
          aria-pressed={theme === 'light'}
          onClick={() => setTheme('light')}
        >
          Claro
        </button>
        <button
          type="button"
          aria-pressed={theme === 'dark'}
          onClick={() => setTheme('dark')}
        >
          Escuro
        </button>
      </div>
    </section>
  );
}

export default ThemeSettings;
