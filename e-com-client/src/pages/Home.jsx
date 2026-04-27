import React, { useState } from "react";
import Header from "@/components/Header";
import ProductCard from "@/components/ProductCard";

const products = [
  {
    id: 1,
    productname: "Samsung Galaxy S23",
    description: "Flagship smartphone with AMOLED display and 5G support",
    price: 14999,
    discountPrice: 12999,
    brand: "Samsung",
    image: "https://via.placeholder.com/300",
    rating: 4.5,
    reviewCount: 1200,
    color: "Black",
    size: "6.5 inch",
    category: "Mobile",
    stock: 25,
  },
  {
    id: 2,
    productname: "Boat Rockerz 255",
    description: "Wireless neckband with deep bass sound",
    price: 1999,
    discountPrice: 1499,
    brand: "boAt",
    image: "https://via.placeholder.com/300",
    rating: 4.2,
    reviewCount: 800,
    color: "Red",
    size: "Standard",
    category: "Audio",
    stock: 50,
  },
  {
    id: 3,
    productname: "HP Pavilion Laptop",
    description: "Intel i5 laptop with 16GB RAM and SSD storage",
    price: 55999,
    discountPrice: 49999,
    brand: "HP",
    image: "https://via.placeholder.com/300",
    rating: 4.6,
    reviewCount: 2100,
    color: "Silver",
    size: "15.6 inch",
    category: "Laptop",
    stock: 10,
  },
  {
    id: 4,
    productname: "Nike Running Shoes",
    description: "Comfortable running shoes for daily use",
    price: 2499,
    discountPrice: 1999,
    brand: "Nike",
    image: "https://via.placeholder.com/300",
    rating: 4.3,
    reviewCount: 650,
    color: "White",
    size: "9 UK",
    category: "Footwear",
    stock: 100,
  },
  {
    id: 5,
    productname: "Apple AirPods Pro",
    description: "Active noise cancellation earbuds",
    price: 24999,
    discountPrice: 19999,
    brand: "Apple",
    image: "https://via.placeholder.com/300",
    rating: 4.8,
    reviewCount: 3200,
    color: "White",
    size: "One Size",
    category: "Audio",
    stock: 40,
  },
  {
    id: 6,
    productname: "Dell Inspiron Laptop",
    description: "Powerful laptop for office and gaming",
    price: 65000,
    discountPrice: 58999,
    brand: "Dell",
    image: "https://via.placeholder.com/300",
    rating: 4.4,
    reviewCount: 1500,
    color: "Black",
    size: "15.6 inch",
    category: "Laptop",
    stock: 20,
  },
  {
    id: 7,
    productname: "OnePlus Nord CE 3",
    description: "Fast and smooth performance smartphone",
    price: 24999,
    discountPrice: 21999,
    brand: "OnePlus",
    image: "https://via.placeholder.com/300",
    rating: 4.5,
    reviewCount: 1800,
    color: "Blue",
    size: "6.7 inch",
    category: "Mobile",
    stock: 30,
  },
  {
    id: 8,
    productname: "Adidas Sneakers",
    description: "Stylish sneakers for everyday wear",
    price: 3499,
    discountPrice: 2799,
    brand: "Adidas",
    image: "https://via.placeholder.com/300",
    rating: 4.3,
    reviewCount: 900,
    color: "Black",
    size: "10 UK",
    category: "Footwear",
    stock: 60,
  },
  {
    id: 9,
    productname: "Sony Headphones WH-1000XM4",
    description: "Premium noise cancelling headphones",
    price: 29999,
    discountPrice: 24999,
    brand: "Sony",
    image: "https://via.placeholder.com/300",
    rating: 4.7,
    reviewCount: 4100,
    color: "Black",
    size: "One Size",
    category: "Audio",
    stock: 15,
  },
  {
    id: 10,
    productname: "iPhone 14",
    description: "Apple flagship smartphone",
    price: 79999,
    discountPrice: 74999,
    brand: "Apple",
    image: "https://via.placeholder.com/300",
    rating: 4.9,
    reviewCount: 5000,
    color: "Blue",
    size: "6.1 inch",
    category: "Mobile",
    stock: 12,
  },
  {
    id: 11,
    productname: "Lenovo ThinkPad",
    description: "Business laptop with strong performance",
    price: 72000,
    discountPrice: 65999,
    brand: "Lenovo",
    image: "https://via.placeholder.com/300",
    rating: 4.5,
    reviewCount: 1100,
    color: "Black",
    size: "14 inch",
    category: "Laptop",
    stock: 18,
  },
  {
    id: 12,
    productname: "Realme Buds Air",
    description: "Affordable wireless earbuds",
    price: 2999,
    discountPrice: 1999,
    brand: "Realme",
    image: "https://via.placeholder.com/300",
    rating: 4.1,
    reviewCount: 700,
    color: "White",
    size: "One Size",
    category: "Audio",
    stock: 80,
  },
  {
    id: 13,
    productname: "Puma Running Shoes",
    description: "Lightweight sports shoes",
    price: 2999,
    discountPrice: 2299,
    brand: "Puma",
    image: "https://via.placeholder.com/300",
    rating: 4.2,
    reviewCount: 600,
    color: "Grey",
    size: "9 UK",
    category: "Footwear",
    stock: 70,
  },
  {
    id: 14,
    productname: "Asus ROG Laptop",
    description: "Gaming laptop with RTX graphics",
    price: 120000,
    discountPrice: 110000,
    brand: "Asus",
    image: "https://via.placeholder.com/300",
    rating: 4.8,
    reviewCount: 900,
    color: "Black",
    size: "15.6 inch",
    category: "Laptop",
    stock: 8,
  },
  {
    id: 15,
    productname: "Xiaomi Redmi Note 12",
    description: "Budget smartphone with good performance",
    price: 14999,
    discountPrice: 12999,
    brand: "Xiaomi",
    image: "https://via.placeholder.com/300",
    rating: 4.3,
    reviewCount: 2500,
    color: "Blue",
    size: "6.5 inch",
    category: "Mobile",
    stock: 90,
  },
  {
    id: 16,
    productname: "JBL Flip Speaker",
    description: "Portable Bluetooth speaker",
    price: 8999,
    discountPrice: 7499,
    brand: "JBL",
    image: "https://via.placeholder.com/300",
    rating: 4.6,
    reviewCount: 1400,
    color: "Black",
    size: "Medium",
    category: "Audio",
    stock: 35,
  },
  {
    id: 17,
    productname: "Crocs Classic Clogs",
    description: "Comfortable everyday footwear",
    price: 2999,
    discountPrice: 2499,
    brand: "Crocs",
    image: "https://via.placeholder.com/300",
    rating: 4.4,
    reviewCount: 1800,
    color: "Green",
    size: "10 UK",
    category: "Footwear",
    stock: 120,
  },
  {
    id: 18,
    productname: "MacBook Air M2",
    description: "Apple lightweight laptop",
    price: 114999,
    discountPrice: 109999,
    brand: "Apple",
    image: "https://via.placeholder.com/300",
    rating: 4.9,
    reviewCount: 3000,
    color: "Silver",
    size: "13 inch",
    category: "Laptop",
    stock: 5,
  },
  {
    id: 19,
    productname: "Noise Smartwatch",
    description: "Fitness tracking smartwatch",
    price: 4999,
    discountPrice: 3999,
    brand: "Noise",
    image: "https://via.placeholder.com/300",
    rating: 4.2,
    reviewCount: 1100,
    color: "Black",
    size: "Adjustable",
    category: "Wearable",
    stock: 60,
  },
  {
    id: 20,
    productname: "Fastrack Watch",
    description: "Stylish analog watch",
    price: 1999,
    discountPrice: 1499,
    brand: "Fastrack",
    image: "https://via.placeholder.com/300",
    rating: 4.1,
    reviewCount: 900,
    color: "Brown",
    size: "Free Size",
    category: "Accessories",
    stock: 75,
  },
];

const Home = () => {
  const [search, setSearch] = useState("");

  // If search empty → show all products
  // If search exists → show only matching
  const filteredProducts = search
    ? products.filter((item) =>
        item.name.toLowerCase().includes(search.toLowerCase().trim()),
      )
    : products;

  return (
    <>
      <Header setSearch={setSearch} />

      <div className="container mt-4">
        <h4>Products</h4>

        {/* Showing search text */}
        {search && (
          <p className="text-muted">
            Showing results for "<strong>{search}</strong>"
          </p>
        )}

        <div className="row">
          {filteredProducts.length > 0 ? (
            filteredProducts.map((item) => (
              <ProductCard key={item.id} product={item} />
            ))
          ) : (
            <div className="col-12 text-center mt-4">
              <h5>No results found</h5>
              <p>
                for "<strong>{search}</strong>"
              </p>

              {/* Clear button */}
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
