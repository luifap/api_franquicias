import { useState } from "react";
import { FranquiciasAPI } from "../../api/franquicias.js";
import ProductoEdit from "./ProductoEdit";

export default function ProductoList({
  fid,
  sid,
  productos,
  onChange,
}) {
  const [editProducto, setEditProducto] = useState(null);

  const remove = async (pid) => {
    if (!confirm("¿Eliminar producto?")) return;

    await FranquiciasAPI.deleteProducto(fid, sid, pid);
    onChange();
  };

  const updateStock = async (pid, stock) => {
    if (stock < 0) return;

    await FranquiciasAPI.updateStock(fid, sid, pid, stock);
    onChange();
  };

  if (!productos?.length) {
    return <p style={empty}>Sin productos</p>;
  }

  return (
    <div style={container}>
      {productos.map((p) => (
        <div key={p.id} style={card}>
          
          {/* INFO */}
          <div>
            <p style={name}>{p.nombre}</p>
            <p style={stock}>Stock: {p.stock}</p>
          </div>

          {/* ACTIONS */}
          <div style={actions}>
            <button
              style={btnEdit}
              onClick={() => setEditProducto(p)}
            >
              Editar
            </button>

            <button
              style={btnMinus}
              onClick={() => updateStock(p.id, p.stock - 1)}
            >
              -
            </button>

            <button
              style={btnPlus}
              onClick={() => updateStock(p.id, p.stock + 1)}
            >
              +
            </button>

            <button
              style={btnDelete}
              onClick={() => remove(p.id)}
            >
              Eliminar
            </button>
          </div>

          {/* MODAL */}
          {editProducto?.id === p.id && (
            <ProductoEdit
              fid={fid}
              sid={sid}
              producto={p}
              onUpdated={onChange}
              onClose={() => setEditProducto(null)}
            />
          )}
        </div>
      ))}
    </div>
  );
}

/* STYLES */

const container = {
  display: "flex",
  flexDirection: "column",
  gap: 8,
};

const card = {
  display: "flex",
  justifyContent: "space-between",
  alignItems: "center",
  padding: 10,
  background: "#f9fafb",
  borderRadius: 10,
};

const name = { margin: 0, fontWeight: "600" };
const stock = { margin: 0, fontSize: 13 };

const actions = {
  display: "flex",
  gap: 5,
};

const btnEdit = {
  background: "#3b82f6",
  color: "#fff",
  border: "none",
  borderRadius: 6,
  padding: "4px 8px",
};

const btnPlus = {
  background: "#22c55e",
  color: "#fff",
  border: "none",
  borderRadius: 6,
};

const btnMinus = {
  background: "#f59e0b",
  color: "#fff",
  border: "none",
  borderRadius: 6,
};

const btnDelete = {
  background: "#ef4444",
  color: "#fff",
  border: "none",
  borderRadius: 6,
};

const empty = {
  fontStyle: "italic",
  color: "#888",
};