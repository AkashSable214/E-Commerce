import React from "react";
import { useParams } from "react-router-dom";

const products = [
  {
    id: 1,
    productname: "Smartphone",
    price: 14999,
    discountPrice: 12999,
    brand: "Samsung",
    rating: 4.5,
    reviewCount: 1200,
    description: "Best smartphone with AMOLED display and 5G support",
    image: "https://via.placeholder.com/300",
    color: "Black",
    size: "6.5 inch",
  },
  {
    id: 2,
    productname: "Headphones",
    price: 1999,
    discountPrice: 1499,
    brand: "Boat",
    rating: 4.2,
    reviewCount: 800,
    description: "High bass wireless headphones",
    image: "https://via.placeholder.com/300",
    color: "Red",
    size: "Standard",
  },
];

const ProductDetails = () => {
  const { id } = useParams();

  const product = products.find((p) => p.id === Number(id));

  if (!product) {
    return <h3 className="text-center mt-5">Product not found</h3>;
  }

  // 🔥 Discount %
  const discountPercent = Math.round(
    ((product.price - product.discountPrice) / product.price) * 100
  );

  return (
    <div className="container mt-5">

      <div className="row">

        {/* IMAGE SECTION */}
        <div className="col-md-5 text-center">

          <div className="border p-3 shadow-sm">

            <img
              src={product.image}
              alt={product.productname}
              className="img-fluid"
              style={{ height: "300px", objectFit: "contain" }}
            />

          </div>

        </div>

        {/* DETAILS SECTION */}
        <div className="col-md-7">

          {/* Brand */}
          <p className="text-muted mb-1">{product.brand}</p>

          {/* Name */}
          <h2 className="fw-bold">{product.productname}</h2>

          {/* Rating */}
          <p className="mb-2">
            ⭐ {product.rating} | {product.reviewCount} reviews
          </p>

          {/* Price Section */}
          <h3 className="text-success">
            ₹{product.discountPrice}{" "}
            <del className="text-danger fs-5">₹{product.price}</del>
          </h3>

          {/* Discount Badge */}
          <span className="badge bg-danger mb-2">
            {discountPercent}% OFF
          </span>

          {/* Description */}
          <p className="mt-3 text-muted">
            {product.description}
          </p>

          {/* Extra Info */}
          <div className="mt-3">
            <p><b>Color:</b> {product.color}</p>
            <p><b>Size:</b> {product.size}</p>
          </div>

          {/* Buttons */}
          <div className="mt-4">

            <button className="btn btn-warning me-3 px-4">
              Add to Cart
            </button>

            <button className="btn btn-success px-4">
              Buy Now
            </button>

          </div>

        </div>

      </div>

    </div>
  );
};

export default ProductDetails;