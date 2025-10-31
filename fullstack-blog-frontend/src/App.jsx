import React from "react"; 
import { BrowserRouter as Router, Routes, Route } from "react-router-dom"; 
import Navbar from "./components/Navbar"; 
import Register from "./components/Register"; 
import Login from "./components/Login"; 
import Postss from "./components/Posts";
// import Posts from "./components/Posts"; 
import "bootstrap/dist/css/bootstrap.min.css"; 
function App() { 
  return (
  
  <Router> 
    <Navbar /> 
    <div className="container mt-4"> 
      <Routes> 
        {/* <Route path="/" element={<Posts />} />  */}
        <Route path="/register" element={<Register />} /> 
        <Route path="/login" element={<Login />} /> 
        </Routes> 
        </div> 
        </Router>
        ); 
      }
export default App;