// package com.zapateriaspg.app.service.Impl;

// import java.util.List;
// import java.util.Optional;

// import com.zapateriaspg.app.entity.Pedido;
// import com.zapateriaspg.app.repository.PedidoRepository;
// import com.zapateriaspg.app.service.PedidoService;

// public class PedidoServiceImpl implements PedidoService {


//     PedidoRepository pedidoRepository;
//     public PedidoServiceImpl(PedidoRepository pedidoRepository) {
//         this.pedidoRepository = pedidoRepository;
//     }

//     @Override
//     public Pedido obtenerPedidoPorID(long id) {
//         Optional<Pedido> pedidoOptional = pedidoRepository.findById(id);
//         // verifica si el pedido existe
//         if (pedidoOptional.isPresent()) 
//             return pedidoOptional.get();
        
//         else
//             throw new IllegalStateException("El pedido con el id " + id + " no existe");
//    }

//    @Override
//    public List<Pedido> obtenerPedidos() {
//        return (List<Pedido>) pedidoRepository.findAll();
//    }

//    @Override
//    public List<Pedido> obtenerPedidosDeUnUsuario(String email) {
//        return (List<Pedido>) pedidoRepository.findByEmail(email);
//    }

//    @Override
//    public Pedido insertarPedido(Pedido pedido) {
//         pedido.setDireccion(null);
//         pedido.setEmail(null);
//         pedido.setFechaPedido(null);
//         pedido.setIdPedido(0);
//         pedido.setMonto(0);
//         pedido.setUsuario(null);   

//         if(pedidoRepository.existsByEmail(pedido.getEmail())){
//             throw new IllegalStateException("El pedido con el email " + pedido.getEmail() + " ya existe");
//         }
//         return pedidoRepository.save(pedido);
//    }

//    @Override
//    public Pedido actualizarPedido(Pedido pedido, long id) {
//         // Usa el parámetro id para buscar el pedido
//         // Si el pedido no existe, obtenerPedidoPorID lanzará una excepción
//         Pedido pedidoActual = obtenerPedidoPorID(id);
    
//         // Actualiza los campos del pedido
//         pedidoActual.setDireccion(pedido.getDireccion());
//         pedidoActual.setEmail(pedido.getEmail());
//         pedidoActual.setFechaPedido(pedido.getFechaPedido());
//         pedidoActual.setIdPedido(pedido.getIdPedido());
//         pedidoActual.setMonto(pedido.getMonto());
//         pedidoActual.setUsuario(pedido.getUsuario());
    
//         // Guarda el pedido actualizado en el repositorio y devuélvelo
//         return pedidoRepository.save(pedidoActual);
//     }

//    @Override
//     public void eliminarPedido(long id) {   
//         Pedido pedidoExistente  = obtenerPedidoPorID(id);
//         pedidoRepository.delete(pedidoExistente);
    
//     }

// }






