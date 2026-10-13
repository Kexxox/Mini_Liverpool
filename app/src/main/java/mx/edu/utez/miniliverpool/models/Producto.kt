package mx.edu.utez.miniliverpool.models

import java.util.UUID
import mx.edu.utez.sistemaa.R

data class ProductDetail(
    val id: String = UUID.randomUUID().toString(),
    val marca: String,
    val nombre: String,
    val precio: Double,
    val isFreeShipping: Boolean = true,
    val descripcion: String,
    val imagen: Int?,
    val reseñas: List<Review> = emptyList(),
    val favorito: Boolean = false
) {

    //contador
    val promedio: Double
        get() = if (reseñas.isNotEmpty())
            reseñas.map { it.calificacion }
                .average() else 0.0
}

fun getMockProducts(): List<ProductDetail> {

    val reseñaGta = listOf(
        Review(
            NomUsuario = "Kevin",
            comentario = "Llegó en perfectas condiciones además de que está sellado",
            calificacion = 5.0f
        ),
        Review(
            NomUsuario = "Ixaya",
            comentario = "Llegó un poco tarde el envío, pero el producto es bueno",
            calificacion = 3.5f
        ),
        Review(
            NomUsuario = "Cristian",
            comentario = "Demasiado alto el costo para lo poco que contiene",
            calificacion = 2.5f
        ),
        Review(
            NomUsuario = "Gerardo",
            comentario = "Lo recomiendo es vale bastante la pena",
            calificacion = 4.5f
        )
    )

    val reseñaGears = listOf(
        Review(
            NomUsuario = "Felipe",
            comentario = "El diseño E-Day está brutal, la textura del agarre es de lo mejor",
            calificacion = 5.0f
        ),
        Review(
            NomUsuario = "Antonio",
            comentario = "Me encanto, ademas de que esta echo de muy buena calidad y el diseño esta increible",
            calificacion = 4.0f
        )
    )

    val reseñaXbox = listOf(
        Review(
            NomUsuario = "Jose",
            comentario = "Lo mejor, recordando viejas glorias por el 25 aniversario",
            calificacion = 5.0f
        )
    )

    return listOf(
        ProductDetail(
            marca = "Playstation",
            nombre = "Paquete Coleccionista GTA VI",
            precio = 5000.00,
            descripcion = "Edicion Coleccionista del juego en espera de salida GTA VI",
            imagen = R.drawable.gta_6,
            reseñas = reseñaGta
        ),
        ProductDetail(
            marca = "Xbox",
            nombre = "Control Xbox Edicion Gears Of War",
            precio = 1800.00,
            descripcion = "Control de xbox series, edicion gears of war e day",
            imagen = R.drawable.gears,
            reseñas = reseñaGears
        ),
        ProductDetail(
            marca = "Xbox",
            nombre = "Consola Xbox Aniversario 25",
            precio = 18000.00,
            descripcion = "Consola Xbox Series X, edicion aniversario 25 años de microsoft",
            imagen = R.drawable.xbox,
            reseñas = reseñaXbox,
        )
    )
}
