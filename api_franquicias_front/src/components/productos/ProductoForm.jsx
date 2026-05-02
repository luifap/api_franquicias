import { useState } from "react";
import { FranquiciasAPI } from "../../api/franquicias.js";

export default function ProductoForm({ fid, sid, onChange }) {
  const [nombre, setNombre] = useState("");
  const [stock, setStock] = useState(0);

  const handle = async () => {
    if (!nombre.trim()) return;

    await FranquiciasAPI.addProducto(fid, sid, nombre, Number(stock));
    setNombre("");
    setStock(0);
    onChange();
  };

  return (
    <div>
      <input
        placeholder="Producto"
        value={nombre}
        onChange={(e) => setNombre(e.target.value)}
      />

      <input
        type="number"
        value={stock}
        onChange={(e) => setStock(e.target.value)}
      />

      <button onClick={handle}>Agregar producto</button>
    </div>
  );
}