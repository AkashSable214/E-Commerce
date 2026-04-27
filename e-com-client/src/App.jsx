import React from "react";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import Register from "@/pages/Register";
import Home from "@/pages/Home";
import Login from "@/pages/Login";
import ErrorPage from "@/pages/ErrorPage";
import Cart from "@/components/Cart";
import ProductDetails from "@/components/ProductDetails";
import DashboardLayout from "@/layout/DashboardLayout";
import Dashboard from "@/components/dashboard/Dashboard";
import ProductsPage from "@/components/dashboard/ProductsPage";
import ProductRegister from "@/components/dashboard/ProductRegister";
const App = () => {
  return (
    <>
      <Router>
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/login" element={<Login />} />
          <Route path="/register" element={<Register />} />
          <Route path="/product/:id" element={<ProductDetails />} />
          <Route path="/cart" element={<Cart />} />
          {/* Dashboard  */}
          <Route path="/dashboard" element={<DashboardLayout />}>
            <Route index element={<Dashboard />} />
            <Route path="products" element={<ProductsPage />} />
            <Route path="add-product" element={<ProductRegister />} />
          </Route>
          {/* Catch-all route for 404 */}
          <Route path="*" element={<ErrorPage />} />
        </Routes>
      </Router>
    </>
  );
};

export default App;
