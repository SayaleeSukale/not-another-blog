import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import './index.css'
import App from './App.jsx'
// import 'bootstrap/dist/css/bootstrap.min.css'; // <--- comment out to test

// debug helpers to surface missing root or runtime errors
const rootEl = document.getElementById('root');
console.log('DEBUG: root element:', rootEl);
if (!rootEl) {
  document.body.innerHTML = '<pre style="color:red;padding:1rem">Error: No element with id="root" found. Check your project root index.html</pre>';
  throw new Error('No #root element');
}

window.addEventListener('error', (e) => {
  console.error('Uncaught error:', e.error ?? e.message);
  document.body.innerHTML = `<pre style="color:red;padding:1rem">Uncaught error: ${String(e.error ?? e.message)}</pre>`;
});
window.addEventListener('unhandledrejection', (e) => {
  console.error('Unhandled rejection:', e.reason);
  document.body.innerHTML = `<pre style="color:red;padding:1rem">Unhandled promise rejection: ${String(e.reason)}</pre>`;
});

try {
  createRoot(rootEl).render(
    <StrictMode>
      <App />
    </StrictMode>
  );
  console.log('DEBUG: React render attempted');
} catch (err) {
  console.error('Render error:', err);
  document.body.innerHTML = `<pre style="color:red;padding:1rem">Render error: ${String(err)}</pre>`;
}
