import { useState } from 'react';
import FontSettings from './telas/FontSettings';
import ColorSettings from './telas/ColorSettings';
import ThemeSettings from './telas/ThemeSettings';
import ResetSettings from './telas/ResetSettings';
import NavigationBar from './components/NavigationBar';
import { SettingsProvider, useSettings } from './components/SettingsContext';
import './App.css';

const SCREENS = {
  font: FontSettings,
  color: ColorSettings,
  theme: ThemeSettings,
  reset: ResetSettings,
};

function SettingsApp() {
  const [page, setPage] = useState('font');
  const CurrentScreen = SCREENS[page];
  const { fontSize, accentColor, theme } = useSettings();

  return (
    <div
      className={`App theme-${theme}`}
      style={{ '--font-size': `${fontSize}px`, '--accent-color': accentColor }}
    >
      <NavigationBar currentPage={page} onNavigate={setPage} />
      <main className="settings-panel">
        <CurrentScreen />
      </main>
    </div>
  );
}

function App() {
  return (
    <SettingsProvider>
      <SettingsApp />
    </SettingsProvider>
  );
}

export default App;
