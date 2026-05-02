import { useEffect, useState } from "react";
import { FranquiciasAPI } from "../api/franquicias.js";
import FranquiciaCard from "../components/franquicias/FranquiciaCard";
import FranquiciaForm from "../components/franquicias/FranquiciaForm";

export default function Home() {
  const [franquicias, setFranquicias] = useState([]);
  const [loading, setLoading] = useState(false);

  useEffect(() => {
    load();
  }, []);

  const load = async () => {
    setLoading(true);
    try {
      const res = await FranquiciasAPI.getAll();
      setFranquicias(res.data.content);
    } catch (err) {
      alert("Error cargando franquicias");
    } finally {
      setLoading(false);
    }
  };

  const handleCreate = async (nombre) => {
    try {
      await FranquiciasAPI.create(nombre);
      load();
    } catch (err) {
      alert("Error creando franquicia");
    }
  };

  return (
    <div style={styles.container}>
      
      {/* HEADER */}
      <div style={styles.header}>
        <h1 style={styles.title}>🏢 Franquicias Dashboard</h1>
        <p style={styles.subtitle}>
          Gestiona franquicias, sucursales y productos
        </p>
      </div>

      {/* FORM */}
      <div style={styles.formBox}>
        <FranquiciaForm onCreate={handleCreate} />
      </div>

      {/* LOADING */}
      {loading && <p style={styles.loading}>Cargando...</p>}

      {/* EMPTY */}
      {!loading && franquicias.length === 0 && (
        <p style={styles.empty}>No hay franquicias aún</p>
      )}

      {/* GRID */}
      <div style={styles.grid}>
        {franquicias.map((f) => (
          <FranquiciaCard key={f.id} franquicia={f} />
        ))}
      </div>
    </div>
  );
}

/* ===== STYLES ===== */

const styles = {
  container: {
    padding: "30px",
    background: "#f5f7fb",
    minHeight: "100vh",
  },

  header: {
    marginBottom: 20,
  },

  title: {
    margin: 0,
    fontSize: "30px",
    fontWeight: "700",
  },

  subtitle: {
    margin: "5px 0 0",
    color: "#666",
    fontSize: "14px",
  },

  formBox: {
    background: "#fff",
    padding: 20,
    borderRadius: 14,
    marginBottom: 25,
    boxShadow: "0 4px 12px rgba(0,0,0,0.06)",
  },

  grid: {
    display: "grid",
    gridTemplateColumns: "repeat(auto-fill, minmax(350px, 1fr))",
    gap: 20,
  },

  loading: {
    color: "#666",
  },

  empty: {
    color: "#888",
    fontStyle: "italic",
  },
};