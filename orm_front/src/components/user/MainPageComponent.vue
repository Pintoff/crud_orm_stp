<template>
    <section class="cards-wrapper">
        <div class="card-grid-space" v-for="post in posts" :key="post.userName">
          <a class="card" @click="openModal(post)" style="--bg-img: url(https://images1-focus-opensocial.googleusercontent.com/gadgets/proxy?container=focus&resize_w=1500&url=https://codetheweb.blog/assets/img/posts/html-syntax/cover.jpg)">
            <div>
                <h1>{{ post.postTitle }}</h1>
                <p>{{ post.postText }}</p>
                <div class="author">{{ post.userName }}</div>
                <div class="tags">
                    <div class="tag" v-for="(tag, tagIndex) in post.postTags" :key="tagIndex">{{ tag }}</div>
                </div>
            </div>
          </a>
        </div>


        <div class="modal" v-if="isModalOpen">
          <div class="modal-content">
            <h1>{{ selectedPost.postTitle }}</h1>
            <p>{{ selectedPost.postText }}</p>
            <div class="author">{{ selectedPost.userName }}</div>
            <div class="tags">
              <div class="tag" v-for="(tag, tagIndex) in selectedPost.postTags" :key="tagIndex">{{ tag }}</div>
            </div>
            <button @click="closeModal">Закрыть</button>
          </div>
        </div>
    </section>
</template>

<script>
export default {
  name: 'main-page-component',
  components: {
    
    },
  data() {
    return {
      users: [],
      posts: [],
      isModalOpen: false,
      selectedPost: null,
    }
  },
 computed: {
    },
 methods: {
      getPosts() {
        fetch('http://localhost:28023/api/users')
        .then(response => {
          if (!response.ok) {
            throw new Error('Network response was not ok');
          }
          return response.json();
        })
        .then(data => {
          this.users = data;
          this.posts = data.map(user => {
          const posts = user.posts.map(post => {
              return {
                  userName: user.login,
                  postTitle: post.title,
                  postText: post.text,
                  postTags: post.tags.map(tag => tag.name)
              };
          });
          return posts;
          }).flat();
        })
        .catch(error => {
          console.error('Ошибка при получении данных:', error);
        });
      },
      openModal(post) {
        this.selectedPost = post;
        this.isModalOpen = true;
      },
      closeModal() {
        this.selectedPost = null;
        this.isModalOpen = false;
      },
    },
 mounted(){
  this.getPosts();
    }
}
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css?family=Heebo:400,700|Open+Sans:400,700');

:root {
  --color: #3c3163;
  --transition-time: 0.5s;
}

* {
  box-sizing: border-box;
}

body {
  margin: 0;
  min-height: 100vh;
  font-family: 'Open Sans';
  background: #fafafa;
}

a {
  color: inherit;
}

.cards-wrapper {
  display: grid;
  justify-content: center;
  align-items: center;
  grid-template-columns: 1fr 1fr 1fr;
  grid-gap: 4rem;
  padding: 4rem;
  margin: 0 auto;
  width: max-content;
  padding-top: 10vh;
}

.card {
  font-family: 'Heebo';
  --bg-filter-opacity: 0.5;
  background-image: linear-gradient(rgba(0,0,0,var(--bg-filter-opacity)),rgba(0,0,0,var(--bg-filter-opacity))), var(--bg-img);
  height: 20em;
  width: 15em;
  font-size: 1.5em;
  color: white;
  border-radius: 1em;
  padding: 1em;
  /*margin: 2em;*/
  display: flex;
  align-items: flex-end;
  background-size: cover;
  background-position: center;
  box-shadow: 0 0 5em -1em black;
  transition: all, var(--transition-time);
  position: relative;
  overflow: hidden;
  border: 10px solid #ccc;
  text-decoration: none;
}

.card:hover {
  transform: rotate(0);
}

.card h1 {
  margin: 0;
  font-size: 1.5em;
  line-height: 1.2em;
}

.card p {
  font-size: 0.75em;
  font-family: 'Open Sans';
  margin-top: 0.5em;
  line-height: 2em;
}

.card .tags {
  display: flex;
}

.card .tags .tag {
  font-size: 0.75em;
  background: rgba(255,255,255,0.5);
  border-radius: 0.3rem;
  padding: 0 0.5em;
  margin-right: 0.5em;
  line-height: 1.5em;
  transition: all, var(--transition-time);
}

.card:hover .tags .tag {
  background: var(--color);
  color: white;
}

.card .author {
  position: absolute;
  top: 0;
  right: 0;
  font-size: 0.75em;
  padding: 1em;
  line-height: 1em;
  opacity: .8;
}

.card:before, .card:after {
  content: '';
  transform: scale(0);
  transform-origin: top left;
  border-radius: 50%;
  position: absolute;
  left: -50%;
  top: -50%;
  z-index: -5;
  transition: all, var(--transition-time);
  transition-timing-function: ease-in-out;
}

.card:before {
  background: #ddd;
  width: 250%;
  height: 250%;
}

.card:after {
  background: white;
  width: 200%;
  height: 200%;
}

.card:hover {
  color: var(--color);
}

.card:hover:before, .card:hover:after {
  transform: scale(1);
}

.card-grid-space .num {
  font-size: 3em;
  margin-bottom: 1.2rem;
  margin-left: 1rem;
}

.info {
  font-size: 1.2em;
  display: flex;
  padding: 1em 3em;
  height: 3em;
}

.info img {
  height: 3em;
  margin-right: 0.5em;
}

.info h1 {
  font-size: 1em;
  font-weight: normal;
}


@media screen and (max-width: 1285px) {
  .cards-wrapper {
    grid-template-columns: 1fr 1fr;
  }
}

@media screen and (max-width: 900px) {
  .cards-wrapper {
    grid-template-columns: 1fr;
  }
  .info {
    justify-content: center;
  }
  .card-grid-space .num {
    margin-left: 0;
    text-align: center;
  }
}

@media screen and (max-width: 500px) {
  .cards-wrapper {
    padding: 4rem 2rem;
  }
  .card {
    max-width: calc(100vw - 4rem);
  }
}

@media screen and (max-width: 450px) {
  .info {
    display: block;
    text-align: center;
  }
  .info h1 {
    margin: 0;
  }
}

.modal {
  display: flex;
  justify-content: center;
  align-items: center;
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-color: rgba(0, 0, 0, 0.5);
  z-index: 1000;
}

.modal-content {
  background-color: #fff;
  padding: 40px;
  border-radius: 8px;
  box-shadow: 0 0 20px rgba(0, 0, 0, 0.2);
  width: 70vw;
  text-align: left;
  position: relative;
  height: 40vh;
  display: flex;
  flex-direction: column;
  justify-content: space-between;
}

.modal-content h1 {
  font-size: 24px;
  margin-bottom: 20px;
}

.modal-content p {
  font-size: 16px;
  margin-bottom: 30px;
  line-height: 1.5;
}

.modal-content .author {
  font-size: 14px;
  color: #555;
  margin-bottom: 10px;
}

.modal-content .tags {
  display: flex;
  flex-wrap: wrap;
}

.modal-content .tag {
  background-color: #007bff;
  color: #fff;
  font-size: 12px;
  padding: 6px 12px;
  border-radius: 4px;
  margin-right: 10px;
  margin-bottom: 10px;
  cursor: pointer;
  transition: background-color 0.3s ease;
}

.modal-content .tag:hover {
  background-color: #0056b3;
}

.modal-content button {
  background-color: #007bff;
  color: #fff;
  border: none;
  padding: 10px 20px;
  font-size: 16px;
  border-radius: 4px;
  cursor: pointer;
  transition: background-color 0.3s ease;
}

.modal-content button:hover {
  background-color: #0056b3;
}

</style>