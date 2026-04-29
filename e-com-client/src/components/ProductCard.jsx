import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import { useCart } from "@/context/CartContext";

const ProductCard = ({ product = {} }) => {
  const navigate = useNavigate();
  const { addToCart } = useCart();
  const [loading, setLoading] = useState(false);

  const {
    productId,
    productname = "No Name",
    brand = "Unknown",
    imageUrl,
    price = 0,
    discountPrice = 0,
    rating = 0,
    reviewCount = 0,
    stock = 0,
  } = product;

  const isOutOfStock = stock <= 0;

  const imageSrc = imageUrl || "https://picsum.photos/200";

  const hasDiscount = price > 0 && discountPrice > 0 && price > discountPrice;

  const discountPercent = hasDiscount
    ? Math.round(((price - discountPrice) / price) * 100)
    : 0;

  const finalPrice = hasDiscount ? discountPrice : price;

  const handleAddToCart = async () => {
    if (isOutOfStock || loading) return;

    setLoading(true);
    try {
      addToCart({
        productId,
        productname,
        brand,
        imageUrl,
        price,
        discountPrice,
        stock,
      });
    } finally {
      setLoading(false);
    }
  };

  return (
    <div className="col-md-3 mb-4">
      <div className="card h-100 shadow-sm border-0 position-relative">
        {discountPercent > 0 && (
          <span
            className="badge bg-danger position-absolute"
            style={{ top: 10, left: 10 }}
          >
            {discountPercent}% OFF
          </span>
        )}

        <div className="text-center p-3">
          <img
            src={imageSrc}
            alt={productname}
            className="img-fluid"
            style={{ height: 180, objectFit: "contain" }}
          />
        </div>

        <div className="card-body text-center">
          <small className="text-muted">{brand}</small>

          <h6 className="fw-bold">{productname}</h6>

          <div className="mb-1">
            ⭐ {rating} ({reviewCount})
          </div>

          <div className="mb-2">
            <span className="text-success fw-bold fs-5">₹{finalPrice}</span>{" "}
            {hasDiscount && <del className="text-muted">₹{price}</del>}
          </div>

          <button
            className={`btn w-100 ${
              isOutOfStock ? "btn-secondary" : "btn-warning"
            }`}
            disabled={isOutOfStock || loading}
            onClick={handleAddToCart}
          >
            {isOutOfStock
              ? "Out of Stock"
              : loading
                ? "Adding..."
                : "Add to Cart"}
          </button>

          <button
            className="btn btn-outline-primary w-100 mt-2"
            onClick={() => productId && navigate(`/product/${productId}`)}
          >
            View Details
          </button>
        </div>
      </div>
    </div>
  );
};

export default ProductCard;
