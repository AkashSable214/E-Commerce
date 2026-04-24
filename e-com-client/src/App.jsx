import React from "react";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import Register from "@/pages/Register";

const App = () => {
  return (
    <>
      <Route path="/" element={<Home />} />
      <Route path="/login" element={<Login />} />
      <Route path="/register" element={<Register />} />

      {/* Catch-all route for 404 */}
      <Route path="*" element={<ErrorPage />} />
    </>
  );
};

export default App;
