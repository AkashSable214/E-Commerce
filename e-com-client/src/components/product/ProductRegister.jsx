import React, { useEffect, useState } from "react";
import { useForm } from "react-hook-form";
import axios from "axios";

const ProductForm = () => {
  const [step, setStep] = useState(1);
  const [categories, setCategories] = useState([]);
  const [preview, setPreview] = useState(null);

  const { register, handleSubmit, trigger, reset } = useForm();

  useEffect(() => {
    axios
      .get("http://localhost:8002/categoryApi/v1/categories")
      .then((res) => setCategories(res.data))
      .catch((err) => console.error(err));
  }, []);

  const nextStep = async () => {
    const valid = await trigger(["productname", "price", "image"]);
    if (valid) setStep(2);
  };

  const prevStep = () => setStep(1);

  const onSubmit = async (data) => {
    const formData = new FormData();

    const product = {
      productname: data.productname,
      description: data.description,
      price: Number(data.price) || 0,
      discountPrice: Number(data.discountPrice) || 0,
      brand: data.brand,
      sku: data.sku,
      weight: Number(data.weight) || 0,
      dimensions: data.dimensions,
      color: data.color,
      size: data.size,

      category: data.categoryId
        ? { categoryId: Number(data.categoryId) }
        : null,

      inventory: {
        stackQuantity: Number(data.stackQuantity) || 0,
        reservedQuantity: Number(data.reservedQuantity) || 0,
        wareHouseLocation: data.wareHouseLocation,
        reOrderLevel: Number(data.reOrderLevel) || 0,
        costPrice: Number(data.costPrice) || 0,
        status: true,
      },
    };

    formData.append("product", JSON.stringify(product));

    if (data.image && data.image[0]) {
      formData.append("imageFile", data.image[0]);
    }

    try {
      const res = await axios.post(
        "http://localhost:8002/productApi/v1/product",
        formData,
      );

      console.log("SUCCESS:", res.data);
      alert("Product Created Successfully");
      reset();
    } catch (err) {
      console.error("ERROR:", err.response?.data || err.message);
      alert("Error while saving product");
    }
  };
  return (
    <div className="container mt-5">
      <div className="card shadow-lg p-4">
        <h3 className="text-center mb-4">🛒 Product Registration</h3>

        {/* Step Indicator */}
        <div className="d-flex justify-content-between mb-4">
          <div className={`fw-bold ${step === 1 ? "text-primary" : ""}`}>
            1. Basic Info
          </div>
          <div className={`fw-bold ${step === 2 ? "text-primary" : ""}`}>
            2. Details & Inventory
          </div>
        </div>

        <form onSubmit={handleSubmit(onSubmit)}>
          {/* STEP 1 */}
          {step === 1 && (
            <>
              <div className="row">
                <div className="col-md-6 mb-3">
                  <label>Product Name *</label>
                  <input
                    className="form-control"
                    {...register("productname", { required: true })}
                  />
                </div>

                <div className="col-md-6 mb-3">
                  <label>Price *</label>
                  <input
                    type="number"
                    className="form-control"
                    {...register("price", { required: true })}
                  />
                </div>

                <div className="col-md-12 mb-3">
                  <label>Description</label>
                  <textarea
                    className="form-control"
                    {...register("description")}
                  />
                </div>

                <div className="col-md-6 mb-3">
                  <label>Discount Price</label>
                  <input
                    type="number"
                    className="form-control"
                    {...register("discountPrice")}
                  />
                </div>

                <div className="col-md-6 mb-3">
                  <label>Brand</label>
                  <input className="form-control" {...register("brand")} />
                </div>

                <div className="col-md-6 mb-3">
                  <label>SKU</label>
                  <input className="form-control" {...register("sku")} />
                </div>

                <div className="col-md-6 mb-3">
                  <label>Product Image *</label>
                  <input
                    type="file"
                    className="form-control"
                    {...register("image", { required: true })}
                    onChange={(e) =>
                      setPreview(URL.createObjectURL(e.target.files[0]))
                    }
                  />
                </div>

                {preview && (
                  <div className="col-md-12 text-center mb-3">
                    <img
                      src={preview}
                      alt="preview"
                      className="img-thumbnail"
                      style={{ maxHeight: "150px" }}
                    />
                  </div>
                )}
              </div>

              <button
                type="button"
                className="btn btn-primary w-100"
                onClick={nextStep}
              >
                Next →
              </button>
            </>
          )}

          {/* STEP 2 */}
          {step === 2 && (
            <>
              <div className="row">
                <div className="col-md-6 mb-3">
                  <label>Category</label>
                  <select className="form-control" {...register("categoryId")}>
                    <option value="">Select Category</option>
                    {categories.map((c) => (
                      <option key={c.categoryId} value={c.categoryId}>
                        {c.categoryName}
                      </option>
                    ))}
                  </select>
                </div>

                <div className="col-md-6 mb-3">
                  <label>Weight</label>
                  <input
                    type="number"
                    className="form-control"
                    {...register("weight")}
                  />
                </div>

                <div className="col-md-6 mb-3">
                  <label>Dimensions</label>
                  <input className="form-control" {...register("dimensions")} />
                </div>

                <div className="col-md-6 mb-3">
                  <label>Color</label>
                  <input className="form-control" {...register("color")} />
                </div>

                <div className="col-md-6 mb-3">
                  <label>Size</label>
                  <input className="form-control" {...register("size")} />
                </div>

                <div className="col-md-6 mb-3">
                  <label>Stock Quantity</label>
                  <input
                    type="number"
                    className="form-control"
                    {...register("stackQuantity")}
                  />
                </div>

                <div className="col-md-6 mb-3">
                  <label>Reserved Quantity</label>
                  <input
                    type="number"
                    className="form-control"
                    {...register("reservedQuantity")}
                  />
                </div>

                <div className="col-md-6 mb-3">
                  <label>Warehouse Location</label>
                  <input
                    className="form-control"
                    {...register("wareHouseLocation")}
                  />
                </div>

                <div className="col-md-6 mb-3">
                  <label>Reorder Level</label>
                  <input
                    type="number"
                    className="form-control"
                    {...register("reOrderLevel")}
                  />
                </div>

                <div className="col-md-6 mb-3">
                  <label>Cost Price</label>
                  <input
                    type="number"
                    className="form-control"
                    {...register("costPrice")}
                  />
                </div>
              </div>

              <div className="d-flex gap-3">
                <button
                  type="button"
                  className="btn btn-secondary w-50"
                  onClick={prevStep}
                >
                  ← Back
                </button>

                <button type="submit" className="btn btn-success w-50">
                  Save Product
                </button>
              </div>
            </>
          )}
        </form>
      </div>
    </div>
  );
};

export default ProductForm;
