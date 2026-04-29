import React, { useEffect, useState } from "react";
import axios from "axios";

const AdminProduct = () => {
  const [products, setProducts] = useState([]);

  useEffect(() => {
    loadProducts();
  }, []);

  const loadProducts = async () => {
    try {
      const res = await axios.get(
        "http://localhost:8002/productApi/v1/all-product",
      );
      setProducts(res.data);
    } catch (err) {
      console.error(err);
    }
  };

  const getImageSrc = (img) => {
    if (!img) return null;
    if (img.startsWith("data:image")) return img;
    return `data:image/jpeg;base64,${img}`;
  };

  return (
    <div className="container mt-4">
      <h3 className="mb-4"> Admin Product Management</h3>

      <div className="table-responsive">
        <table className="table table-striped table-hover align-middle shadow-sm">
          <thead className="table-dark">
            <tr>
              <th>#ID</th>
              <th>Image</th>
              <th>Product</th>
              <th>Brand</th>
              <th>Price</th>
              <th>Stock</th>
              <th>Rating</th>
              <th>Actions</th>
            </tr>
          </thead>

          <tbody>
            {products.length > 0 ? (
              products.map((p) => (
                <tr key={p.productId}>
                  {/* ID */}
                  <td>{p.productId}</td>

                  {/* IMAGE */}
                  <td>
                    {p.image ? (
                      <img
                        src={getImageSrc(p.image)}
                        alt={p.productname}
                        style={{
                          width: "55px",
                          height: "55px",
                          objectFit: "cover",
                          borderRadius: "6px",
                        }}
                      />
                    ) : (
                      "No Image"
                    )}
                  </td>

                  {/* PRODUCT NAME */}
                  <td>
                    <strong>{p.productname}</strong>
                    <div style={{ fontSize: "12px", color: "gray" }}>
                      {p.sku}
                    </div>
                  </td>

                  {/* BRAND */}
                  <td>{p.brand}</td>

                  {/* PRICE */}
                  <td>₹{p.price}</td>

                  {/* STOCK (from inventory if exists) */}
                  <td>{p.inventory?.stockQuantity ?? "N/A"}</td>

                  {/* RATING */}
                  <td>
                    ⭐ {p.rating} ({p.reviewCount})
                  </td>

                  {/* ACTIONS */}
                  <td>
                    <button className="btn btn-sm btn-primary me-2">
                      Edit
                    </button>
                    <button className="btn btn-sm btn-danger">Delete</button>
                  </td>
                </tr>
              ))
            ) : (
              <tr>
                <td colSpan="8" className="text-center">
                  No Products Found
                </td>
              </tr>
            )}
          </tbody>
        </table>
      </div>
    </div>
  );
};

export default AdminProduct;
