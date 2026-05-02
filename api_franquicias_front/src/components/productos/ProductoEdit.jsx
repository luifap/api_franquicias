import { useState } from "react";
import { FranquiciasAPI } from "../../api/franquicias.js";

export default function ProductoEdit({
  fid,
  sid,
  producto,
  onUpdated,
  onClose,
}) {
  const [nombre, setNombre] = useState(producto.nombre);
  const [loading, setLoading] = useState(false);

  const handleUpdate = async () => {
    if (!nombre.trim()) return;

    setLoading(true);
    try {
      await FranquiciasAPI.updateProducto(
        fid,
        sid,
        producto.id,
        nombre
      );
      onUpdated();
      onClose();
    } catch (err) {
      alert("Error actualizando producto");
    } finally {
      setLoading(false);
    }
  };

  return (
    <div style={modalStyle}>
      <h3>Editar Producto</h3>

      <input
        value={nombre}
        onChange={(e) => setNombre(e.target.value)}
        placeholder="Nombre producto"
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