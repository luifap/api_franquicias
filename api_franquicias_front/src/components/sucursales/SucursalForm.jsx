import { useState } from "react";
import { FranquiciasAPI } from "../../api/franquicias.js";

export default function SucursalForm({ franquiciaId, onCreated }) {
  const [nombre, setNombre] = useState("");

  const handle = async () => {
    if (!nombre.trim()) return;

    await FranquiciasAPI.addSucursal(franquiciaId, nombre);
    setNombre("");
    onCreated();
  };

  return (
    <div>
      <input
        placeholder="Nueva sucursal"
        value={nombre}
        onChange={(e) => setNombre(e.target.value)}
      />
      <button onClick={handle}>Agregar sucursal</button>
    </div>
  );
}