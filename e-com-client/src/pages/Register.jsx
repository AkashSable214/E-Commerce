import React from "react";
import { useForm } from "react-hook-form";
import axios from "axios";

const Register = () => {
  const {
    register,
    handleSubmit,
    reset,
    formState: { errors },
  } = useForm();

  const onSubmit = async (data) => {
    const payload = {
      userName: data.userName,
      email: data.email,
      password: data.password,
      dob: data.dob,
      phoneNo: Number(data.phoneNo),
      gender: data.gender,
      address: [
        {
          landmark: data.landmark,
          street: data.street,
          city: data.city,
          state: data.state,
          zip: data.zip,
          country: data.country,
          addressType: data.addressType,
        },
      ],
    };

    try {
      const response = await axios.post(
        "http://localhost:8001/userApi/v1/saveUser",
        payload,
      );
      console.log("Success:", response.data);
      alert("Registration successful");
      reset();
    } catch (error) {
      console.error("Error:", error);
      alert("Registration failed");
    }
  };

  return (
    <div className="container mt-5">
      <div className="card shadow p-4">
        <h2 className="text-center mb-4">User Registration</h2>

        <form onSubmit={handleSubmit(onSubmit)}>
          <div className="row">
            <div className="col-md-6 mb-3">
              <label className="form-label">Full Name</label>
              <input
                type="text"
                className={`form-control ${errors.userName ? "is-invalid" : ""}`}
                {...register("userName", { required: "Name is required" })}
                placeholder="Enter your full name"
              />
              <div className="invalid-feedback">{errors.userName?.message}</div>
            </div>
            <div className="col-md-6 mb-3">
              <label className="form-label">Email</label>
              <input
                type="email"
                className={`form-control ${errors.email ? "is-invalid" : ""}`}
                {...register("email", { required: "Email is required" })}
              />
              <div className="invalid-feedback">{errors.email?.message}</div>
            </div>

            <div className="col-md-6 mb-3">
              <label className="form-label">Password</label>
              <input
                type="password"
                className={`form-control ${errors.password ? "is-invalid" : ""}`}
                {...register("password", { required: "Password is required" })}
              />
              <div className="invalid-feedback">{errors.password?.message}</div>
            </div>

            <div className="col-md-6 mb-3">
              <label className="form-label">Date of Birth</label>
              <input
                type="date"
                className={`form-control ${errors.dob ? "is-invalid" : ""}`}
                {...register("dob", { required: "DOB is required" })}
              />
              <div className="invalid-feedback">{errors.dob?.message}</div>
            </div>

            <div className="col-md-6 mb-3">
              <label className="form-label">Phone Number</label>
              <input
                type="number"
                className={`form-control ${errors.phoneNo ? "is-invalid" : ""}`}
                {...register("phoneNo", {
                  required: "Phone number is required",
                })}
              />
              <div className="invalid-feedback">{errors.phoneNo?.message}</div>
            </div>

            <div className="col-md-6 mb-3">
              <label className="form-label">Gender</label>
              <select
                className={`form-select ${errors.gender ? "is-invalid" : ""}`}
                {...register("gender", { required: "Gender is required" })}
              >
                <option value="">Select Gender</option>
                <option value="Male">Male</option>
                <option value="Female">Female</option>
                <option value="Other">Other</option>
              </select>
              <div className="invalid-feedback">{errors.gender?.message}</div>
            </div>
          </div>

          <hr />
          <h4 className="mb-3">Address Details</h4>

          <div className="row">
            <div className="col-md-6 mb-3">
              <label className="form-label">Landmark</label>
              <input
                type="text"
                className="form-control"
                {...register("landmark")}
              />
            </div>

            <div className="col-md-6 mb-3">
              <label className="form-label">Street</label>
              <input
                type="text"
                className={`form-control ${errors.street ? "is-invalid" : ""}`}
                {...register("street", { required: "Street is required" })}
              />
              <div className="invalid-feedback">{errors.street?.message}</div>
            </div>

            <div className="col-md-4 mb-3">
              <label className="form-label">City</label>
              <input
                type="text"
                className={`form-control ${errors.city ? "is-invalid" : ""}`}
                {...register("city", { required: "City is required" })}
              />
              <div className="invalid-feedback">{errors.city?.message}</div>
            </div>

            <div className="col-md-4 mb-3">
              <label className="form-label">State</label>
              <input
                type="text"
                className={`form-control ${errors.state ? "is-invalid" : ""}`}
                {...register("state", { required: "State is required" })}
              />
              <div className="invalid-feedback">{errors.state?.message}</div>
            </div>

            <div className="col-md-4 mb-3">
              <label className="form-label">ZIP Code</label>
              <input
                type="text"
                className={`form-control ${errors.zip ? "is-invalid" : ""}`}
                {...register("zip", { required: "ZIP is required" })}
              />
              <div className="invalid-feedback">{errors.zip?.message}</div>
            </div>

            <div className="col-md-6 mb-3">
              <label className="form-label">Country</label>
              <input
                type="text"
                className={`form-control ${errors.country ? "is-invalid" : ""}`}
                {...register("country", { required: "Country is required" })}
              />
              <div className="invalid-feedback">{errors.country?.message}</div>
            </div>

            <div className="col-md-6 mb-3">
              <label className="form-label">Address Type</label>
              <select
                className={`form-select ${errors.addressType ? "is-invalid" : ""}`}
                {...register("addressType", {
                  required: "Address type is required",
                })}
              >
                <option value="">Select Type</option>
                <option value="Home">Home</option>
                <option value="Office">Office</option>
                <option value="Other">Other</option>
              </select>
              <div className="invalid-feedback">
                {errors.addressType?.message}
              </div>
            </div>
          </div>

          <div className="text-center mt-4">
            <button type="submit" className="btn btn-primary px-5">
              Register
            </button>
          </div>
        </form>
      </div>
    </div>
  );
};

export default Register;
