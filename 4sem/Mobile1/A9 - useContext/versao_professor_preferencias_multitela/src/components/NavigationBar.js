import NavigationIcon from './NavigationIcon';

const PAGES = [
  { id: 'font', label: 'Fonte', icon: 'font' },
  { id: 'color', label: 'Cor de efeito', icon: 'color' },
  { id: 'theme', label: 'Tema', icon: 'theme' },
  { id: 'reset', label: 'Padrões', icon: 'reset' },
];

function NavigationBar({ currentPage, onNavigate }) {
  return (
    <nav className="top-navigation" aria-label="Navegação de configurações">
      <ul>
        {PAGES.map((item) => (
          <li key={item.id}>
            <button
              className="navigation-button"
              type="button"
              onClick={() => onNavigate(item.id)}
              aria-current={currentPage === item.id ? 'page' : undefined}
            >
              <NavigationIcon name={item.icon} />
              <span>{item.label}</span>
            </button>
          </li>
        ))}
      </ul>
    </nav>
  );
}

export default NavigationBar;
