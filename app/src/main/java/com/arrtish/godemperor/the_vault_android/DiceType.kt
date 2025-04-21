package com.arrtish.godemperor.thevault

import android.media.Image
import androidx.compose.ui.graphics.Color
import com.arrtish.godemperor.the_vault_android.R

//import androidx.compose.ui.graphics.R

enum class DiceType(val maxValue: Int, val printName: String, val color: Color, val imageId: Int) {
    DICE_D4(4, "D4", Color(0xFFB2E88F), R.drawable.d4),            // Light Green
    DICE_D6(6, "D6", Color(0xFFE39DEB), R.drawable.d6),            // Light Purple/Pink
    DICE_D8(8, "D8", Color(0xFF4EC5E5), R.drawable.d8),            // Light Blue
    DICE_D10(10, "D10", Color(0xFFDE4F4F), R.drawable.d10_d100_img), // Red
    DICE_D12(12, "D12", Color(0xFFB9D6D3), R.drawable.d12),        // Light Gray
    DICE_D20(20, "D20", Color(0xFFE9B44C), R.drawable.d20)         // Orange/Gold
}
