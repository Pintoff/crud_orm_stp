import { createApp } from 'vue'
import { createRouter, createWebHistory } from 'vue-router';
import './style.css'
import App from './App.vue'
import ChooseComponent from './components/ChooseComponent.vue';
import UsersTable from './components/UsersTable.vue';
import PostTable from './components/PostTable.vue';
import TagTable from './components/TagTable.vue';


const routes = [
  { path: '/', name: 'choose-component', component: ChooseComponent },
  { path: '/users', name: 'users', component: UsersTable },
  { path: '/posts', name: 'posts', component: PostTable },
  { path: '/tags', name: 'tags', component: TagTable },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

const app = createApp(App);
app.use(router);
app.component('ChooseComponent', ChooseComponent);
app.mount('#app');

