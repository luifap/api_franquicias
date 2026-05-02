import { useEffect, useState } from "react";
import { useParams, useNavigate } from "react-router-dom";
import { FranquiciasAPI } from "../api/franquicias.js";

import SucursalForm from "../components/sucursales/SucursalForm";
import SucursalList from "../components/sucursales/SucursalList";
import TopProductos from "../components/charts/TopProductos";
import FranquiciaEdit from "../components/franquicias/FranquiciaEdit";

export default function FranquiciaDetail() {
  const { id } = useParams();
  const navigate = useNavigate();

  const [franquicia, setFranquicia] = useState(null);
  const [top, setTop] = useState([]);
  const [showEdit, setShowEdit] = useState(false);

  const load = async () => {
  const res = await FranquiciasAPI.getById(id);
  setFranquicia(res.data);

  const topRes = await FranquiciasAPI.topProductos(id);
  setTop(topRes.data);
};

  const loadTop = async () => {
    const res = await FranquiciasAPI.topProductos(id);
    setTop(res.data);
  };

  useEffect(() => {
    load();
    loadTop();
  }, [id]);

  if (!franquicia) return <p style={styles.loading}>Cargando...</p>;

  return (
    <div style={styles.container}>
      
      {/* HEADER */}
      <div style={styles.header}>
        <button style={styles.backBtn} onClick={() => navigate(-1)}>
          ← Volver
        </button>

        <h1 style={styles.title}>{franquicia.nombre}</h1>

        <button
          style={styles.editBtn}
          onClick={() => setShowEdit(true)}
        >
          Editar
        </button>
      </div>

      {/* MODAL EDIT */}
      {showEdit && (
        <FranquiciaEdit
          franquicia={franquicia}
          onUpdated={load}
          onClose={() => setShowEdit(false)}
        />
      )}

      {/* SUCURSALES */}
      <div style={styles.card}>
        <h2 style={styles.subtitle}>Sucursales</h2>

        <SucursalForm franquiciaId={id} onCreated={load} />

        <SucursalList franquicia={franquicia} onChange={load} />
      </div>

      {/* TOP PRODUCTOS */}
      <div style={styles.card}>
        <h2 style={styles.subtitle}>Top Productos</h2>
        <TopProductos data={top} />
      </div>
    </div>
  );
}

/* ====== STYLES ====== */

const styles = {
  container: {
    padding: 20,
    maxWidth: 900,
    margin: "0 auto",
  },

  header: {
    display: "flex",
    alignItems: "center",
    justifyContent: "space-between",
    marginBottom: 20,
  },

  title: {
    margin: 0,
    fontSize: 28,
    fontWeight: "700",
  },

  backBtn: {
    background: "#eee",
    border: "none",
    padding: "8px 12px",
    borderRadius: 8,
    cursor: "pointer",
  },

  editBtn: {
    background: "#111",
    color: "#fff",
    border: "none",
    padding: "8px 14px",
    borderRadius: 8,
    cursor: "pointer",
  },

  card: {
    background: "#fff",
    borderRadius: 14,
    padding: 20,
    marginBottom: 20,
    boxShadow: "0 4px 12px rgba(0,0,0,0.08)",
  },

  subtitle: {
    marginBottom: 10,
  },

  loading: {
    padding: 20,
  },
};