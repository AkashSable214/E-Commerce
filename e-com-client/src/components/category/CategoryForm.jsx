import React from "react";
import { useForm } from "react-hook-form";
import axios from "axios";

const CategoryForm = () => {
  const { register, handleSubmit, reset } = useForm();

  const onSubmit = async (data) => {
    const formData = new FormData();

    formData.append("categoryName", data.categoryName);
    formData.append("description", data.description);
    formData.append("parentCategoryId", data.parentCategoryId || "");
    formData.append("displayOrder", data.displayOrder || 0);
    formData.append("slug", data.slug);
    formData.append("isActive", data.isActive ?? true);

    //  FILE upload (important)
    formData.append("image", data.image[0]);

    try {
      // this is for testing purpose
      // for (let pair of formData.entries()) {
      //   console.log(pair[0], pair[1]);
      // }
      await axios.post(
        "http://localhost:8002/categoryApi/v1/category",
        formData,
        {
          headers: {
            "Content-Type": "multipart/form-data",
          },
        },
      );

      alert("Category Created with Image ✅");
      reset();
    } catch (err) {
      console.error(err);
      alert("Error uploading category ");
    }
  };

  return (
    <div className="container mt-4">
      <div className="card p-4 shadow">
        <h3 className="text-center mb-3">Create Category</h3>

        <form onSubmit={handleSubmit(onSubmit)}>
          {/* Name */}
          <input
            className="form-control mb-2"
            placeholder="Category Name"
            {...register("categoryName", { required: true })}
          />

          {/* Description */}
          <textarea
            className="form-control mb-2"
            placeholder="Description"
            {...register("description")}
          />

          {/* Parent */}
          <input
            type="number"
            className="form-control mb-2"
            placeholder="Parent Category ID"
            {...register("parentCategoryId")}
          />

          {/* Image Upload  */}
          <input
            type="file"
            className="form-control mb-2"
            {...register("image", { required: true })}
          />

          {/* Display Order */}
          <input
            type="number"
            className="form-control mb-2"
            placeholder="Display Order"
            {...register("displayOrder")}
          />

          {/* Slug */}
          <input
            className="form-control mb-2"
            placeholder="Slug (electronics, fashion...)"
            {...register("slug")}
          />

          {/* Active */}
          <div className="form-check mb-3">
            <input
              type="checkbox"
              className="form-check-input"
              {...register("isActive")}
              defaultChecked
            />
            <label className="form-check-label">Active</label>
          </div>

          <button className="btn btn-primary w-100">Upload Category</button>
        </form>
      </div>
    </div>
  );
};

export default CategoryForm;
