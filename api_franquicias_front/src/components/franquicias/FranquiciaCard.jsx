import { useState } from "react";
import { FranquiciasAPI } from "../../api/franquicias.js";
import SucursalList from "../sucursales/SucursalList";
import SucursalForm from "../sucursales/SucursalForm";
import FranquiciaEdit from "./FranquiciaEdit";
import { useNavigate } from "react-router-dom";

export default function FranquiciaCard({ franquicia }) {
  const [data, setData] = useState(franquicia);
  const [loading, setLoading] = useState(false);
  const [showEdit, setShowEdit] = useState(false);

  const navigate = useNavigate();

  const refresh = async () => {
    setLoading(true);
    try {
      const res = await FranquiciasAPI.getById(franquicia.id);
      setData(res.data);
    } catch {
      alert("Error cargando franquicia");
    } finally {
      setLoading(false);
    }
  };

  return (
    <div style={styles.card}>
      
      {/* HEADER */}
      <div style={styles.header}>
        <h2 style={styles.title}>{data.nombre}</h2>

        <div style={styles.actions}>
          <button
            style={styles.editBtn}
            onClick={() => setShowEdit(true)}
          >
            Editar
          </button>

          <button
            style={styles.detailBtn}
            onClick={() => navigate(`/franquicia/${data.id}`)}
          >
            Ver detalle →
          </button>
        </div>
      </div>

      {/* MODAL */}
      {showEdit && (
        <FranquiciaEdit
          franquicia={data}
          onUpdated={refresh}
          onClose={() => setShowEdit(false)}
        />
      )}

      {/* LOADING */}
      {loading && <p style={styles.loading}>Actualizando...</p>}

      {/* SUCURSAL FORM */}
      <div style={styles.section}>
        <h4 style={styles.subtitle}>Agregar Sucursal</h4>
        <SucursalForm
          franquiciaId={data.id}
          onCreated={refresh}
        />
      </div>

      {/* LISTADO */}
      <div style={styles.section}>
        <h4 style={styles.subtitle}>Sucursales</h4>
        <SucursalList
          franquicia={data}
          onChange={refresh}
        />
      </div>
    </div>
  );
}

/* ====== STYLES ====== */

const styles = {
  card: {
    background: "#fff",
    borderRadius: 16,
    padding: 20,
    marginBottom: 20,
    boxShadow: "0 4px 12px rgba(0,0,0,0.08)",
  },

  header: {
    display: "flex",
    justifyContent: "space-between",
    alignItems: "center",
    marginBottom: 15,
  },

  title: {
    margin: 0,
    fontSize: 20,
    fontWeight: "600",
  },

  actions: {
    display: "flex",
    gap: 10,
  },

  detailBtn: {
    background: "#111",
    color: "#fff",
    border: "none",
    padding: "8px 14px",
    borderRadius: 8,
    cursor: "pointer",
  },

  editBtn: {
    background: "#2563eb",
    color: "#fff",
    border: "none",
    padding: "8px 14px",
    borderRadius: 8,
    cursor: "pointer",
  },

  section: {
    marginTop: 15,
    padding: 15,
    borderRadius: 12,
    background: "#f9f9f9",
  },

  subtitle: {
    marginBottom: 10,
    fontSize: 14,
    color: "#555",
  },

  loading: {
    fontSize: 12,
    color: "#888",
  },
};