import { Outlet } from "react-router-dom";
import AppSidebar from "@/components/dashboard/AppSidebar";
import profile from "@/assets/profile.jpg";
const DashboardLayout = ({ title = "Dashboard" }) => {
  return (
    <div className="d-flex">
      {/* Sidebar */}
      <AppSidebar />

      {/* Main Area */}
      <div className="flex-grow-1 min-vh-100 bg-light">
        {/* Navbar */}
        <nav className="navbar bg-white border-bottom px-3 d-flex align-items-center">
          <span className="fw-semibold">{title}</span>

          <div className="ms-auto">
            <img
              src={profile}
              alt="Profile"
              className="rounded-circle"
              style={{ width: "40px", height: "40px", objectFit: "cover" }}
            />
          </div>
        </nav>

        {/* for inside dashboard pages  */}
        <div className="container-fluid p-3">
          <Outlet />
        </div>
      </div>
    </div>
  );
};

export default DashboardLayout;
