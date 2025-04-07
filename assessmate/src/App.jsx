import React from "react";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import LandingPage from "./Components/LandingPage";
import Login from "./Components/Login";
import SignUp from "./Components/Signup";
import RoleSelection from "./Components/RoleSelection";
// import StudentDashboard from "./Components/StudentDashboard"; // You'll need to create this
// import MentorDashboard from "./Components/MentorDashboard"; // You'll need to create this
import "./App.css";
import Dashboard from "./Components/Dashboard";
import Home from "./Components/Home";

function App() {
  return (
    <Router>
      <div className="App">
        <Routes>
          {/* Public routes */}
          <Route path="/" element={<LandingPage />} />
          <Route path="/login" element={<Login />} />
          <Route path="/signup" element={<SignUp />} />
          <Route path="/dashboard" element={<Dashboard />} />
          <Route path="/home" element={<Home />} />
          
          {/* Role selection (protected after login) */}
          <Route path="/select-role" element={<RoleSelection />} />
          
          {/* Protected dashboards */}
          {/* <Route path="/student/dashboard" element={<StudentDashboard />} />
          <Route path="/mentor/dashboard" element={<MentorDashboard />} />
           */}
          {/* Fallback route */}
          <Route path="*" element={<LandingPage />} />
        </Routes>
      </div>
    </Router>
  );
}

export default App;