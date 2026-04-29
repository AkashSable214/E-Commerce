import { Outlet } from "react-router-dom";
import AppSidebar from "@/components/dashboard/AppSidebar";
import profile from "@/assets/profile.jpg";

const DashboardLayout = ({ title = "Dashboard" }) => {
  return (
    <div>
      {/* Sidebar */}
      <div
        style={{
          width: "250px",
          position: "fixed",
          top: 0,
          left: 0,
          height: "100vh",
          zIndex: 1000,
        }}
      >
        <AppSidebar />
      </div>

      {/* Main Area */}
      <div
        style={{
          marginLeft: "250px",
        }}
      >
        {/* Navbar */}
        <nav
          className="navbar bg-white border-bottom px-3 d-flex align-items-center"
          style={{
            position: "fixed",
            top: 0,
            left: "250px",
            right: 0,
            height: "60px",
            zIndex: 999,
          }}
        >
          <span className="fw-semibold">{title}</span>

          <div className="ms-auto">
            <img
              src={profile}
              alt="Profile"
              className="rounded-circle"
              style={{
                width: "40px",
                height: "40px",
                objectFit: "cover",
              }}
            />
          </div>
        </nav>

        {/* Page Content */}
        <div
          className="container-fluid p-3"
          style={{
            marginTop: "60px", // navbar height
          }}
        >
          <Outlet />
        </div>
      </div>
    </div>
  );
};

export default DashboardLayout;
