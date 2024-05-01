// package com.zapateriaspg.app.service.Impl;

// import java.util.List;
// import java.util.Optional;

// import com.zapateriaspg.app.entity.Producto;
// import com.zapateriaspg.app.repository.ProductoRepository;
// import com.zapateriaspg.app.service.ProductoService;

// public class ProductoServiceImpl implements ProductoService {

//     ProductoRepository productoRepository;


//     public ProductoServiceImpl(ProductoRepository productoRepository) {
//         this.productoRepository = productoRepository;
//     }

//     @Override
//     public Producto obtenerProductoPorId(long id) {
//         Optional<Producto> existingProducto = productoRepository.findById(id);
//         if (existingProducto.isPresent()) 
//             return existingProducto.get();
//         else 
//             throw new IllegalStateException("El producto con el id " + id + " no existe");        
//     }


//     @Override  
//     public List<Producto> obtenerTodosLosProductos() {
//             return (List<Producto>) this.productoRepository.findAll();
//     }

//     @Override
//     public Producto insertarProducto(Producto producto) {
//         return this.productoRepository.save(producto);
//     }

//     @Override
//     public Producto actualizarProducto(Producto producto) {
//        // Obtener el producto existente en la base de datos
//         Optional<Producto> productoExistente = this.productoRepository.findById(producto.getIdProducto());
//         if(productoExistente.isPresent()){
//             Producto productoActualizado = productoExistente.get();
//             productoActualizado.setNombreZapato(producto.getNombreZapato());
//             productoActualizado.setColorZapato(producto.getColorZapato());
//             productoActualizado.setPrecioZapato(producto.getPrecioZapato());
//             productoActualizado.setMarcaZapato(producto.getMarcaZapato());
//             productoActualizado.setGeneroZapato(producto.getGeneroZapato());
//             productoActualizado.setStock(producto.getStock());
//             productoActualizado.setImagenPrincipal(producto.getImagenPrincipal());
//             productoActualizado.setImagenFrontal(producto.getImagenFrontal());
//             productoActualizado.setImagenLateral(producto.getImagenLateral());
//             productoActualizado.setImagenSuperior(producto.getImagenSuperior());
//             return this.productoRepository.save(productoActualizado);

//         }
//         return producto;   
        
//     }

//     @Override
//     public void borrarProducto(long id) {
//         // this.productoRepository.deleteById(id);
//         Producto productoExistente = obtenerProductoPorId(id);
// 		productoExistente.setStock(0);
// 		productoRepository.save(productoExistente);
//     }
// }
