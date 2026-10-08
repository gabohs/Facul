import { createContext, useContext, useState } from 'react';

const SettingsContext = createContext(null);

const DEFAULT_SETTINGS = {
  fontSize: 16,
  accentColor: '#1976d2',
  theme: 'light',
};

export function SettingsProvider({ children }) {
  const [fontSize, setFontSize] = useState(DEFAULT_SETTINGS.fontSize);
  const [accentColor, setAccentColor] = useState(DEFAULT_SETTINGS.accentColor);
  const [theme, setTheme] = useState(DEFAULT_SETTINGS.theme);

  const resetSettings = () => {
    setFontSize(DEFAULT_SETTINGS.fontSize);
    setAccentColor(DEFAULT_SETTINGS.accentColor);
    setTheme(DEFAULT_SETTINGS.theme);
  };

  return (
    <SettingsContext.Provider
      value={{ fontSize, setFontSize, accentColor, setAccentColor, theme, setTheme, resetSettings }}
    >
      {children}
    </SettingsContext.Provider>
  );
}

export function useSettings() {
  const settings = useContext(SettingsContext);

  if (!settings) {
    throw new Error('useSettings must be used within a SettingsProvider');
  }

  return settings;
}
