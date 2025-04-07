import {
  CssBaseline,
  ThemeProvider as MuiThemeProvider,
  createTheme,
} from "@mui/material";
import React from "react";

const appTheme = createTheme({
  palette: {
    primary: {
      main: "#36a9b4", // Teal color from buttons
      light: "#8fe1d7", // Light teal from background elements (with 80% opacity in original)
    },
    secondary: {
      main: "#3f3d56", // Dark blue/gray from text
    },
    background: {
      default: "#ffffff", // White background
    },
    text: {
      primary: "#3f3d56", // Dark text color
      secondary: "#ffffff", // White text on buttons
    },
  },
  typography: {
    fontFamily: "'Poppins', Helvetica, Arial, sans-serif",
    h1: {
      fontSize: "57px",
      fontWeight: 700, // bold
      lineHeight: "normal",
      color: "#3f3d56",
    },
    button: {
      fontSize: "18px", // text-lg
      fontWeight: 600, // semibold
      lineHeight: "28.3px",
      textTransform: "none",
    },
  },
  components: {
    MuiButton: {
      styleOverrides: {
        root: {
          textTransform: "none",
          borderRadius: "8px", // rounded-lg
          padding: "15px 0",
          minWidth: "165px",
          height: "60px",
          fontWeight: 600,
        },
        contained: {
          backgroundColor: "#36a9b4",
          color: "#ffffff",
          "&:hover": {
            backgroundColor: "#2c8a93", // Slightly darker on hover
          },
        },
      },
    },
    MuiCssBaseline: {
      styleOverrides: {
        body: {
          backgroundColor: "#ffffff",
        },
      },
    },
  },
  shape: {
    borderRadius: 8, // Default border radius
  },
});

export const ThemeProvider = ({ children }) => {
  return (
    <MuiThemeProvider theme={appTheme}>
      <CssBaseline />
      {children}
    </MuiThemeProvider>
  );
};
