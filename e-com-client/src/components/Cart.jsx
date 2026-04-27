import React from "react";
import { useCart } from "@/context/CartContext";
import { useNavigate } from "react-router-dom";

const Cart = () => {
  const { cart, removeFromCart, increaseQty, decreaseQty } = useCart();

  const navigate = useNavigate();

  //  TOTAL
  const total = cart.reduce(
    (sum, item) => sum + (item.discountPrice || item.price) * item.quantity,
    0,
  );

  //  ORIGINAL TOTAL
  const originalTotal = cart.reduce(
    (sum, item) => sum + item.price * item.quantity,
    0,
  );

  const savings = originalTotal - total;

  return (
    <div className="container mt-4">
      {/* HEADER */}
      <div className="d-flex justify-content-between align-items-center mb-4">
        <h3>🛒 My Cart</h3>

        <button
          className="btn btn-outline-primary"
          onClick={() => navigate("/")}
        >
          ← Continue Shopping
        </button>
      </div>

      {/* EMPTY CART UI */}
      {cart.length === 0 ? (
        <div className="text-center p-5 border rounded shadow-sm">
          <h4>Your cart is empty 🛒</h4>
          <p className="text-muted">
            Looks like you haven’t added anything yet.
          </p>

          <button
            className="btn btn-warning mt-3"
            onClick={() => navigate("/")}
          >
            Start Shopping
          </button>
        </div>
      ) : (
        <div className="row">
          {/* LEFT SIDE - CART ITEMS */}
          <div className="col-md-8">
            {cart.map((item) => (
              <div key={item.id} className="card mb-3 shadow-sm border-0">
                <div className="row g-0 align-items-center">
                  {/* IMAGE */}
                  <div className="col-md-3 text-center p-3">
                    <img
                      src={item.image}
                      alt={item.productname}
                      className="img-fluid"
                      style={{ height: "120px", objectFit: "contain" }}
                    />
                  </div>

                  {/* DETAILS */}
                  <div className="col-md-6 p-3">
                    <h6 className="fw-bold">{item.productname}</h6>

                    <p className="mb-1">
                      <span className="text-success fw-bold">
                        ₹{item.discountPrice || item.price}
                      </span>{" "}
                      <del className="text-muted">₹{item.price}</del>
                    </p>

                    <small className="text-success">
                      You save ₹
                      {item.price - (item.discountPrice || item.price)}
                    </small>

                    {/* QTY CONTROLS */}
                    <div className="d-flex align-items-center mt-3">
                      <button
                        className="btn btn-sm btn-outline-secondary"
                        onClick={() => decreaseQty(item.id)}
                      >
                        −
                      </button>

                      <span className="mx-3 fw-bold">{item.quantity}</span>

                      <button
                        className="btn btn-sm btn-outline-secondary"
                        onClick={() => increaseQty(item.id)}
                      >
                        +
                      </button>
                    </div>
                  </div>

                  {/* PRICE + REMOVE */}
                  <div className="col-md-3 p-3 text-end">
                    <h6 className="text-success">
                      ₹{(item.discountPrice || item.price) * item.quantity}
                    </h6>

                    <button
                      className="btn btn-sm btn-danger mt-3"
                      onClick={() => removeFromCart(item.id)}
                    >
                      Remove
                    </button>
                  </div>
                </div>
              </div>
            ))}
          </div>

          {/* RIGHT SIDE - SUMMARY */}
          <div className="col-md-4">
            <div
              className="card shadow-sm p-3 position-sticky"
              style={{ top: "20px" }}
            >
              <h5 className="mb-3">Price Details</h5>

              <hr />

              <p>
                Total Items: <b>{cart.length}</b>
              </p>

              <p>
                Total Amount: <b>₹{total}</b>
              </p>

              <p className="text-success">You Saved: ₹{savings}</p>

              <hr />

              <button className="btn btn-warning w-100">
                Proceed to Checkout
              </button>

              <button
                className="btn btn-outline-secondary w-100 mt-2"
                onClick={() => navigate("/")}
              >
                Continue Shopping
              </button>
            </div>
          </div>
        </div>
      )}
    </div>
  );
};

export default Cart;
