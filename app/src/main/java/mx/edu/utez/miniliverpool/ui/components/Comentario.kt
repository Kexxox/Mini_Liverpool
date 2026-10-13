package mx.edu.utez.sistemaa.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import mx.edu.utez.miniliverpool.models.Review

@Composable
fun ComentarioItem(reseña: Review) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFFFD1DC) // Rosa pastel
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 0.dp)
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = reseña.NomUsuario,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.bodyMedium
                )
                Text(
                    //estrellita
                    text = "★ ${reseña.calificacion}",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = reseña.comentario,
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ComentarioItemPreview() {
    Column {
        ComentarioItem(
            reseña = Review(
                NomUsuario = "Juan",
                comentario = "Excelente producto, superó mis expectativas y llegó a tiempo",
                calificacion = 5.0f
            )
        )
        ComentarioItem(
            reseña = Review(
                NomUsuario = "Elias",
                comentario = "Tardó un poco el envío.",
                calificacion = 4.0f
            )
        )
    }
}