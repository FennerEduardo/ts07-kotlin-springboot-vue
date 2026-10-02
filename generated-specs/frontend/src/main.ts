import { createApp } from 'vue';
import { createPinia } from 'pinia';
import OrquestacionDeSagaConCorrutinasEnKotlinSpringBootPanel from './components/OrquestacionDeSagaConCorrutinasEnKotlinSpringBootPanel.vue';

createApp(OrquestacionDeSagaConCorrutinasEnKotlinSpringBootPanel).use(createPinia()).mount('#app');
