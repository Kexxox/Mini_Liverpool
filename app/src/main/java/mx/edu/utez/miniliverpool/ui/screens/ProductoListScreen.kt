package mx.edu.utez.sistemaa.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import mx.edu.utez.miniliverpool.models.ProductDetail
import mx.edu.utez.miniliverpool.models.getMockProducts
import mx.edu.utez.sistemaa.ui.components.ProductoCard
import mx.edu.utez.sistemaa.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductoListScreen(
    productos: List<ProductDetail>,
    onProductClick: (String) -> Unit,
    onBackClick: () -> Unit
) {
    var searchQuery by remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp).systemBarsPadding() ) {
        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            Button(
                onClick = { },
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF3F8E)),
                modifier = Modifier.size(50.dp),
                contentPadding = PaddingValues(0.dp)
            ) {
                Image(painter = painterResource(id = R.drawable.flecha_atras),
                    contentDescription = "Volver",
                    modifier = Modifier.size(24.dp).clickable { onBackClick() })
            }
            Spacer(modifier = Modifier.width(8.dp))
            OutlinedTextField(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                modifier = Modifier.weight(1f),
                shape = RoundedCornerShape(12.dp),

            )
            Spacer(modifier = Modifier.width(8.dp))
            Button(
                onClick = { },
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF3F8E)),
                modifier = Modifier.size(50.dp),
                contentPadding = PaddingValues(0.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.lupa),
                    contentDescription = "Buscar",
                    modifier = Modifier.size(24.dp))
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(productos) { producto ->
                ProductoCard(producto = producto,
                    onClick = { onProductClick(producto.id) })
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProductoListScreenPreview() {
    ProductoListScreen(
        productos = getMockProducts(),
        onProductClick = { },
        onBackClick = { }
    )
}