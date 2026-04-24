import React from "react";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import Register from "@/pages/Register";
import Home from "@/pages/Home";
import Login from "@/pages/Login";
import ErrorPage from "@/pages/ErrorPage";
const App = () => {
  return (
    <>
      <Router>
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/login" element={<Login />} />
          <Route path="/register" element={<Register />} />

          {/* Catch-all route for 404 */}
          <Route path="*" element={<ErrorPage />} />
        </Routes>
      </Router>
    </>
  );
};

export default App;
