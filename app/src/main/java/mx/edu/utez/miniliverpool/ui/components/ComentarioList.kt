
package mx.edu.utez.sistemaa.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import mx.edu.utez.miniliverpool.models.Review

@Composable
fun ComentarioList(reviews: List<Review>) {
    Column {
        Text(
            text = "Reseñas",
            style = MaterialTheme.typography.titleMedium, //titleMedium texto
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(8.dp))

        if (reviews.isEmpty()) {
            Text(text = "Aún no hay reseñas para este producto")
        } else {
            reviews.forEach { review ->
                ComentarioItem(reseña = review)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ComentarioListPreview() {
    val reseñasPrueba = listOf(
        Review("Martin", "Increible, bastante recomendable y super divertido ", 5.0f),
        Review("Carlos ", "Recibido en buena calida, funcional", 4.0f)
    )
    ComentarioList(reviews = reseñasPrueba)
}