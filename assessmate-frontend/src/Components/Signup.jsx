import React from "react";
import { Box, Button, TextField, Typography, IconButton } from "@mui/material";
import ArrowBackIcon from "@mui/icons-material/ArrowBack";

const SignUp = ({ open, onClose, onOpenLogin }) => {
  const handleRegisterClick = () => {
    // Close the Sign Up modal and open the Login modal
    onClose();
    onOpenLogin();
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
          Sign Up to AssessMate
        </Typography>
        
        <Box sx={{ display: "flex", flexDirection: "column", gap: 3 }}>
          <TextField
            label="Full name"
            variant="outlined"
            fullWidth
            size="medium"
          />
          
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
          
          <TextField
            label="Confirm Password"
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
            onClick={handleRegisterClick} // Handle Register Button click
          >
            Register
          </Button>
          
          <Box sx={{ textAlign: "center", mt: 2 }}>
            <Typography variant="body2" sx={{ display: "inline", mr: 1 }}>
              Already have an account?
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
                onOpenLogin();
              }}
            >
              Log In
            </Button>
          </Box>
        </Box>
      </Box>
    </Box>
  );
};

export default SignUp;
