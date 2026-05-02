import { useState } from "react";
import ProductoList from "../productos/ProductoList";
import ProductoForm from "../productos/ProductoForm";
import SucursalEdit from "./SucursalEdit";

export default function SucursalList({ franquicia, onChange }) {
  const [editSucursal, setEditSucursal] = useState(null);

  return (
    <div style={container}>
      {franquicia.sucursales?.map((s) => (
        <div key={s.id} style={card}>
          
          {/* HEADER */}
          <div style={header}>
            <h3 style={title}>{s.nombre}</h3>

            <button
              style={editBtn}
              onClick={() => setEditSucursal(s)}
            >
              Editar
            </button>
          </div>

          {/* MODAL EDIT */}
          {editSucursal?.id === s.id && (
            <SucursalEdit
              fid={franquicia.id}
              sucursal={s}
              onUpdated={onChange}
              onClose={() => setEditSucursal(null)}
            />
          )}

          {/* FORM PRODUCTO */}
          <div style={section}>
            <ProductoForm
              fid={franquicia.id}
              sid={s.id}
              onChange={onChange}
            />
          </div>

          {/* LISTA PRODUCTOS */}
          <div style={section}>
            <ProductoList
              fid={franquicia.id}
              sid={s.id}
              productos={s.productos}
              onChange={onChange}
            />
          </div>
        </div>
      ))}
    </div>
  );
}

/* STYLES */

const container = {
  display: "flex",
  flexDirection: "column",
  gap: "12px",
};

const card = {
  background: "#fff",
  borderRadius: 12,
  padding: 16,
  boxShadow: "0 4px 12px rgba(0,0,0,0.08)",
};

const header = {
  display: "flex",
  justifyContent: "space-between",
  alignItems: "center",
};

const title = {
  margin: 0,
};

const editBtn = {
  background: "#2563eb",
  color: "#fff",
  border: "none",
  padding: "6px 10px",
  borderRadius: 6,
  cursor: "pointer",
};

const section = {
  marginTop: 10,
};