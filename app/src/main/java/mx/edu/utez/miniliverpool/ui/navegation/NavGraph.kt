package mx.edu.utez.sistemaa.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import mx.edu.utez.miniliverpool.models.getMockProducts
import mx.edu.utez.miniliverpool.ui.screens.ProductoDetailsScreen
import mx.edu.utez.sistemaa.ui.screens.ProductoListScreen
import mx.edu.utez.sistemaa.ui.screens.TiendaMenuScreen

@Composable
fun NavGraph() {
    val navController = rememberNavController()
    val productos = getMockProducts()

    NavHost(navController = navController, startDestination = "menu") {
        composable("menu") {
            TiendaMenuScreen(onEntrarClick = { navController.navigate("lista") })
        }
        composable("lista") {
            ProductoListScreen(
                productos = productos,
                onProductClick = { id -> navController.navigate("detalle/$id") },
                onBackClick = { navController.popBackStack() }
            )
        }
        composable("detalle/{productoId}") { backStackEntry ->
            val productoId = backStackEntry.arguments?.getString("productoId")
            val producto = productos.find { it.id == productoId }
            if (producto != null) {
                ProductoDetailsScreen(
                    producto = producto,
                    onBackClick = { navController.popBackStack() }
                )
            }
        }
    }
}