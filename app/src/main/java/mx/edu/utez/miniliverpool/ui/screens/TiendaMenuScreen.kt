package mx.edu.utez.sistemaa.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import mx.edu.utez.sistemaa.R

@Composable
fun TiendaMenuScreen(onEntrarClick: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize().padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Spacer(modifier = Modifier.weight(1f))

    Image(painter = painterResource(id = R.drawable.liverpool),
        contentDescription = "Logo",
        modifier = Modifier.size(150.dp))

        Text(text = "Bienvenido",
            color = Color(0xFFFF3F8E))//Rosa Liverpool

        Spacer(modifier = Modifier.weight(1f))

        Button(
            onClick = onEntrarClick,
            modifier = Modifier.fillMaxWidth().height(50.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF3F8E))
        ) {
            Text(text = "Entrar")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TiendaMenuScreenPreview() {
    TiendaMenuScreen(
        onEntrarClick = { }
    )
}