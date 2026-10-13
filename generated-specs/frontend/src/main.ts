import { createApp, h } from 'vue';
import { createPinia } from 'pinia';
import OrquestacionDeSagaConCorrutinasEnKotlinSpringBootPanel from './components/OrquestacionDeSagaConCorrutinasEnKotlinSpringBootPanel.vue';

const App = { render: () => [h(OrquestacionDeSagaConCorrutinasEnKotlinSpringBootPanel)] };

createApp(App).use(createPinia()).mount('#app');
