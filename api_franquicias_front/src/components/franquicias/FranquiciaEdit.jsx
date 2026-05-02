import { useState } from "react";
import { FranquiciasAPI } from "../../api/franquicias.js";

export default function FranquiciaEdit({ franquicia, onUpdated, onClose }) {
  const [nombre, setNombre] = useState(franquicia.nombre);
  const [loading, setLoading] = useState(false);

  const handleUpdate = async () => {
    if (!nombre.trim()) return;

    setLoading(true);
    try {
      await FranquiciasAPI.update(franquicia.id, nombre);
      onUpdated();
      onClose();
    } catch (err) {
      alert("Error actualizando franquicia");
    } finally {
      setLoading(false);
    }
  };

  return (
    <div style={modalStyle}>
      <h3>Editar Franquicia</h3>

      <input
        value={nombre}
        onChange={(e) => setNombre(e.target.value)}
        placeholder="Nombre"
      />

      <div style={{ marginTop: 10 }}>
        <button onClick={handleUpdate} disabled={loading}>
          Guardar
        </button>

        <button onClick={onClose} style={{ marginLeft: 10 }}>
          Cancelar
        </button>
      </div>
    </div>
  );
}

const modalStyle = {
  position: "fixed",
  top: "30%",
  left: "40%",
  background: "#fff",
  padding: 20,
  border: "1px solid #ccc",
  borderRadius: 10,
  zIndex: 1000,
};