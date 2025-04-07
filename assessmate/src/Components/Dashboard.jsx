"use client";
import * as React from "react";
import "../assets/css/Dashboard.css";


function Dashboard() {
  return (
    <>
      <link
        rel="stylesheet"
        href="https://cdn.jsdelivr.net/npm/@tabler/icons-webfont@latest/dist/tabler-icons.min.css"
      />
      <div className="dashboard-container">
        <div className="main-content">
          <header className="header">
            <h1 className="welcome-text">Hi, Ronald A. Martin</h1>
            <div className="notification-badge">
              <i className="ti ti-bell" />
            </div>
          </header>
          <p className="search-prompt">
            What Would you like to learn Today? Search Below.
          </p>
          <div className="search-container">
            <input
              type="text"
              placeholder="Search for.."
              className="search-input"
            />
            <div className="filter-button">
              <i className="ti ti-adjustments" />
            </div>
          </div>
          <section className="special-offer">
            <div className="offer-content">
              <h2 className="offer-title">Today's Special</h2>
              <p className="offer-cta">Enroll Now!</p>
              <div className="offer-dots">
                <div className="dot" />
                <div className="dot" />
                <div className="dot active" />
                <div className="dot" />
                <div className="dot" />
              </div>
            </div>
            <div className="offer-decoration" />
          </section>
          <section className="categories-section">
            <div className="section-header">
              <h2 className="section-title">Categories</h2>
              <button className="see-all">SEE ALL</button>
            </div>
            <div className="categories-list">
              <span className="category">3D Design</span>
              <span className="category active">Arts &amp; Humanities</span>
              <span className="category">Graphic Design</span>
            </div>
          </section>
          <section className="popular-courses">
            <div className="section-header">
              <h2 className="section-title">Polupar Courses</h2>
              <button className="see-all">SEE ALL</button>
            </div>
            <div className="filter-tabs">
              <button className="filter-tab">All</button>
              <button className="filter-tab active">Graphic Design</button>
              <button className="filter-tab">3D Design</button>
              <button className="filter-tab">Arts</button>
            </div>
          </section>
          <section className="course-cards">
            <div className="course-card">
              <div className="course-image" />
              <div className="course-details">
                <span className="course-category">Programming</span>
                <h3 className="course-title">Programming and Design</h3>
                <div className="course-stats">
                  <div className="rating">
                    <i className="ti ti-star" />
                    <span>4.2</span>
                  </div>
                  <span className="separator">|</span>
                  <span className="students">7830 Std</span>
                </div>
              </div>
            </div>
            <div className="course-card">
              <div className="course-image" />
              <div className="course-details">
                <span className="course-category">Graphic Design</span>
                <h3 className="course-title">Advertise</h3>
              </div>
            </div>
          </section>
          <section className="top-mentors">
            <div className="section-header">
              <h2 className="section-title">Top Mentor</h2>
              <button className="see-all">SEE ALL</button>
            </div>
            <div className="mentors-list">
              <div className="mentor">
                <div className="mentor-avatar" />
                <span className="mentor-name">Sonja</span>
              </div>
              <div className="mentor">
                <div className="mentor-avatar" />
                <span className="mentor-name">Jensen</span>
              </div>
              <div className="mentor">
                <div className="mentor-avatar" />
                <span className="mentor-name">Victoria</span>
              </div>
              <div className="mentor">
                <div className="mentor-avatar" />
                <span className="mentor-name">Castaldo</span>
              </div>
            </div>
          </section>
        </div>
        <nav className="bottom-nav">
          <div className="nav-items">
            <div className="nav-item active">
              <i className="ti ti-home" />
              <span>HOME</span>
            </div>
            <div className="nav-item">
              <i className="ti ti-book" />
              <span>MY COURSES</span>
            </div>
            <div className="nav-item">
              <i className="ti ti-inbox" />
              <span>INBOX</span>
            </div>
            <div className="nav-item">
              <i className="ti ti-credit-card" />
              <span>TRANSACTION</span>
            </div>
            <div className="nav-item">
              <i className="ti ti-user" />
              <span>PROFILE</span>
            </div>
          </div>
        </nav>
      </div>
    </>
  );
}

export default Dashboard;
