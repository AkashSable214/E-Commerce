import React, { useEffect, useState } from "react";
import axios from "axios";
import Header from "@/components/Header";
import ProductCard from "@/components/ProductCard";

const Home = () => {
  const [products, setProducts] = useState([]);
  const [search, setSearch] = useState("");

  useEffect(() => {
    const fetchProducts = async () => {
      try {
        const res = await axios.get(
          "http://localhost:8002/productApi/v1/all-product",
        );

        setProducts(res.data || []);
      } catch (err) {
        console.error("Error fetching products:", err);
      }
    };

    fetchProducts();
  }, []);

  const filteredProducts = products.filter((item) =>
    item.productname?.toLowerCase().includes(search.toLowerCase().trim()),
  );

  return (
    <>
      <Header setSearch={setSearch} />

      <div className="container mt-4">
        <h4>Products</h4>

        {search && (
          <p className="text-muted">
            Showing results for "<strong>{search}</strong>"
          </p>
        )}

        <div className="row">
          {filteredProducts.length > 0 ? (
            filteredProducts.map((item) => (
              <ProductCard key={item.productId} product={item} />
            ))
          ) : (
            <div className="col-12 text-center mt-4">
              <h5>No results found</h5>
              <button
                className="btn btn-outline-secondary mt-2"
                onClick={() => setSearch("")}
              >
                Clear Search
              </button>
            </div>
          )}
        </div>
      </div>
    </>
  );
};

export default Home;
