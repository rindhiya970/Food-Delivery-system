<template>
  <div>
    <h2>Login</h2>

    <el-input v-model="email" placeholder="Email" />
    <el-input v-model="password" type="password" placeholder="Password" />

    <el-button type="primary" @click="login">Login</el-button>
  </div>
</template>

<script lang="ts">
import axios from "axios";
import { defineComponent } from "vue";

export default defineComponent({
  name: "Login",

  data() {
    return {
      email: "",
      password: "",
    };
  },

  methods: {
    async login() {
      try {
        const res = await axios.post("http://localhost:8080/api/auth/login", {
          email: this.email,
          password: this.password,
        });

        localStorage.setItem("token", res.data.token);
        this.$router.push("/dashboard");
      } catch (err) {
        alert("Invalid credentials");
      }
    },
  },
});
</script>
