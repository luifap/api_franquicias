import axiosClient from "./axiosClient";

export const FranquiciasAPI = {
  // franquicias
  getAll: () => axiosClient.get("/franquicias"),
  getById: (id) => axiosClient.get(`/franquicias/${id}`),
  create: (nombre) => axiosClient.post("/franquicias", { nombre }),
  update: (id, nombre) =>
    axiosClient.put(`/franquicias/${id}`, { nombre }),

  // sucursales
  addSucursal: (fid, nombre) =>
    axiosClient.post(`/franquicias/${fid}/sucursales`, { nombre }),

  updateSucursal: (fid, sid, nombre) =>
    axiosClient.put(`/franquicias/${fid}/sucursales/${sid}`, { nombre }),

  // productos
  addProducto: (fid, sid, nombre, stock) =>
    axiosClient.post(
      `/franquicias/${fid}/sucursales/${sid}/productos`,
      { nombre, stock }
    ),

  updateProducto: (fid, sid, pid, nombre) =>
    axiosClient.put(
      `/franquicias/${fid}/sucursales/${sid}/productos/${pid}`,
      { nombre }
    ),

  updateStock: (fid, sid, pid, stock) =>
    axiosClient.put(
      `/franquicias/${fid}/sucursales/${sid}/productos/${pid}/stock`,
      { stock }
    ),

  deleteProducto: (fid, sid, pid) =>
    axiosClient.delete(
      `/franquicias/${fid}/sucursales/${sid}/productos/${pid}`
    ),

  // analytics
  topProductos: (id) =>
    axiosClient.get(`/franquicias/${id}/top-productos`),
};