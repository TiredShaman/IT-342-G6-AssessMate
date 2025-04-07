import React from "react";
import { Box, Button, Typography } from "@mui/material";
import { ThemeProvider } from "../assets/theme";
import { useNavigate } from "react-router-dom"; // Import useNavigate from react-router-dom

const Home = () => {
  const navigate = useNavigate(); // Initialize the navigate function

  const handleGetStartedClick = () => {
    navigate("/select-role"); // Navigate to the RoleSelection page
  };

  return (
    <ThemeProvider>
      <Box
        sx={{
          bgcolor: "background.default",
          position: "relative",
          overflow: "hidden",
          width: "100%",
          height: "100vh", // Full screen height
          display: "flex",
          flexDirection: "column", // Arrange content vertically
          justifyContent: "center", // Center content vertically
          alignItems: "center", // Center content horizontally
          textAlign: "center",
        }}
      >
        {/* Welcome Message */}
        <Typography
          variant="h2"
          sx={{
            fontSize: "48px",
            fontWeight: "bold",
            color: "primary.main",
            marginBottom: "30px", // Space between title and description
          }}
        >
          Welcome to Assessmate!
        </Typography>

        <Typography
          variant="h5"
          sx={{
            fontSize: "20px",
            color: "text.primary",
            maxWidth: "600px",
            marginBottom: "40px", // Space between description and button
          }}
        >
          Assessmate is a powerful review and assessment platform designed to help individuals track their learning progress, take quizzes, and receive valuable feedback. Whether you're preparing for exams, certifications, or self-improvement, Assessmate is here to guide you through the process.
        </Typography>

        {/* Get Started Button */}
        <Box
          sx={{
            position: "absolute",
            bottom: "50px", // Position it towards the bottom
            left: "50%",
            transform: "translateX(-50%)", // Center horizontally
          }}
        >
          <Button
            variant="contained"
            sx={{
              minWidth: "200px",
              height: "60px",
              backgroundColor: "primary.main",
              "&:hover": {
                backgroundColor: "primary.dark",
              },
            }}
            onClick={handleGetStartedClick} // Navigate to select-role
          >
            Get Started
          </Button>
        </Box>
      </Box>
    </ThemeProvider>
  );
};

export default Home;
