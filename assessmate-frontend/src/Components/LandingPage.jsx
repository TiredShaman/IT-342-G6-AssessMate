import React, { useState } from "react";
import { Box, Button, Typography } from "@mui/material";
import { ThemeProvider } from "../assets/theme";
import Login from "./Login";
import SignUp from "./Signup";

const logo = "/images/logo.jpg";
const landingIllustration = "/images/comp.png";

const LandingPage = () => {
  const [openLogin, setOpenLogin] = useState(false);
  const [openSignUp, setOpenSignUp] = useState(false);

  const handleOpenLogin = () => setOpenLogin(true);
  const handleCloseLogin = () => setOpenLogin(false);
  const handleOpenSignUp = () => setOpenSignUp(true);
  const handleCloseSignUp = () => setOpenSignUp(false);

  return (
    <ThemeProvider>
      <Box
        sx={{
          bgcolor: "background.default",
          position: "relative",
          overflow: "hidden",
          width: "100%",
          height: "1024px",
          display: "flex",
          justifyContent: "center",
        }}
      >
        {/* Blue Circle Design - Upper Left Corner */}
        <Box
          sx={{
            position: "absolute",
            top: "-110px",
            left: "-184px",
            width: "492px",
            height: "360px",
          }}
        >
          <Box
            sx={{
              position: "absolute",
              width: "328px",
              height: "267px",
              backgroundColor: "rgba(143, 225, 215, 0.5)",
              borderRadius: "50%",
              top: "93px",
              left: 0,
            }}
          />
          <Box
            sx={{
              position: "absolute",
              width: "328px",
              height: "267px",
              backgroundColor: "rgba(143, 225, 215, 0.5)",
              borderRadius: "50%",
              top: 0,
              left: "164px",
            }}
          />
        </Box>

        {/* Main content container */}
        <Box
          sx={{
            position: "relative",
            overflow: "hidden",
            width: "100%",
            maxWidth: "1440px",
            height: "1024px",
          }}
        >
          {/* Logo */}
          <Box
            component="img"
            src={logo}
            alt="Assessmate Logo"
            sx={{
              position: "absolute",
              width: "214px",
              height: "179px",
              top: "157px",
              left: "347px",
              objectFit: "cover",
            }}
          />

          {/* Main content */}
          <Box
            sx={{
              position: "absolute",
              width: "1424px",
              height: "508px",
              top: "258px",
              left: "0",
            }}
          >
            <Typography
              variant="h1"
              sx={{
                position: "absolute",
                width: "914px",
                top: "120px",
                left: 0,
                textAlign: "center",
                fontSize: "57px",
                fontWeight: "bold",
                color: "secondary.main",
                lineHeight: "normal",
              }}
            >
              Welcome to Assessmate!
              <br />
              Your Review <br />
              &amp;
              <br />
              Assessment System
            </Typography>

            <Box
              component="img"
              src={landingIllustration}
              alt="Landing illustration"
              sx={{
                position: "absolute",
                width: "599px",
                height: "508px",
                top: 0,
                left: "825px",
                objectFit: "cover",
              }}
            />
          </Box>

          {/* Buttons */}
          <Button
            variant="contained"
            sx={{
              position: "absolute",
              top: "36px",
              left: "1014px",
              minWidth: "165px",
              height: "60px",
              backgroundColor: "primary.main",
              "&:hover": {
                backgroundColor: "primary.dark",
              },
            }}
            onClick={handleOpenLogin}
          >
            Log In
          </Button>

          <Button
            variant="contained"
            sx={{
              position: "absolute",
              top: "36px",
              left: "1218px",
              minWidth: "165px",
              height: "60px",
              backgroundColor: "primary.main",
              "&:hover": {
                backgroundColor: "primary.dark",
              },
            }}
            onClick={handleOpenSignUp}
          >
            Sign Up
          </Button>
        </Box>

        {/* Login Component */}
        <Login open={openLogin} onClose={handleCloseLogin} onOpenSignUp={handleOpenSignUp} />

        {/* Sign Up Component */}
        <SignUp open={openSignUp} onClose={handleCloseSignUp} onOpenLogin={handleOpenLogin} />
      </Box>
    </ThemeProvider>
  );
};

export default LandingPage;