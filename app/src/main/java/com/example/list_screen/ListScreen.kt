package com.example.list_screen

import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val items = listOf(
    ProductCategory(
        R.string.androidPixels,
        listOf(
            R.drawable.pixel_1,
            R.drawable.pixel_2,
            R.drawable.pixel_3,
            R.drawable.pixel4,
        )
    ),
    ProductCategory(
        R.string.pixel1,
        listOf(
            R.drawable.pixel_1,
        )
    ),
    ProductCategory(
        R.string.pixel2,
        listOf(
            R.drawable.pixel_2,
            R.drawable.pixel_2,
        )
    ),
    ProductCategory(
        R.string.pixel3,
        listOf(
            R.drawable.pixel_3,
            R.drawable.pixel_3,
            R.drawable.pixel_3,
        )
    ),
    ProductCategory(
        R.string.pixel4,
        listOf(
            R.drawable.pixel4,
            R.drawable.pixel4,
            R.drawable.pixel4,
            R.drawable.pixel4,
        )
    ),
    ProductCategory(
        R.string.iPhone12,
        listOf(
            R.drawable.iphone,
            R.drawable.iphone,
            R.drawable.iphone,
            R.drawable.iphone,
            R.drawable.iphone,
        )
    )
)

@Composable
fun ListScreen() {
    MyList()
}

@Composable
fun MyList() {
    LazyColumn {
        items(items) { item -> ListItem(item) }
    }
}

@Composable
fun ListItem(productCategory: ProductCategory) {
    Column(modifier = Modifier.padding(10.dp)) {
        Text(
            stringResource(id = productCategory.productResourceId),
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
        )
    }
    Spacer(modifier = Modifier.height(10.dp))
    LazyRow {
        items(productCategory.productImageResource) { items ->
            ProductImage(items)
        }
    }
}

data class ProductCategory(
    @StringRes val productResourceId: Int,
    val productImageResource: List<Int>
)

@Composable
fun ProductImage(imageResource: Int) {
    Image(
        painter = painterResource(id = imageResource),
        contentDescription = null,
        contentScale = ContentScale.Fit,
        modifier = Modifier
            .size(160.dp, 150.dp)
    )
}