import React from "react";
import { Box, Button, TextField, Typography, IconButton } from "@mui/material";
import ArrowBackIcon from "@mui/icons-material/ArrowBack";
import { useNavigate } from "react-router-dom"; // Import useNavigate from react-router-dom

const Login = ({ open, onClose, onOpenSignUp }) => {
  const navigate = useNavigate(); // Initialize useNavigate

  const handleLoginClick = () => {
    // You can add your login logic here, and after successful login:
    navigate("/home"); // Navigate to the Home page
  };

  return (
    <Box
      sx={{
        display: open ? "flex" : "none",
        justifyContent: "center",
        alignItems: "center",
        position: "fixed",
        top: 0,
        left: 0,
        right: 0,
        bottom: 0,
        bgcolor: "rgba(0, 0, 0, 0.5)",
        zIndex: 9999,
      }}
    >
      <Box
        sx={{
          bgcolor: "background.paper",
          padding: 4,
          borderRadius: 2,
          width: "100%",
          maxWidth: "400px",
          boxShadow: 24,
          position: "relative",
        }}
      >
        <IconButton
          onClick={onClose}
          sx={{
            position: "absolute",
            left: 16,
            top: 16,
            color: "text.primary",
            backgroundColor: "rgba(0, 0, 0, 0.08)",
            '&:hover': {
              backgroundColor: "rgba(0, 0, 0, 0.12)",
            },
            borderRadius: 1,
            padding: 1,
          }}
        >
          <ArrowBackIcon fontSize="medium" />
        </IconButton>

        <Typography
          variant="h5"
          sx={{
            fontWeight: 700,
            color: "text.primary",
            mb: 4,
            textAlign: "center",
          }}
        >
          Login to AssessMate
        </Typography>
        
        <Box sx={{ display: "flex", flexDirection: "column", gap: 3 }}>
          <TextField
            label="Email"
            variant="outlined"
            fullWidth
            size="medium"
          />
          
          <TextField
            label="Password"
            type="password"
            variant="outlined"
            fullWidth
            size="medium"
          />
          
          <Button
            variant="contained"
            fullWidth
            sx={{
              py: 1.5,
              borderRadius: 1,
              textTransform: "none",
              fontSize: "1rem",
              fontWeight: 600,
              mt: 2,
            }}
            onClick={handleLoginClick} // Trigger login and navigate to Home
          >
            Log in
          </Button>
          
          <Box sx={{ textAlign: "center", mt: 2 }}>
            <Typography variant="body2" sx={{ display: "inline", mr: 1 }}>
              Don't have an account?
            </Typography>
            <Button
              variant="text"
              sx={{
                textTransform: "none",
                padding: 0,
                fontSize: "0.875rem",
                fontWeight: 600,
                minWidth: "auto",
              }}
              onClick={() => {
                onClose();
                onOpenSignUp();
              }}
            >
              Sign Up
            </Button>
          </Box>
        </Box>
      </Box>
    </Box>
  );
};

export default Login;
``
