function NavigationIcon({ name }) {
  const paths = {
    font: <><path d="M4 19 9 5h2l5 14" /><path d="M6 14h8M17 19h4M19 5v14" /></>,
    color: <><path d="M12 3a9 9 0 1 0 0 18h1a2 2 0 0 0 1.5-3.3 1.8 1.8 0 0 1 1.4-3h1.1A4 4 0 0 0 21 10.6C21 6.4 17 3 12 3Z" /><path d="M7.5 10h.01M10 7.5h.01M14 7.5h.01" /></>,
    theme: <><circle cx="12" cy="12" r="9" /><path d="M12 3v18a9 9 0 0 0 0-18Z" /></>,
    reset: <><path d="M3 11a9 9 0 1 1 2.6 6.4" /><path d="M3 4v7h7" /></>,
  };

  return (
    <svg
      aria-hidden="true"
      className="navigation-icon"
      viewBox="0 0 24 24"
      fill="none"
      stroke="currentColor"
      strokeWidth="1.8"
      strokeLinecap="round"
      strokeLinejoin="round"
    >
      {paths[name]}
    </svg>
  );
}

export default NavigationIcon;
