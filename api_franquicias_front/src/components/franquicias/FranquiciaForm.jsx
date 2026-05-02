import { useState } from "react";

export default function FranquiciaForm({ onCreate }) {
  const [nombre, setNombre] = useState("");
  const [error, setError] = useState("");
  const [loading, setLoading] = useState(false);

  const handleSubmit = async (e) => {
    e.preventDefault();

    if (!nombre.trim()) {
      setError("El nombre es obligatorio");
      return;
    }

    setError("");
    setLoading(true);

    try {
      await onCreate(nombre);
      setNombre("");
    } catch {
      setError("Error creando franquicia");
    } finally {
      setLoading(false);
    }
  };

  return (
    <form onSubmit={handleSubmit} style={styles.form}>
      
      <input
        style={styles.input}
        value={nombre}
        onChange={(e) => setNombre(e.target.value)}
        placeholder="Nombre de la franquicia"
      />

      <button
        type="submit"
        style={styles.button}
        disabled={loading}
      >
        {loading ? "Creando..." : "Crear"}
      </button>

      {error && <p style={styles.error}>{error}</p>}
    </form>
  );
}

/* ===== STYLES ===== */

const styles = {
  form: {
    display: "flex",
    flexDirection: "column",
    gap: 10,
  },

  input: {
    padding: "10px 12px",
    borderRadius: 8,
    border: "1px solid #ddd",
    fontSize: "14px",
  },

  button: {
    background: "#111",
    color: "#fff",
    border: "none",
    padding: "10px",
    borderRadius: 8,
    cursor: "pointer",
    fontWeight: "600",
  },

  error: {
    color: "#ef4444",
    fontSize: "13px",
    marginTop: 5,
  },
};