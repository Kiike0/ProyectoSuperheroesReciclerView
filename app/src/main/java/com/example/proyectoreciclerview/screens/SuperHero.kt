package com.example.proyectoreciclerview.screens

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.proyectoreciclerview.R
import com.example.proyectoreciclerview.Superhero

@Preview(showBackground = true)
@Composable
fun SuperHeroView() {
    val context = LocalContext.current
    LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        items(getSuperheroes()) { superhero ->
            ItemHero(superhero = superhero) {
                Toast.makeText(
                    context,
                    "${superhero.realName}",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}

/*
Con LazyRow............
@Composable
fun ItemHero(superhero: Superhero) {
    Card(border = BorderStroke(2.dp, Color.Red),
        modifier = Modifier
        .width(200.dp)
    ){
        Column(){
            Image(painter = painterResource(id = superhero.idDrawable),
                contentDescription = "SuperHero Avatar",
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            Text(
                text = superhero.superheroName,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Text(
                text = superhero.realName,
                modifier = Modifier.align(Alignment.CenterHorizontally),
                fontSize = 12.sp
            )
            Text(
                text = superhero.publisher,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(2.dp),
                fontSize = 10.sp
            )

        }
    }
}
*/

@Composable
fun ItemHero(superhero: Superhero, onItemSelected: (Superhero) ->
Unit) {
    Card(
        border = BorderStroke(2.dp, Color.Red),
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemSelected(superhero) }
            .padding(2.dp)
    ) {
        Column(){
            Image(painter = painterResource(id = superhero.idDrawable),
                contentDescription = "SuperHero Avatar",
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            Text(
                text = superhero.superheroName,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Text(
                text = superhero.realName,
                modifier = Modifier.align(Alignment.CenterHorizontally),
                fontSize = 12.sp
            )
            Text(
                text = superhero.publisher,
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(2.dp),
                fontSize = 10.sp
            )

        }
    }
}
@Preview(showBackground = true)
@Composable
fun SuperHeroViewDuplicate() {
    val context = LocalContext.current
    LazyVerticalGrid(GridCells.Adaptive(130.dp),
        contentPadding = PaddingValues(horizontal = 4.dp, vertical = 4.dp),
        content = {
        items(getSuperheroes()) { superhero ->
            ItemHeroDuplicate(superhero = superhero) {
                Toast.makeText(
                    context,
                    "${superhero.realName}",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
    )
}
@Composable
fun ItemHeroDuplicate(superhero: Superhero, onItemSelected: (Superhero) ->
Unit) {
    Card(
        border = BorderStroke(2.dp, Color.Red),
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemSelected(superhero) }
            .padding(2.dp)
    ) {
        Column(){
            Image(painter = painterResource(id = superhero.idDrawable),
                contentDescription = "SuperHero Avatar",
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            Text(
                text = superhero.superheroName,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Text(
                text = superhero.realName,
                modifier = Modifier.align(Alignment.CenterHorizontally),
                fontSize = 12.sp
            )
            Text(
                text = superhero.publisher,
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(2.dp),
                fontSize = 10.sp
            )

        }
    }
}


/**
 * Crear una función normal que retorne una lista de elementos de tipo Superhero
 */
fun getSuperheroes() : List<Superhero>{
    val superheroes = mutableListOf<Superhero>()

    superheroes.add(Superhero("Spiderman", "Petter Parker", "Marvel", R.drawable.spiderman))
    superheroes.add(Superhero("Wolverine", "James Howlett", "Marvel", R.drawable.logan))
    superheroes.add(Superhero("Batman", "Bruce Wayne", "DC", R.drawable.batman))
    superheroes.add(Superhero("Thor", "Thor Odinson", "Marvel", R.drawable.thor))
    superheroes.add(Superhero("Flash", "Jay Garrick", "DC", R.drawable.flash))
    superheroes.add(Superhero("Green Lantern", "Alan Scott", "DC", R.drawable.green_lantern))
    superheroes.add(Superhero("Wonder Woman", "Princess Diana", "DC", R.drawable.wonder_woman))

    return superheroes
}