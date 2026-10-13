package mx.edu.utez.sistemaa.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import mx.edu.utez.miniliverpool.models.ProductDetail

@Composable
fun ProductoCard(producto: ProductDetail, onClick: () -> Unit) {
    Card(
        modifier = Modifier.padding(8.dp).fillMaxWidth().clickable { onClick() },
        //redondearr
        shape = RoundedCornerShape(15.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        //levantar
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)

                    .clip(RoundedCornerShape(8.dp))
                    .background(Color(0xFFF3E5F5)),
                contentAlignment = Alignment.Center
            ) {
                producto.imagen?.let {
                    Image(painter = painterResource(id = it),
                        contentDescription = producto.nombre)
                }
            }


            Spacer(modifier = Modifier.height(8.dp))

            //(bodyMedium)
            //(maxLines)
            Text(
                text = producto.nombre,
                style = MaterialTheme.typography.bodyMedium,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )

            Spacer(modifier = Modifier.height(4.dp))

            //(titleMedium)
            Text(
                text = "$${producto.precio}",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(8.dp))

            Button(
                onClick = onClick,
                modifier = Modifier.fillMaxWidth().height(40.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF3F8E))
            ) {
                Text(
                    text = "Detalles",
                    color = Color.White,
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProductoCardPreview() {
    val productoPrueba = ProductDetail(
        marca = "Marca Ejemplo",
        nombre = "Bolsa Rosa",
        precio = 499.0,
        descripcion = "Descripción de prueba",
        imagen = null
    )

    ProductoCard(
        producto = productoPrueba,
        onClick = { }
    )
}