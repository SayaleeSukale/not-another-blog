import axios from "axios";

// Create an Axios instance with base config
const API = axios.create({
  baseURL: "http://localhost:8080/api", // adjust if your backend URL changes
  headers: {
    "Content-Type": "application/json",
  },
});

// Add a request interceptor to attach JWT token automatically if available
API.interceptors.request.use(
  (config) => {
    const token = localStorage.getItem("token"); // get token from localStorage
    if (token) {
      config.headers.Authorization = `Bearer ${token}`;
    }
    return config;
  },
  (error) => Promise.reject(error)
);

// Auth APIs
export const registerUser = (data) => API.post("/auth/register", data);
export const loginUser = (data) => API.post("/auth/login", data);

// Post APIs
export const getPosts = () => API.get("/posts");
export const createPost = (data) => API.post("/posts", data);
export const getPostById = (id) => API.get(`/posts/${id}`);
export const getPostsByCategory = (category) => API.get(`/posts/category/${category}`);
export const getPostsByTitle = (title) => API.get(`/posts/title/${title}`);

export default API;
