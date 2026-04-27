import React, { useState } from "react";
import { FaShoppingCart, FaSearch } from "react-icons/fa";
import { useNavigate } from "react-router-dom";
import { useCart } from "@/context/CartContext";

const Header = ({ setSearch }) => {
  const [text, setText] = useState("");
  const navigate = useNavigate();
  const { cart } = useCart();

  // total items in cart
  const totalItems = cart.reduce((sum, item) => sum + item.quantity, 0);

  const handleSearch = () => {
    setSearch(text);
  };

  return (
    <nav className="navbar navbar-expand-lg navbar-dark bg-dark px-3">
      {/* LOGO */}
      <span
        className="navbar-brand fw-bold text-warning"
        style={{ cursor: "pointer" }}
        onClick={() => navigate("/")}
      >
        E-COM
      </span>

      {/* SEARCH */}
      <div className="flex-grow-1 mx-3 d-flex">
        <select className="form-select w-auto rounded-0">
          <option>All</option>
          <option>Electronics</option>
          <option>Fashion</option>
          <option>Books</option>
        </select>

        <input
          type="text"
          className="form-control rounded-0"
          placeholder="Search products..."
          value={text}
          onChange={(e) => setText(e.target.value)}
        />

        <button className="btn btn-warning rounded-0" onClick={handleSearch}>
          <FaSearch />
        </button>
      </div>

      {/* RIGHT SIDE */}
      <ul className="navbar-nav align-items-center">
        <li className="nav-item me-3">
          <a href="#" className="nav-link text-white">
            Hello, Sign in <br />
            <strong>Account</strong>
          </a>
        </li>

        <li className="nav-item me-3">
          <a href="#" className="nav-link text-white">
            Returns <br />
            <strong>& Orders</strong>
          </a>
        </li>

        {/* CART ICON */}
        <li className="nav-item position-relative">
          <div
            className="nav-link text-white d-flex align-items-center"
            style={{ cursor: "pointer" }}
            onClick={() => navigate("/cart")}
          >
            <FaShoppingCart size={20} />
            <span className="ms-1">Cart</span>
          </div>

          {/* BADGE */}
          {totalItems > 0 && (
            <span
              className="badge bg-danger position-absolute"
              style={{
                top: "0px",
                right: "0px",
                fontSize: "10px",
                borderRadius: "50%",
              }}
            >
              {totalItems}
            </span>
          )}
        </li>
      </ul>
    </nav>
  );
};

export default Header;
