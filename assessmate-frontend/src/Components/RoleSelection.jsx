import React from "react";
import { Box, Button, Typography, Container } from "@mui/material";
import { useNavigate } from "react-router-dom";

const RoleSelection = () => {
  const navigate = useNavigate();

  const handleRoleSelect = (role) => {
    // Set role in your state/context here (if necessary)
    console.log(`Selected role: ${role}`);
    // Navigate to the dashboard path
    navigate("/dashboard");
  };

  return (
    <Container
      maxWidth="sm"
      sx={{
        display: "flex",
        flexDirection: "column",
        alignItems: "center",
        justifyContent: "center",
        minHeight: "100vh",
        py: 4,
        backgroundImage: 'url("/teach.png")',
        backgroundSize: "cover",
        backgroundPosition: "center",
        backgroundRepeat: "no-repeat",
      }}
    >
      <Box
        sx={{
          width: "100%",
          bgcolor: "rgba(255, 255, 255, 0.9)",
          borderRadius: 4,
          boxShadow: 3,
          p: 6,
          textAlign: "center",
          backdropFilter: "blur(4px)",
        }}
      >
        <Typography
          variant="h3"
          component="h1"
          sx={{
            fontWeight: 700,
            mb: 1,
            color: "primary.main",
            textTransform: "uppercase",
          }}
        >
          HELLO
        </Typography>
        
        <Typography
          variant="h5"
          component="h2"
          sx={{
            fontWeight: 600,
            mb: 6,
            color: "text.secondary",
          }}
        >
          Choose Your Role
        </Typography>

        <Box
          sx={{
            display: "flex",
            flexDirection: { xs: "column", sm: "row" },
            gap: 4,
            justifyContent: "center",
            mt: 4,
          }}
        >
          <Button
            variant="contained"
            size="large"
            sx={{
              py: 3,
              px: 6,
              fontSize: "1.2rem",
              fontWeight: 700,
              minWidth: 200,
              textTransform: "uppercase",
              borderRadius: 2,
              bgcolor: "#4CAF50", // Green color
              "&:hover": {
                bgcolor: "#388E3C",
                transform: "translateY(-2px)",
              },
              transition: "all 0.3s ease",
            }}
            onClick={() => handleRoleSelect("STUDENT")}
          >
            STUDENT
          </Button>

          <Button
            variant="contained"
            size="large"
            sx={{
              py: 3,
              px: 6,
              fontSize: "1.2rem",
              fontWeight: 700,
              minWidth: 200,
              textTransform: "uppercase",
              borderRadius: 2,
              bgcolor: "#2196F3", // Blue color
              "&:hover": {
                bgcolor: "#1976D2",
                transform: "translateY(-2px)",
              },
              transition: "all 0.3s ease",
            }}
            onClick={() => handleRoleSelect("MENTOR")}
          >
            MENTOR
          </Button>
        </Box>
      </Box>
    </Container>
  );
};

export default RoleSelection;
