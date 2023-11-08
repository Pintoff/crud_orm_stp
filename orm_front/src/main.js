import { createApp } from 'vue';
import { createRouter, createWebHistory } from 'vue-router';
import './style.css';
import App from './App.vue';
import ChooseComponent from './components/admin/ChooseComponent.vue';
import UsersTable from './components/admin/UsersTable.vue';
import PostTable from './components/admin/PostTable.vue';
import TagTable from './components/admin/TagTable.vue';
import MainPage from './components/user/MainPageComponent.vue'

const routes = [
  { path: '/', name: 'main-page-component', component: MainPage },
  { path: '/admin', name: 'choose-component', component: ChooseComponent },
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

