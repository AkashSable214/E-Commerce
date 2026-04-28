import React from "react";
import { useNavigate } from "react-router-dom";
import { useCart } from "@/context/CartContext";

const ProductCard = ({ product = {} }) => {
  const navigate = useNavigate();
  const { addToCart } = useCart();

  const {
    id,
    productname = "No Name",
    brand = "Unknown",
    image = "https://via.placeholder.com/200",
    price = 0,
    discountPrice = 0,
    rating = 0,
    reviewCount = 0,
    stock = 0,
  } = product;

  const isOutOfStock = stock <= 0;

  //  discount %
  const discountPercent =
    price && discountPrice
      ? Math.round(((price - discountPrice) / price) * 100)
      : 0;

  //  SAFE ADD TO CART (IMPORTANT FIX)
  const handleAddToCart = () => {
    addToCart({
      id,
      productname,
      brand,
      image,
      price,
      discountPrice,
      stock,
    });
  };

  return (
    <div className="col-md-3 mb-4">
      <div className="card h-100 shadow-sm border-0 position-relative">
        {/* DISCOUNT BADGE */}
        {discountPercent > 0 && (
          <span
            className="badge bg-danger position-absolute"
            style={{ top: 10, left: 10 }}
          >
            {discountPercent}% OFF
          </span>
        )}

        {/* IMAGE */}
        <div className="text-center p-3">
          <img
            src={image}
            alt={productname}
            className="img-fluid"
            style={{ height: 180, objectFit: "contain" }}
          />
        </div>

        {/* DETAILS */}
        <div className="card-body text-center">
          <small className="text-muted">{brand}</small>

          <h6 className="fw-bold">{productname}</h6>

          {/* RATING */}
          <div className="mb-1">
            ⭐ {rating} <span className="text-muted">({reviewCount})</span>
          </div>

          {/* PRICE */}
          <div className="mb-2">
            <span className="text-success fw-bold fs-5">₹{discountPrice}</span>{" "}
            <del className="text-muted">₹{price}</del>
          </div>

          {/* BUTTON */}
          <button
            className={`btn w-100 ${
              isOutOfStock ? "btn-secondary" : "btn-warning"
            }`}
            disabled={isOutOfStock}
            onClick={handleAddToCart}
          >
            {isOutOfStock ? "Out of Stock" : "Add to Cart"}
          </button>

          <button
            className="btn btn-outline-primary w-100 mt-2"
            onClick={() => navigate(`/product/${id}`)}
          >
            View Details
          </button>
        </div>
      </div>
    </div>
  );
};

export default ProductCard;
