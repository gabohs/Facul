import { fireEvent, render, screen } from '@testing-library/react';
import App from './App';

test('navigates between settings screens and applies settings globally', () => {
  render(<App />);
  const app = document.querySelector('.App');

  expect(screen.getByRole('heading', { name: 'Tamanho da fonte' })).toBeInTheDocument();
  fireEvent.click(screen.getByRole('button', { name: 'Aumentar tamanho da fonte' }));
  expect(app).toHaveStyle({ '--font-size': '18px' });

  fireEvent.click(screen.getByRole('button', { name: 'Cor de efeito' }));
  fireEvent.click(screen.getByRole('button', { name: 'Verde' }));
  expect(app).toHaveStyle({ '--accent-color': '#2e7d32' });

  fireEvent.click(screen.getByRole('button', { name: 'Tema' }));
  fireEvent.click(screen.getByRole('button', { name: 'Escuro' }));
  expect(app).toHaveClass('theme-dark');

  fireEvent.click(screen.getByRole('button', { name: 'Padrões' }));
  fireEvent.click(screen.getByRole('button', { name: 'Restaurar configurações' }));
  expect(app).toHaveStyle({ '--font-size': '16px', '--accent-color': '#1976d2' });
  expect(app).toHaveClass('theme-light');
});
