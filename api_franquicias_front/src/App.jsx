import { BrowserRouter, Routes, Route } from "react-router-dom";
import Home from "./pages/Home";
import FranquiciaDetail from "./pages/FranquiciaDetail";

export default function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/franquicia/:id" element={<FranquiciaDetail />} />
      </Routes>
    </BrowserRouter>
  );
}