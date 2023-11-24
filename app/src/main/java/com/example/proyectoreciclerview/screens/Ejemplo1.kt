package com.example.proyectoreciclerview.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Preview(showBackground = true)
@Composable
fun SimpleRecyclerView() {
    val myList = listOf("Marta", "Pepe", "Manolo", "Jaime")
    LazyColumn {
        item { Text(text = "Header") }
        items(3) {
            Text(text = "Este es el item $it")
        }
        items(myList) {
            Text(text = "Hola me llamo $it")
        }
        item { Text(text = "Footer") }
    }
}