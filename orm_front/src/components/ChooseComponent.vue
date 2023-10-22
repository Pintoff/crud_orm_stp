<template>
    <div class="choose-box">
        <button class="btn" role="button" @click="showComponent('users')">Users</button>
        <button class="btn" role="button" @click="showComponent('posts')">Posts</button>
        <button class="btn" role="button" @click="showComponent('tags')">Tags</button>
    </div>
  </template>

<script>
export default {
  name: 'choose-component',
  components: {
    },
  data() {
    return {
      
    }
  },
 computed: {
    },
 methods: {
      showComponent(componentName) {
        this.$router.push({ name: componentName});
      }
    },
 mounted(){
      
    }
}
</script>

<style scoped>

.choose-box {
    width: 100%;
    height: 50vh;
    display: flex;
    align-items: center;
    justify-content: space-around;
}

.btn {
  align-items: center;
  background-color: #fff;
  border: 2px solid #000;
  box-sizing: border-box;
  color: #000;
  cursor: pointer;
  display: inline-flex;
  fill: #000;
  font-family: Inter,sans-serif;
  font-size: 16px;
  font-weight: 600;
  height: 48px;
  justify-content: center;
  letter-spacing: -.8px;
  line-height: 24px;
  min-width: 140px;
  outline: 0;
  padding: 0 17px;
  text-align: center;
  text-decoration: none;
  transition: all .3s;
  user-select: none;
  -webkit-user-select: none;
  touch-action: manipulation;
}

.btn:focus {
  color: #171e29;
}

.btn:hover {
  border-color: #4fc3a1;
  color: #4fc3a1;
  fill: #4fc3a1;
}

.btn:active {
  border-color: #4fc3a1;
  color: #4fc3a1;
  fill: #4fc3a1;
}

@media (min-width: 768px) {
  .btn {
    min-width: 170px;
  }
}
</style>