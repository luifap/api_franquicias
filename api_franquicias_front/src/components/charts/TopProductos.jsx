export default function TopProductos({ data }) {
  if (!data?.length) {
    return <p style={empty}>No hay datos aún</p>;
  }

  return (
    <div style={container}>
      {data.map((p, i) => (
        <div key={i} style={card}>
          <p style={name}>
            {p.nombre || p.producto || "Sin nombre"}
          </p>

          <p style={info}>
            Stock: {p.total || p.stock || 0}
          </p>

          {p.sucursal && (
            <p style={sucursal}>
              📍 {p.sucursal}
            </p>
          )}
        </div>
      ))}
    </div>
  );
}

/* ===== STYLES ===== */

const container = {
  display: "flex",
  flexDirection: "column",
  gap: 10,
};

const card = {
  padding: 12,
  borderRadius: 10,
  background: "#f9fafb",
  border: "1px solid #eee",
};

const name = {
  margin: 0,
  fontWeight: "600",
};

const info = {
  margin: 0,
  fontSize: 13,
  color: "#555",
};

const sucursal = {
  margin: 0,
  fontSize: 12,
  color: "#888",
};

const empty = {
  fontStyle: "italic",
  color: "#999",
};