import products from "@/data/product";
import { useNavigate } from "react-router-dom";
const Dashboard = () => {
  const total = products.length;
  const inStock = products.filter((p) => p.status === "In Stock").length;
  const outStock = total - inStock;
  const navigate = useNavigate();
  return (
    <>
      {/* Summary Cards */}
      <div className="row g-3 mb-3">
        <div className="col-md-4">
          <div className="card shadow-sm">
            <div className="card-body">
              <small>Total Products</small>
              <h4>{total}</h4>
            </div>
          </div>
        </div>

        <div className="col-md-4">
          <div className="card shadow-sm">
            <div className="card-body">
              <small>In Stock</small>
              <h4>{inStock}</h4>
            </div>
          </div>
        </div>

        <div className="col-md-4">
          <div className="card shadow-sm">
            <div className="card-body">
              <small>Out of Stock</small>
              <h4>{outStock}</h4>
            </div>
          </div>
        </div>
      </div>

      {/* Table */}
      <div className="card shadow-sm">
        <div className="card-body">
          <div className="d-flex justify-content-between align-items-center mb-3">
            <h6 className="mb-0">Products</h6>
            <button
              className="btn btn-primary btn-sm"
              onClick={() => navigate("add-product")}
            >
              + Add Product
            </button>
          </div>

          <table className="table table-hover table-sm">
            <thead>
              <tr>
                <th>#</th>
                <th>Name</th>
                <th>Price</th>
                <th>Status</th>
              </tr>
            </thead>

            <tbody>
              {products.map((p) => (
                <tr key={p.id}>
                  <td>{p.id}</td>
                  <td>{p.name}</td>
                  <td>₹{p.price}</td>
                  <td>
                    <span
                      className={`badge ${p.status === "In Stock" ? "bg-success" : "bg-danger"}`}
                    >
                      {p.status}
                    </span>
                  </td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      </div>
    </>
  );
};

export default Dashboard;
