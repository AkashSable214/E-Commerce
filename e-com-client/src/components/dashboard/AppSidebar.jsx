import { LogOut } from "lucide-react";
import { Link, useNavigate } from "react-router-dom";
const AppSidebar = ({ onLogout }) => {
  const navigate = useNavigate();
  return (
    <div
      className="d-flex flex-column vh-100 border-end bg-white"
      style={{ width: "240px" }}
    >
      {/* Brand */}
      <div className="p-3 border-bottom fw-bold">
        <Link to={"/dashboard"}>MY-E-COM</Link>
      </div>

      {/* Menu */}
      <div className="p-2">
        <button
          className="btn btn-light w-100 text-start"
          onClick={() => navigate("products")}
        >
          Products
        </button>
        <button
          className="btn btn-light w-100 text-start"
          onClick={() => navigate("add-product")}
        >
          Add Products
        </button>
      </div>

      {/* Logout */}
      <div className="mt-auto p-3 border-top">
        <button onClick={onLogout} className="btn btn-outline-danger w-100">
          <LogOut size={16} className="me-1" />
          Logout
        </button>
      </div>
    </div>
  );
};

export default AppSidebar;
