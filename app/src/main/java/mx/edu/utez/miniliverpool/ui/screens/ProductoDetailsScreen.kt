package mx.edu.utez.miniliverpool.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import mx.edu.utez.sistemaa.R
import mx.edu.utez.miniliverpool.models.ProductDetail
import mx.edu.utez.miniliverpool.models.Review
import mx.edu.utez.sistemaa.ui.components.ComentarioList

@Composable
fun ProductoDetailsScreen(
    producto: ProductDetail,
    onBackClick: () -> Unit
) {
// Favorito si / no
    var esFavorito by remember { mutableStateOf(producto.favorito) }
// Envio si / no
    var tieneEnvioGratis by remember { mutableStateOf(producto.isFreeShipping) }

    Column(modifier = Modifier.fillMaxSize().systemBarsPadding()) {
        Column(
            modifier = Modifier
                .weight(1f)
                .verticalScroll(rememberScrollState())
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(
                    onClick = onBackClick,
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF3F8E)),
                    modifier = Modifier.size(50.dp),
                    contentPadding = PaddingValues(0.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.flecha_atras),
                        contentDescription = "Volver",
                        modifier = Modifier.size(24.dp)
                    )
                }

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painter = painterResource(id = R.drawable.compartir),
                        contentDescription = "Compartir",
                        modifier = Modifier.size(24.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))

                    IconButton(onClick = { esFavorito = !esFavorito }) {
                        Image(
                            painter = painterResource(//si y no
                                id = if (esFavorito) R.drawable.no_favorito
                                else R.drawable.favorito
                            ),
                            contentDescription = "Favorito",
                            modifier = Modifier.size(28.dp)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(Color(0xFFF3E5F5)),
                contentAlignment = Alignment.Center
            ) {
                producto.imagen?.let {
                    Image(
                        painter = painterResource(id = it),
                        contentDescription = producto.nombre,
                        modifier = Modifier.size(150.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // promedio
            Text(
                text = "${"%.1f".format(producto.promedio)} (${producto.reseñas.size} reseñas)",
                style = MaterialTheme.typography.bodyMedium
            )

            Spacer(modifier = Modifier.height(16.dp))

            Surface(
                onClick = { tieneEnvioGratis = !tieneEnvioGratis },
                shape = RoundedCornerShape(8.dp),
                color = if (tieneEnvioGratis) Color(0xFFE8F5E9)
                else Color(0xFFFFEBEE),
                contentColor = if (tieneEnvioGratis) Color(0xFF2E7D32)
                else Color(0xFFC62828)
            ) {
                Text(
                    text = if (tieneEnvioGratis) "Envio Gratis"
                                            else "Envio con Costo",
                    modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp),
                    style = MaterialTheme.typography.bodyMedium
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            HorizontalDivider()

            Spacer(modifier = Modifier.height(16.dp))

            Text(text = producto.marca,
                style = MaterialTheme.typography.titleMedium)
            Text(text = producto.nombre,
                style = MaterialTheme.typography.headlineSmall)
            Text(text = "$${producto.precio}",
                style = MaterialTheme.typography.headlineMedium)

            Spacer(modifier = Modifier.height(16.dp))

            Text(text = producto.descripcion)

            Spacer(modifier = Modifier.height(24.dp))

            HorizontalDivider()

            Spacer(modifier = Modifier.height(16.dp))

            ComentarioList(reviews = producto.reseñas)

            Spacer(modifier = Modifier.height(16.dp))
        }

        Button(
            onClick = { },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF3F8E))
        ) {
            Text(text = "Comprar")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProductoDetailsScreenPreview() {
    val productoPrueba = ProductDetail(
        marca = "Nintendo",
        nombre = "Mario Odyssey",
        precio = 1300.00,
        isFreeShipping = true,
        descripcion = "Esta es una descripción para ver cómo se acomoda el texto en la pantalla de detalles.",
        imagen = R.drawable.mario,
        favorito = false,
        reseñas = listOf(
            Review("Ana", "Gran juego", 5.0f),
            Review("Beto", "Siss", 3.5f)
        )
    )

    ProductoDetailsScreen(
        producto = productoPrueba,
        onBackClick = { }
    )
}