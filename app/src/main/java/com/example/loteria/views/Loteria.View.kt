package com.example.loteria.views

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.example.loteria.viewModels.LoteriaViewModel

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun LoteriaView(viewModel: LoteriaViewModel) {
    val lottoNumbers = viewModel.lottoNumbers.value
    val reintegro = viewModel.reintegro.value

    Scaffold (
        topBar = {
            TopAppBar(
                modifier = Modifier.height(100.dp),
                title = {
                    Row(
                        modifier = Modifier
                            .fillMaxSize(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "Primitiva",
                            color = Color.White,
                            fontSize = 40.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFF388751))
            )

        },
        content = {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(130.dp))
                if (lottoNumbers.isEmpty()) Text(
                    text = "¡¡Obtén tu combinación!! (y si tienes suerte, ¡gana! Pero no me culpes si no ganas nada 😜)",
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    lineHeight = 1.5.em,
                    modifier = Modifier.padding(horizontal = 15.dp)
                )
                else LoteriaNumbers(numbers = lottoNumbers, reintegro = reintegro)
                Spacer(modifier = Modifier.height(40.dp))
                Button(onClick = {
                    viewModel.generateLottoNumbers()
                }) {
                    Text(text = "Generar", fontSize = 25.sp, fontWeight = FontWeight.Bold)
                }
            }
        }
    )

}

@Composable
fun LoteriaNumbers(numbers: List<Int>, reintegro: Int) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
    ) {
        LazyRow(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            contentPadding = PaddingValues(
                horizontal = 16.dp,
                vertical = 8.dp
            )
        ) {
            items(numbers) { number ->
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .padding(horizontal = 4.dp)
                        .size(48.dp)
                        .background(color = Color.Transparent, CircleShape)
                        .border(2.dp, Color(0xFF087940), CircleShape)
                ) {
                    Text(text = number.toString(), color = Color.Black, fontSize = 24.sp)
                }
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(text = "Reintegro", modifier = Modifier.padding(end=10.dp), fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .padding(horizontal = 4.dp)
                    .size(48.dp)
                    .background(color = Color.Transparent, CircleShape)
                    .border(2.dp, Color(0xFFFF1744), CircleShape)
            ) {
                Text(text = reintegro.toString(), color = Color.Red, fontSize = 24.sp)
            }
        }
        
    }
}

